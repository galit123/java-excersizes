package fieldglass.atm;

public class Card {
	private String bankName;
	private long cardNumber;
	private String currency;
	private String cardType;
	
	public Card(String bankName, long cardNumber, String currency, String cardType) {
		super();
		this.setBankName(bankName);
		this.setCardNumber(cardNumber);
		this.setCurrency(currency);
		this.setCardType(cardType);
	}

	public long getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(long cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
}
