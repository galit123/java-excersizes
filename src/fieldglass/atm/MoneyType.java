package fieldglass.atm;

public enum MoneyType {
	bill("bill","slot"), coin("coin","tray");
	
	private String name;
	private String atmApliance;

	private MoneyType(String name, String atmApliance) {
		this.setName(name);		
		this.setAtmApliance(atmApliance);
	}

	public String getAtmApliance() {
		return atmApliance;
	}

	public void setAtmApliance(String atmApliance) {
		this.atmApliance = atmApliance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	} 
}
