package DiningPhilosophers;

public class DiningPhilosophers {
	private Philosopher[] philosophers;
	private Chopstick[] chopsticks;
	private int n;

	public DiningPhilosophers(int n) {
		this.n = n;
	}

	private void createChopsticks(){
		chopsticks = new Chopstick[n];
		for (int i = 0; i < n; i++){
			chopsticks[i] = new Chopstick(i);
		}
	}

	private void createPhilosophers(){
		philosophers = new Philosopher[n];
		for (int i = 0; i < n; i++){
			philosophers[i] = new Philosopher(chopsticks[i], chopsticks[(i + 1) % n], i);
		}
	}

	private void start(){
		for (int i = 0; i < n; i++){
			Thread thread = new Thread(philosophers[i]);
			System.out.println("Call start " + i + " time " + System.currentTimeMillis());
			thread.start();
		}	

	}

	public static void main(String[] args) {
		DiningPhilosophers dp = new DiningPhilosophers(5);
		dp.createChopsticks();
		dp.createPhilosophers();
		dp.start();
	}

}
