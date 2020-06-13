package CallInOrder;

public abstract class ThreadBase implements Runnable {
	private Foo foo;

	public ThreadBase(Foo foo) {
		this.setFoo(foo);
	}

	public Foo getFoo() {
		return foo;
	}

	protected void setFoo(Foo foo) {
		this.foo = foo;
	}
	


}
