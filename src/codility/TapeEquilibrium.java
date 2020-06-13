package codility;

public class TapeEquilibrium {

	public int solution(int[] A){
		int arraySum = 0;

		for (int i = 0; i < A.length; i++){
			arraySum += A[i];
		}
		
		int[] P = new int[A.length];

		int p1 = 0;
		int p = 0;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < A.length - 1; i++){
			p += A[i]; 
			p1 = arraySum - p;
			P[i+1] = Math.abs(p - p1);
			if (min > P[i+1]){
				min = P[i+1];
			}
		}
				
		return min;

	}
	//			A[0] = 3
	//			A[1] = 1
	//			A[2] = 2
	//			A[3] = 4
	//			A[4] = 3
	//     A   =     [3, 1, 2, 4, 3]    sum = 13
	//
	//     sum =     [3, 4, 6, 10, 13]
	//               
	//     reverse = [13, 10 ,9 ,7 ,3]
	
	//			We can split this tape in four places:
	//
	//			P = 1, difference = |3 − 10| = 7 
	//			P = 2, difference = |4 − 9| = 5 
	//			P = 3, difference = |6 − 7| = 1 
	//			P = 4, difference = |10 − 3| = 7 

	public static void main(String[] args) {
		TapeEquilibrium t = new TapeEquilibrium();
		
		int[] ar = {3, 1, 2, 4, 3};
		int res = t.solution(ar);
		System.out.println("res = " + res);
	}
}
