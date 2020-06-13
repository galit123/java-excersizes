package FizzBuzz;

public class DevidedBy5  implements Runnable{

	private PrintNumbers printer;
	public DevidedBy5(PrintNumbers printer) {
		this.printer = printer;
	}

	@Override
	public void run() {
		printer.printDevidedBy5();
	}	
}
