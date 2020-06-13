package fieldglass.atm;

public enum Config {
	instance;
	
	private double debitFee = 2.0;
	private double creditFee = 5.0;
	
	public double getDebitFee() {
		return debitFee;
	}
	public void setDebitFee(double debitFee) {
		this.debitFee = debitFee;
	}
	public double getCreditFee() {
		return creditFee;
	}
	public void setCreditFee(double creditFee) {
		this.creditFee = creditFee;
	}


}
