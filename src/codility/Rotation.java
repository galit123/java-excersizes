package codility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Rotation {
	public int[] solution(int[] A, int K) {
		if ((A.length == K) || (A.length == 0) || (K == 0)){
			return A;
		}

		for (int j = 0; j < K % A.length; j++){
			int tmp = A[A.length - 1];
			for (int i = A.length - 1; i > 0 ; i--){
				A[i] = A[ i - 1];
			}
			A[0] = tmp;
		}
		return A;

	}

	public static void main(String[] args) {
		Rotation r = new Rotation();
		int[] ar = {3, 8, 9, 7, 6};
		printArr(ar);		
		int[] newAr = r.solution(ar, 3);
		printArr(newAr);
		
		int[] ar1 = {1, 2, 3, 4};
		printArr(ar1);				
		newAr = r.solution(ar1, 4);
		printArr(newAr);
		
		int[] ar2 = {0, 0, 0};
		printArr(ar2);				
		newAr = r.solution(ar2, 1);
		printArr(newAr);
		
		
		
		
	}

	public static void printArr(int []A){
		ArrayList<Integer> list = new ArrayList<Integer>();
		Collections.addAll(list, Arrays.stream(A).boxed().toArray(Integer[]::new));
		System.out.println(list);
	}

}
