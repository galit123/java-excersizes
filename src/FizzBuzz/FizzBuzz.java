package FizzBuzz;

public class FizzBuzz {
	
	public static void main(String[] args) {

		printNumbers(100);
		System.out.println();
		printNumbersMultithreads(100);		
	}

	private static void printNumbersMultithreads(int n) {
		PrintNumbers printer = new PrintNumbers(n);
		new Thread(new DevidedBy3(printer)).start();
		new Thread(new DevidedBy5(printer)).start();
		new Thread(new DevidedBy3And5(printer)).start();
		new Thread(new Numbers(printer)).start();

	}
	private static void printNumbers(int n) {
		for (int i=0; i <= n; i++){
			if (((i % 5) == 0) && ((i % 3) == 0)){
				System.out.print("FizzBuzz ");
			} else if (((i % 3) == 0) && ((i % 5) != 0)){
				System.out.print("Fizz ");
			} else if (((i % 5) == 0) && ((i % 3) != 0)){
				System.out.print("Buzz ");
			} else if (((i % 3) != 0) && ((i % 5) != 0)){
				System.out.print(i + " ");
			}
		}
	}

}
