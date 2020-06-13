package CallInOrder;

public class ThreadC  extends ThreadBase {

	public ThreadC(Foo foo) {
		super(foo);
	}


	@Override
	public void run() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		getFoo().third();
	}

}
