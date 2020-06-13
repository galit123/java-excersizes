package codility;

public class PermMissingElem {
	public int solution(int[] A){

		int sumN = 0;
		int sumA = 0;
		for (int i = 1; i <= A.length +1 ; i++){
			sumN += i ;

			if (i < A.length + 1){
				sumA += A[i-1];
			}
		}
		
		return sumN - sumA; 
	}
	
	public static void main(String[] args) {
		PermMissingElem p = new PermMissingElem();
		

		int[] ar = {2, 3, 1, 5};
		int res = p.solution(ar);
		System.out.println(res);
		
		int[] ar1 = {2, 4, 1, 5, 6};
		res = p.solution(ar1);
		System.out.println(res);
		
		int[] ar2 = {};
		res = p.solution(ar2);
		System.out.println(res);

	}
}
