package Multithread.CallInOrder;

public class CallInOrder   {	
	
	public static void main(String[] args) {
		Foo foo = new Foo();
		
		System.out.println("running thread B");		
		new Thread( new ThreadB(foo)).start();
		
		System.out.println("running thread A");
		new Thread(new ThreadA(foo)).start();	
		

		System.out.println("running thread C");		
		new Thread(new ThreadC(foo)).start();
		
	}


}
