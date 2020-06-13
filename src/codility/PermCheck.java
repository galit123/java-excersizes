package codility;

public class PermCheck {

	public int solution(int[] A) {
		int N = A.length;
		
		if (N == 0){
			return 0;
		}
		
		int sumN = 0;
		int sumA = 0;
		for (int i = 1; i < N + 1; i++){
			sumN += i^2;
			sumA += A[i-1]^2;
		}		
		
		if (sumA == sumN){
			return 1;
		} else {
			return 0;
		}
	}

	public static void main(String[] args) {

		PermCheck p = new PermCheck();
		int ar[] = {10, 4, 3, 8, 9, 2, 1, 6, 7, 5};
		int res = p.solution(ar);
		System.out.println("res = " + res);

		int ar1[] = {4, 1, 3, 2};
		res = p.solution(ar1);
		System.out.println("res = " + res);

		int ar2[] = {9, 4, 3, 8, 9, 3, 1, 6, 7, 5};
		res = p.solution(ar2);
		System.out.println("res = " + res);

	}

}
