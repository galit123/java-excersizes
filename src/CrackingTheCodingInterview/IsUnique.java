package CrackingTheCodingInterview;

import java.util.Arrays;
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

	private boolean isUniqueWithSort(String str){
		char[] chars = str.toCharArray();
		Arrays.sort(chars);

		char prev = 0;
		int i = 0;
		while (i < chars.length){
			if (prev != 0){
				if (chars[i] == prev){
					return false;
				}
			}
			prev = chars[i];
			i++;
		}
		return true;
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

		isunique = isUniqueWithSort(w);
		System.out.println(w + ", isUniqueWithSort = " + isunique);


	}
	
	public static void main(String[] args) {
		
		IsUnique obj = new IsUnique();
		obj.checkIsUnique("fantastic");
		obj.checkIsUnique("abcdefghijklmnop");

	}

}
