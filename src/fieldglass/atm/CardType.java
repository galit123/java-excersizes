package fieldglass.atm;

public enum CardType {
	credit("Credit"), debit("Debit");
	
	private String name;

	private CardType(String name) {
		this.setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
