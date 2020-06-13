package fieldglass.atm;

public class Money {
	private MoneyType type;
	private long valueInCents;	
	private Currency currency;
		
	public Money(Currency currency, MoneyType type, long valueInCents) {
		super();
		this.type = type;
		this.valueInCents = valueInCents;
		this.currency = currency;
	}
	
	public MoneyType getType() {
		return type;
	}
	public void setType(MoneyType type) {
		this.type = type;
	}
	public long getValueInCents() {
		return valueInCents;
	}
	public void setValueInCents(long value) {
		this.valueInCents = value;
	}

	public double getValue() {
		return getValueInCents() / 100.0;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

}
