package FizzBuzz;

import java.util.Random;

import codility.Rotation;

public class SortZerosAndOnes {

	public int[] solution(int[] A){		

		int j = A.length - 1;
		int i = 0;
		int[] res = new int[A.length];

		int count = 0;
		while (i <= j){
			int left = A[i];
			int right = A[j];

			if (left < right){
				res[i] = A[i];
				res[j] = A[j];
				i++;
				j--;
			} else if (left > right) {
				res[i] = right;
				res[j] = left;

				i++;
				j--;
			} else {
				if (left == 0){
					res[i] = left;
					i++;
				} else {
					res[j] = right;
					j--;
				}
			}
			count++;

		}
		
		System.out.println("count = " + count);

		return res;

	}

	public static void main(String[] args) {
		SortZerosAndOnes s = new SortZerosAndOnes();
		Random rand = new Random();

		int N = 100;

		for (int n = 0; n < 10; n++){
			int[] A = new int[N];
			for (int i = 0; i < N; i++){
				A[i] = rand.nextInt(2);
			}
		
			Rotation.printArr(A);

			int[] res = s.solution(A);	
			Rotation.printArr(res);
			System.out.println();
		}

			int[] B = {0, 1, 0, 1, 1, 0, 0, 1, 1, 1};
			Rotation.printArr(B);

			int[] res = s.solution(B);	
			Rotation.printArr(res);
			System.out.println();

			int[] C = {0, 1, 0, 0, 0, 0, 0, 0, 0, 0};
			Rotation.printArr(C);

			res = s.solution(C);	
			Rotation.printArr(res);
			System.out.println();

			int[] D = {0, 0, 0, 0, 1, 0, 0, 0, 0, 0};
			Rotation.printArr(D);

			res = s.solution(D);	
			Rotation.printArr(res);
			System.out.println();

			int[] E = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
			Rotation.printArr(D);

			res = s.solution(E);	
			Rotation.printArr(res);
			System.out.println();


	}

}
