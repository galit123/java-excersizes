package Entity;


public class EntityImp implements Entity {

	private int value;

	public EntityImp(int value) {
		this.value = value;
	}

	@Override
	public int getValue() {
		return value;
	}

	@Override
	public String toString() {
		return "[" + value + "]";
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + value;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EntityImp other = (EntityImp) obj;
		if (value != other.value)
			return false;
		return true;
	}


}
