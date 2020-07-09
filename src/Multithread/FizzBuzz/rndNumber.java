package Multithread.FizzBuzz;

import java.util.Random;

public class rndNumber {


	public static void main(String[] args) {
		int[] ar = new int[6];

		for (int i = 0; i < 10000; i++){
			int n = getRandom1to5();
			ar[n] += 1;
			
			System.out.println(n);
			
		}
		
		for (int i=1; i < 6; i++){
			System.out.println("ar[" + i + "]=" + ar[i]);			
		}
		System.out.println();			
	}

	

	public static int getRandom1to5(){
		Random rand = new Random();

		// Obtain a number between [0 - 5].
		int n = rand.nextInt(5);

		// Add 1 to the result to get a number from the required range
		// (i.e., [1 - 50]).
		n += 1;

		//System.out.println("n = " + n);
		return n;
	}

}
