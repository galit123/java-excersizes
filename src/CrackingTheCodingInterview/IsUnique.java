package CrackingTheCodingInterview;

import java.util.HashSet;
import java.util.Set;
// hints #44, 117, 132
public class IsUnique {
	
	private boolean isUnique(String str){
		byte[] strBytes = str.getBytes();
		Set<Byte> bytes = new HashSet<Byte>();
		
		for (byte b: strBytes){
			bytes.add(b);
		}		
		return str.length() == bytes.size();		
	}
	
	private boolean isUniqueSingleDS(String w){
		int len = w.length();
		
		for (int i = 0; i < len; i++){
			String curChar = w.substring(i, i + 1);			
			String rest = w.substring(i + 1);

			if (rest.contains(curChar) ){
				return false;
			}
		}
		
		return true;
	}
	
	private void checkIsUnique(String w){
		boolean isunique = isUnique(w);
		System.out.println(w + ", is unique = " + isunique);
		
		isunique = isUniqueSingleDS(w);
		System.out.println(w + ", isUniqueSingleDS = " + isunique);

	}
	
	public static void main(String[] args) {
		
		IsUnique obj = new IsUnique();
		obj.checkIsUnique("fantastic");
		obj.checkIsUnique("abcdefghijklmnop");

	}

}
