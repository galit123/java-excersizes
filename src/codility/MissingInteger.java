package codility;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class MissingInteger {
	
	public static void printArr(int []A){
		ArrayList<Integer> list = new ArrayList<Integer>();
		Collections.addAll(list, Arrays.stream(A).boxed().toArray(Integer[]::new));
		System.out.println(list);
	}

	public static void printArr(String[] A){
		List<String> list = (List<String>) Arrays.asList(A);
		System.out.println(list);
	}
	
	public int solution(int[] A) {
		Set<Integer> aSet = new HashSet<Integer>();

		for (int i = 0; i < A.length; i++){
			aSet.add(A[i]);
		}
		
		for (int i = 1; i < 1000000; i++){
			if (!aSet.contains(i)){
				return i;
			}
		}
		
		return 1;
	}

	int getBit(int n, int k) {
		return (n >> k) & 1;
	}
//	public int solution1(int[] A) {
//		ArrayList<Integer> list = new ArrayList<Integer>();
//		Collections.addAll(list, Arrays.stream(A).boxed().toArray(Integer[]::new));
//
//		//System.out.println(A);
//		list.sort(Comparator.naturalOrder());
//		int largest = list.get(A.length - 1);
//		int j = 0;
//		int n = 1;
//		while (n < largest){
//			int cur = list.get(j);
//			if (cur == n){
//				j++;
//				n++;
//			} else if (cur > n){
//				return n;
//			} else if (cur < n){
//				j++;
//			}
//		}
//
//		if (largest < 0){
//			largest = 0;
//		}
//		return largest + 1;
//	}

	public static void main(String[] args) {
		MissingInteger co = new MissingInteger();

		int[] ar = {1,6,3,2,1,9,10};
		int[] ar1 = {-1, -10, -30, 1000000};
		int[] ar2 = new int[100000];
		int[] ar3 = {1, 3, 6, 4, 1, 2};
		Random rand = new Random();
		

		for (int i = 0; i < 100000 ;i++){
			ar2[i] = rand.nextInt(1000000);
			//System.out.print(ar2[i] + ", ");
		}

		int res = co.solution(ar);
		System.out.println();
		System.out.println(res);

		res = co.solution(ar1);
		System.out.println();
		System.out.println(res);

		Timestamp start = new Timestamp(System.currentTimeMillis());

		res = co.solution(ar2);
		System.out.println();
		System.out.println(res);

		res = co.solution(ar3);
		System.out.println();
		System.out.println(res);

		Timestamp end = new Timestamp(System.currentTimeMillis());

		long delta = end.getTime() - start.getTime();
		System.out.println("Total time: " + delta + " ms");

	}

}
