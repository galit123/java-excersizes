package fieldglass.atm;

import java.util.Comparator;

public enum MoneyComparator implements Comparator<Money> {
	instance;

	@Override
	public int compare(Money m1, Money m2) {
		if (m1.getValueInCents() == m2.getValueInCents()){
			return 0;
		} else if (m1.getValueInCents() > m2.getValueInCents()){
			return -1;
		} else {
			return 1;
		}

	}

}
