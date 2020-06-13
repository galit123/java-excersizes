package EqualsHashcode;

class WrongVoucher extends Money {
	public WrongVoucher(int amount, String currencyCode, String store) {
		super(amount, currencyCode);
		this.store = store;
	}
	private String store;
	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof WrongVoucher))
			return false;
		WrongVoucher other = (WrongVoucher)o;
		boolean currencyCodeEquals = (this.currencyCode == null && other.currencyCode == null)
				|| (this.currencyCode != null && this.currencyCode.equals(other.currencyCode));
		boolean storeEquals = (this.store == null && other.store == null)
				|| (this.store != null && this.store.equals(other.store));
		return this.amount == other.amount && currencyCodeEquals && storeEquals;
	}
	// other methods
	
	public static void main(String[] args) {
		Money cash = new Money(42, "USD");
		WrongVoucher voucher = new WrongVoucher(42, "USD", "Amazon");
		 
		boolean first = voucher.equals(cash); //=> false // As expected.
		boolean second = cash.equals(voucher); //=> true // That's wrong.
		
		System.out.println("first = " + first);
		System.out.println("second = " + second);


	}
}