package CallInOrder;

import java.util.concurrent.Semaphore;

public class Foo {
	private Semaphore sem1, sem2;
	
	
	public Foo() {
		super();
		this.sem1 = new Semaphore(1);
		this.sem2 = new Semaphore(1);
		
		try {
			sem1.acquire();
			sem2.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void first(){
		System.out.println("running first");
		sem1.release();		
	};

	public void second(){
		try {
			sem1.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("running second");
		sem1.release();
		sem2.release();
	};

	public void third(){
		try {
			sem2.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("running third");
		sem2.release();
	};

}
