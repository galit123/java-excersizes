package EqualsHashcode;

class Voucher {
	 
    private Money value;
    private String store;
 
    Voucher(int amount, String currencyCode, String store) {
        this.value = new Money(amount, currencyCode);
        this.store = store;
    }
 
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Voucher))
            return false;
        Voucher other = (Voucher) o;
        boolean valueEquals = (this.value == null && other.value == null)
          || (this.value != null && this.value.equals(other.value));
        boolean storeEquals = (this.store == null && other.store == null)
          || (this.store != null && this.store.equals(other.store));
        return valueEquals && storeEquals;
    }
 
    // other methods
    
    public static void main(String[] args) {
		Money cash = new Money(42, "USD");
		Voucher voucher = new Voucher(42, "USD", "Amazon");
		 
		boolean first = voucher.equals(cash); //=> false // As expected.
		boolean second = cash.equals(voucher); //=> true // That's wrong.
		
		System.out.println("first = " + first);
		System.out.println("second = " + second);

//		Always override hashCode() if we override equals()
//		Override equals() and hashCode() for value objects
//		Be aware of the traps of extending classes that have overridden equals() and hashCode()
//		Consider using an IDE or a third-party library for generating the equals() and hashCode() methods
//		Consider using EqualsVerifier to test our implementation

	}
}