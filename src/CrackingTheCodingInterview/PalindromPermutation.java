package CrackingTheCodingInterview;

import java.util.HashSet;
import java.util.Set;

public class PalindromPermutation {
	public boolean isPlaindromPermutation(String w){
		String noSpaces = w.replaceAll("\\s","");

		byte[] bytes = noSpaces.getBytes();
		Set<Byte> set = new HashSet<Byte>();
		
		for (int i = 0; i < bytes.length; i++){
			if (set.contains(bytes[i])){
				set.remove(bytes[i]);
			} else {
				set.add(bytes[i]);
			}
			
		}
		
		return (set.size() == 1) || (set.size() == 0);
	}
	
	public static void main(String[] args) {
		PalindromPermutation p = new PalindromPermutation();
		
		boolean res = p.isPlaindromPermutation("tact coa");
		System.out.println("res = " + res);
	}

}
