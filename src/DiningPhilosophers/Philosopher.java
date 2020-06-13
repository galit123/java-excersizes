package DiningPhilosophers;

public class Philosopher implements Runnable {
	private Chopstick leftCopstick;
	private Chopstick rightCopstick;
	private int inx;

	public void eat() {
		System.out.println( System.nanoTime()  + " philosopher " + inx + " is eating");		
	}

	public void pickRight() {
		this.rightCopstick.pick(inx);
	}

	public Philosopher(Chopstick leftCopstick, Chopstick rightCopstick, int inx) {
		super();
		this.leftCopstick = leftCopstick;
		this.rightCopstick = rightCopstick;
		this.inx = inx;
	}

	public void pickLeft() {
		this.leftCopstick.pick(inx);
	}
	
	public void runSolution1() {
		if (inx == 0){
			synchronized (rightCopstick) {
				pickRight();
				synchronized (leftCopstick) {
					pickLeft();	
					eat();		
				}
			}
		} else {

			synchronized (leftCopstick) {
				pickLeft();
				synchronized (rightCopstick) {
					pickRight();	
					eat();		
				}
			}
		}
	}

	public void runSolution2() {
		try {
			if (inx == 0){
				Thread.sleep(10000);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		synchronized (leftCopstick) {
			pickLeft();
			synchronized (rightCopstick) {
				pickRight();	
				eat();		
			}
		}
	}


	@Override
	public void run() {
		System.out.println("Start run: " + inx + " time " + System.nanoTime());
		runSolution1();
	}

}
