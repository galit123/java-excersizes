package Anagram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
	
	private static List<String> words = new ArrayList<String>();
	private static Map<String, List<String>> anagramsMap = new HashMap<String, List<String>>();
	
	static {
		words.add("aba");
		words.add("aab");
		words.add("disk");
		words.add("baa");
		words.add("kids");
		words.add("kisd");
		words.add("kiss");
		words.add("issk");
		words.add("ssik");
		words.add("ab");
		words.add("a");				
	}
	
    public static String sortString(String inputString) 
    { 
        // convert input string to char array 
        char tempArray[] = inputString.toCharArray(); 
          
        // sort tempArray 
        Arrays.sort(tempArray); 
          
        // return new sorted string 
        return new String(tempArray); 
    }   
	
	private static void findAnagrams(){
		
		for (String w: words){
			String w1 = sortString(w);
			List<String> list = null;
			if (!anagramsMap.containsKey(w1)){
				list = new ArrayList<String>();				
				anagramsMap.put(w1, list);
			} else {
				list = anagramsMap.get(w1);
			}
			list.add(w);
		}
		
		for (String k : anagramsMap.keySet()){
			List<String> list = anagramsMap.get(k);
			System.out.println(list);
		}
		
	}	
	
	public static void main(String[] args) {
		findAnagrams();
	}

}
