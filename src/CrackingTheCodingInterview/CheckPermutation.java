package CrackingTheCodingInterview;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// hints #1, #84, #122, #131
public class CheckPermutation {
	public boolean isPermutation1(String w1, String w2){

		if (w1.length() != w2.length()){
			return false;
		}
		
		byte[] b1 = w1.getBytes();
		Arrays.sort(b1);
		byte[] b2 = w2.getBytes();
		Arrays.sort(b2);
		
		
		String s1 = new String(b1);
		String s2 = new String(b2);
		
		return s1.equals(s2);
				
	}
	
	
	public boolean isPermutation2(String w1, String w2){
		if (w1.length() != w2.length()){
			return false;
		}

		Map<Byte, Integer> set = new HashMap<Byte, Integer>();
		
		byte[] bytes1 = w1.getBytes();
		for (int i = 0; i < bytes1.length; i++){
			int count = 0;
			if (set.containsKey(bytes1[i])){
				count = set.get(bytes1[i]); 
			}
			set.put(bytes1[i], count + 1);
		}
		
		byte[] bytes2 = w2.getBytes();
		for (int i = 0; i < bytes2.length; i++){
			if (!set.containsKey(bytes2[i])){
				return false;
			} else {
				int count = set.get(bytes2[i]);
				count--;
				if (count == 0){
					set.remove(bytes2[i]);
				} else {
					set.put(bytes2[i], count);
				}
			}			
		}
		
		return set.isEmpty();		
	}
	
	private void isPermutation(String w1, String w2){
		System.out.println("\nw1 = " + w1 + ", w2 = " + w2);
		boolean res1 = isPermutation1(w1, w2);		
		boolean res2 = isPermutation2(w1, w2);	
		
		System.out.println("res1 = " + res1);
		System.out.println("res2 = " + res2);

	}
	
	public static void main(String[] args) {
		CheckPermutation p = new CheckPermutation();

		p.isPermutation("riki", "kiri");		
		
		p.isPermutation("kids", "disks");		

		p.isPermutation("kids", "disk");		
		
		p.isPermutation("abba", "baba");	
		
		p.isPermutation("permutation", "mrunoittep");	

		p.isPermutation("permutation", "noitatumrep");

	}

}
