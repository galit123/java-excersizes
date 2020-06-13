package FizzBuzz;

public class DevidedBy3And5 implements Runnable{
	private PrintNumbers printer;


	public DevidedBy3And5(PrintNumbers printer) {
		this.printer = printer;
	}

	@Override
	public void run() {
		printer.printDevidedBy3And5();
	}

}
