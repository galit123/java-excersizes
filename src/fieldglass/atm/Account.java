package fieldglass.atm;

public class Account {
	private long balance; 
	private long credit;
	
	
	public Account(long balance, long credit) {
		super();
		this.balance = balance;
		this.credit = credit;
	}
	public long getBalance() {
		return balance;
	}
	public void setBalance(long balance) {
		this.balance = balance;
	}
	public void subtractBalance(double amount) {
		this.balance-= amount*100;
	}

	public long getCredit() {
		return credit;
	}
	public void setCredit(long credit) {
		this.credit = credit;
	}
	public void subtractCredit(double amount) {
		this.credit -= amount*100;
	}

}
