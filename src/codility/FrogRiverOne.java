package codility;

import java.util.HashSet;
import java.util.Set;

public class FrogRiverOne {
	public int solution(int X, int[] A){
		Set<Integer> aSet = new HashSet<Integer>();
		for (int i = 0; i < A.length; i++){
			if(A[i] <= X){
				aSet.add(A[i]);
				if (aSet.size() == X){
					return i;
				}
			}
		}				 
		return -1;	 
	}

	public static void main(String[] args) {
		FrogRiverOne f = new FrogRiverOne();

		int[]A = {1, 3, 1, 4, 2, 3, 5, 4}; 
		int res = f.solution(5, A);
		System.out.println(res);

		int[]B = {1, 3, 1, 4, 2, 3, 5, 4}; 
		res = f.solution(3, B);
		System.out.println(res);

	}
}
