package fieldglass.atm;

public enum CardStatus {
	readyForCard("Ready for card"), notReadyForCard("NOT ready for card");
	
	private String status;

	private CardStatus(String status) {
		this.setStatus(status);
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	} 
	
	

}
