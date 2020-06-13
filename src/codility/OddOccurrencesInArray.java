package codility;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class OddOccurrencesInArray {
	
	public int solution(int[] A){
		Set<Integer> hashset = new HashSet<Integer>();
		for (int i = 0; i < A.length; i++){
			if (hashset.contains(A[i])){
				hashset.remove(A[i]);
			} else {
				hashset.add(A[i]);
			}
		}
		
		Iterator<Integer> itr = hashset.iterator();
		
		return itr.next().intValue();
	}
	
	
	public static void main(String[] args) {
		OddOccurrencesInArray o = new OddOccurrencesInArray();
		int[] ar = {9, 3, 9, 3, 9, 7, 9};
		int res = o.solution(ar);
		System.out.println(res);

		int[] ar1 = {9};
		res = o.solution(ar1);
		System.out.println(res);

	}

}
