package fieldglass.atm;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ATM {

	private List<Card> confiscatedCards = new ArrayList<Card>();
	private Card cardInSlot = null;
	private Integer VALID_PIN = 1234;
	private boolean isValidated = false;
	private int wrongValidationCount = 0;
	private Account account = new Account(1000000, 800000);
	private Map<Money, Integer> moneyArray = new HashMap<Money, Integer>();
	
	public void init() throws ClassNotFoundException, SQLException{
		// money currently in ATM
		moneyArray.put(new Money(Currency.EUR, MoneyType.bill, 50000), 0);
		moneyArray.put(new Money(Currency.EUR, MoneyType.bill, 20000), 5);
		moneyArray.put(new Money(Currency.EUR, MoneyType.bill, 10000), 5);
		moneyArray.put(new Money(Currency.EUR, MoneyType.bill, 5000), 5);
		moneyArray.put(new Money(Currency.EUR, MoneyType.bill, 2000), 5);
		moneyArray.put(new Money(Currency.EUR, MoneyType.bill, 1000), 10);
		moneyArray.put(new Money(Currency.EUR, MoneyType.bill, 500), 10);
		moneyArray.put(new Money(Currency.EUR, MoneyType.coin, 200), 10);
		moneyArray.put(new Money(Currency.EUR, MoneyType.coin, 100), 10);
		moneyArray.put(new Money(Currency.EUR, MoneyType.coin, 50), 12);
		moneyArray.put(new Money(Currency.EUR, MoneyType.coin, 20), 12);
		moneyArray.put(new Money(Currency.EUR, MoneyType.coin, 10), 5);
		moneyArray.put(new Money(Currency.EUR, MoneyType.coin, 5), 5);
		moneyArray.put(new Money(Currency.EUR, MoneyType.coin, 2), 10);
		moneyArray.put(new Money(Currency.EUR, MoneyType.coin, 1), 10);

		moneyArray.put(new Money(Currency.USD, MoneyType.bill, 10000), 5);
		moneyArray.put(new Money(Currency.USD, MoneyType.bill, 5000), 12);
		moneyArray.put(new Money(Currency.USD, MoneyType.bill, 2000), 12);

		updateMoneyStatus();
	}

	private void updateMoneyStatus() throws ClassNotFoundException, SQLException {
		Connection conn = DBAdapter.instance.getConnection();
		try {
			for (Money m : moneyArray.keySet()) {
				DBAdapter.instance.upsert(conn, m, moneyArray.get(m));
			}
		} finally {
			conn.close();
		}
	}

	public boolean isReadyForCard() {
		if (cardInSlot != null) {
			System.out.println(CardStatus.notReadyForCard.getStatus());
		} else {
			System.out.println(CardStatus.readyForCard.getStatus());
		}
		return (cardInSlot == null);

	}

	public void insertCard(String bankName, long cardNumber, String currency, String cardType) {
		cardInSlot = new Card(bankName, cardNumber, currency, cardType);
		System.out.println(cardInSlot.getCardType() + " Card was inserted");
	}

	public boolean validate(int pin) {
		if (this.VALID_PIN.equals(pin)) {
			System.out.println("Card is validated");
			this.isValidated = true;
		} else {
			System.out.println("Card is NOT validated");
			this.isValidated = false;

			this.wrongValidationCount++;
			if (this.wrongValidationCount > 2) {
				confiscatedCards.add(cardInSlot);
				clearCard();
			}
		}
		return this.isValidated;
	}

	public void displayAmountAllowedToWithdraw() {
		if (!this.isValidated) {
			System.out.println("Card is NOT validated");
			return;
		}

		double amount = (CardType.credit.equals(cardInSlot.getCardType())) ? account.getCredit() : account.getBalance();
		System.out.printf("Amount allowed to withdraw is %.2f %s\n", amount / 100, cardInSlot.getCurrency());

	}

	public Map<Money, List<Money>> withdraw(long amountInCents, String currencyStr, boolean coinsOnly) throws ClassNotFoundException, SQLException {
		if (!this.isValidated) {
			System.out.println("Card is NOT validated");
			return null;
		}

		Map<Money, List<Money>> withdrawResult = new HashMap<Money, List<Money>>();
		List<Money> moneyList = new ArrayList<Money>();

		// filter by currencyStr
		for (Money el : moneyArray.keySet()) {
			if (el.getCurrency().name().equals(currencyStr)) {
				moneyList.add(el);
			}
		}
		moneyList.sort(MoneyComparator.instance);

		// calculate fee
		double total = (CardType.credit.equals(cardInSlot.getCardType())) ? Config.instance.getCreditFee()
				: Config.instance.getDebitFee();

		long remains = amountInCents;
		for (Money m : moneyList) {
			if (!coinsOnly || (coinsOnly && MoneyType.coin.equals(m.getType()))) {
				int div = (int) (remains / m.getValueInCents());
				int amountExists = moneyArray.get(m);
				List<Money> moneyWidthrowList = new ArrayList<Money>();
				if ((div > 0) && (amountExists > 0) && (remains > 0)) {
					int count = Math.min(amountExists, div);
					for (int i = 0; i < count; i++) {
						moneyWidthrowList.add(new Money(m.getCurrency(), m.getType(), m.getValueInCents()));
						total += m.getValue();
						moneyArray.put(m, --amountExists);
						remains -= m.getValueInCents();
					}
					withdrawResult.put(m, moneyWidthrowList);
				}
			}
		}

		// print money withdrawn ascending order
		for (int i = moneyList.size() - 1; i >= 0; i--) {
			Money m = moneyList.get(i);
			List<Money> moneyWidthrowList = withdrawResult.get(m);
			if (moneyWidthrowList != null) {
				for (Money e : moneyWidthrowList) {
					System.out.printf("%.2f %s dispensed via %s %s\n", e.getValue(), currencyStr, e.getType().getName(),
							e.getType().getAtmApliance());
				}
			}
		}

		// subtract the amount from the account balance or credit
		if (CardType.credit.equals(cardInSlot.getCardType())) {
			account.subtractCredit(total);
		} else {
			account.subtractBalance(total);
		}

		// print the total subtracted from the account
		System.out.printf("%.2f %s withdrawn from %s account\n", total, currencyStr, cardInSlot.getCardType());

		updateMoneyStatus();
		return withdrawResult;
	}

	public void ejectCard() {
		clearCard();
		System.out.println("Card was ejected");

	}

	private void clearCard() {
		cardInSlot = null;
		isValidated = false;
		wrongValidationCount = 0;

	}
}
