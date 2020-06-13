package FizzBuzz;

public class DevidedBy3 implements Runnable{
	private PrintNumbers printer;

	public DevidedBy3(PrintNumbers printer) {
		super();
		this.printer = printer;
	}

	@Override
	public void run() {
		printer.printDevidedBy3();
	}
}
