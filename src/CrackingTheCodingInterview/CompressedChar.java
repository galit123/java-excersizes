package CrackingTheCodingInterview;

public class CompressedChar {
	private char character;
	private int occurances;
	
	public char getCharacter() {
		return character;
	}
	public CompressedChar(char character) {
		super();
		this.character = character;
		this.occurances = 1;
	}
	public void setCharacter(char character) {
		this.character = character;
	}
	public int getOccurances() {
		return occurances;
	}
	public void setOccurances(int occurances) {
		this.occurances = occurances;
	}
	public void increaseOccurances() {
		this.occurances += 1;
	}

}
