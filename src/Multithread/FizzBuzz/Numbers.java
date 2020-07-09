package Multithread.FizzBuzz;

public class Numbers implements Runnable{
	private PrintNumbers printer;

	public Numbers(PrintNumbers printer){
		this.printer = printer;
	}

	@Override
	public void run() {
		printer.printNumbers();
	}
}
