package CrackingTheCodingInterview;

import org.junit.Assert;


// Hints:#23, #97, #130 
public class OneAway {

	private void checkIsOneAway(String w1, String w2, boolean expected){
		System.out.println("\nw1 = " + w1 + ", w2 = " + w2);
		boolean actual = isOneAway(w1, w2);		

		System.out.println("res = " + actual);		
		Assert.assertEquals(expected, actual);
	}

	private boolean isOneAway(String w1, String w2) {
		int diff = w1.length() - w2.length();
		if (diff == 0) {
			return isChangeOneAway(w1, w2);
		} else if (diff == 1) {
			return isAddOneAway(w1, w2);
		} else if (diff == -1) {
			return isAddOneAway(w2, w1);
		}
		return false;				
	}

	private boolean isAddOneAway(String w1, String w2) {
		int countChanges = 0;
		int i = 0;
		int j = 0;
		
		byte[] bytes1 = w1.getBytes();
		byte[] bytes2 = w2.getBytes();

		while (i < w1.length()){
			if ( (j >= w2.length()) || (bytes1[i] != bytes2[j])){
				if (countChanges > 0){
					return false;
				} else {
					countChanges++;
				}
				i++;
			} else {
				i++;
				j++;
			}
		}

		return true;
	}

	private boolean isChangeOneAway(String w1, String w2) {
		int countChanges = 0;

		byte[] bytes1 = w1.getBytes();
		byte[] bytes2 = w2.getBytes();
		for (int i = 0; i < w1.length(); i++){
			if (bytes1[i] != bytes2[i]){
				if (countChanges > 0){
					return false;
				} else {
					countChanges++;
				}
			}
		}

		return true;
	}

	public static void main(String[] args) {
		OneAway p = new OneAway();

		p.checkIsOneAway("pale", "ple", true);

		p.checkIsOneAway("pale", "pales", true);

		p.checkIsOneAway("pale", "bale", true);		

		p.checkIsOneAway("pale", "bake", false);			

		p.checkIsOneAway("pale", "pil", false);			

		p.checkIsOneAway("pale", "pile", true);			
		
		p.checkIsOneAway("pale", "pela", false);			

		p.checkIsOneAway("p", "", true);			

	}


}
