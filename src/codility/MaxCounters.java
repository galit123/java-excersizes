package codility;

import java.util.Random;

public class MaxCounters {
	public int[] solution(int N, int[] A){
		int M = A.length; 

		int[] res = new int[N];
		for (int i = 0; i < N; i++){
			res[i] = 0;
		}

		int max = 0;
		int maxCounter = 0;
		
		for (int k = 0; k < M; k++){
			int X = A[k];

			if ((1 <= X) && (X <= N)) {
				int inx = X - 1;
				res[inx] = Math.max(res[inx],  maxCounter);
				res[inx] += 1;
				
				max = Math.max(max, res[inx]);
			} else if (A[k] > N){
				maxCounter = max;
			} 
			
		}

		for (int i = 0; i < N; i++){
			res[i] = Math.max(maxCounter, res[i]);
		}

		return res;
	}
	
	public static void main(String[] args) {
		 int[] A = {3, 4, 4, 6, 1, 4, 4};
		 
		 MaxCounters m = new MaxCounters();
		 int[] res = m.solution(5, A);
		 Rotation.printArr(res);

		 int[] B = {};
		 res = m.solution(5, B);
		 Rotation.printArr(res);

			Random rand = new Random();


		 int[] C = new int[10000];
		 for (int i = 0; i < 10000; i++){
			 C[i] = rand.nextInt(6) + 1; 
 		 }
		 
		 //Rotation.printArr(C);
		 res = m.solution(6, C);
		 Rotation.printArr(res);

	}
}
