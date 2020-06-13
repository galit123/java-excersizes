package FizzBuzz;

import java.util.function.Predicate;

public class PrintNumbers {
	private int n;
	private Printer printer;
	private int current = 0;
	private static Object lock = new Object();

	public void printDevidedBy3(){
		printNext(p -> (((p % 3) == 0) && ((p % 5) != 0)), "Fizz ");
	}	
	
	private void printNext(Predicate<Integer> predicate, String toPrint){
		while (true){
			synchronized (lock) {
				if (current > n){
					return;
				}
				if (predicate.test(current)){
					if (toPrint == null){
						printer.print(current + " ");
					} else {
						printer.print(toPrint);
					}
					current++;
				}
			}
		}

	}

	public void printNumbers(){
		printNext(p -> (((p % 3) != 0) && ((p % 5) != 0)), null);
	}

	public void printDevidedBy5(){
		printNext(p -> (((p % 5) == 0) && ((p % 3) != 0)), "Buzz ");
	}

	public void printDevidedBy3And5(){
		printNext(p -> (((p % 5) == 0) && ((p % 3) == 0)), "FizzBuzz ");
	}


	public PrintNumbers(int n) {
		super();
		this.n = n;
		this.printer = new Printer();
	}

}
