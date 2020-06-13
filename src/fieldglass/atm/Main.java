package fieldglass.atm;

import java.sql.SQLException;

import org.junit.Assert;

public class Main {
	private static fieldglass.atm.ATM atmService = new fieldglass.atm.ATM();


	public static void main(String[] args) {
		try {
			atmService.init();
			withdraw(50100, Currency.EUR.name(), false);
			withdraw(800, Currency.EUR.name(), true);
			withdraw(1500, Currency.EUR.name(), true);
			withdraw(350, Currency.EUR.name(), true);

			fail3Times();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			System.out.println("Failed to update ATM database");
		}
	}
	
	private static void fail3Times() throws ClassNotFoundException, SQLException {
		Assert.assertTrue(atmService.isReadyForCard());
		atmService.insertCard("myBank", 1234567890, Currency.EUR.name(), CardType.debit.getName());
		Assert.assertFalse(atmService.isReadyForCard());
		atmService.validate(2345);
		atmService.validate(2345);
		atmService.validate(2345);
		atmService.withdraw(20000, Currency.EUR.name(), false);

		Assert.assertTrue(atmService.isReadyForCard());

		atmService.insertCard("myBank", 1234567890, Currency.EUR.name(), CardType.debit.getName());
		Assert.assertFalse(atmService.isReadyForCard());
		atmService.validate(1234);

	}

	public static void withdraw(long amount, String currencyStr, boolean coinsOnly) throws ClassNotFoundException, SQLException{
		
		Assert.assertTrue(atmService.isReadyForCard());
		atmService.insertCard("myBank", 1234567890, Currency.EUR.name(), CardType.debit.getName());
		Assert.assertFalse(atmService.isReadyForCard());
		atmService.validate(1234);
		atmService.displayAmountAllowedToWithdraw();
		atmService.withdraw(amount, currencyStr, coinsOnly);
		atmService.ejectCard();
		Assert.assertTrue(atmService.isReadyForCard());
		System.out.println();


	}

}
