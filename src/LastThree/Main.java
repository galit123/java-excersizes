package LastThree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
	private static List<Integer> array = new ArrayList<Integer>();
	static {
		array.add(100);
		array.add(23);
		array.add(6);
		array.add(12);
		array.add(18);
		array.add(16);
		array.add(20);
		array.add(11);
		array.add(90);
		array.add(84);
		array.add(73);
		array.add(59);				
		array.add(8);				
		array.add(86);				
		array.add(70);				
		array.add(11);				
		array.add(17);				

	}
	
	public static void findLastThree(Iterator<Integer> iterator){
		findLast(3, iterator);
	}
	
	public static void findLast(int num, Iterator<Integer> iterator){
		
		Integer[] arr = new Integer[num];
		int inx = 0;
		while (iterator.hasNext()){
			Integer item = iterator.next();
			arr[inx % num] = item;
			inx++;
		}

		System.out.println("Number of items in array: " + inx);

		for (int i = 0; i < num; i++){
			System.out.print(arr[inx % num] + " ");
			inx++;
		}	
	}
	

	//84, 73, 90

	public static void main(String[] args) {		
		findLastThree(array.iterator());
	}

}
