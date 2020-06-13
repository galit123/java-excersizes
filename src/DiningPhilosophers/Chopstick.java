package DiningPhilosophers;

public class Chopstick {
	private int inx;

	public Chopstick(int inx) {
		super();
		this.inx = inx;
	}

	public void pick(int i) {
		System.out.println(System.nanoTime() + " philosopher " + i + " pick chopstick " + inx);
	}
}
