package CrackingTheCodingInterview;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Assert;

public class StringCompression {
	public String stringCompression(String w){
		List<CompressedChar> chars = new ArrayList<CompressedChar>();
		
		int i = 0;
		byte[] bytes = w.getBytes();
		
		while (i < w.length()) {
			if  ((i == 0) || (bytes[i] != bytes[i-1])) {
				chars.add(new CompressedChar((char)bytes[i]));
			} else {
				chars.get(chars.size()-1).increaseOccurances();
			}
			i++;
		}
		
		StringBuilder sb = new StringBuilder();		
		
		Iterator<CompressedChar> itr = chars.iterator();
		while (itr.hasNext()){
			CompressedChar cur = itr.next();
			sb.append((char)cur.getCharacter()).append(cur.getOccurances());
			
		}
		
		if (sb.length() < w.length()){
			return sb.toString();
		} else {
			return w;
		}
	}
	
	public void checkStringCompression(String w, String expected) {
		String actual = stringCompression(w);
		System.out.println(w  + " - " + expected + " - " + actual);
		
		Assert.assertEquals(expected, actual);

	}
	
	public static void main(String[] args) {
		StringCompression s = new StringCompression();
		s.checkStringCompression("aabcccccaaa",  "a2b1c5a3");
		s.checkStringCompression("aaaaabaaaxxxxxx",  "a5b1a3x6");
		
		s.checkStringCompression("abcdefgh",  "abcdefgh");
		s.checkStringCompression("",  "");


	}
}
