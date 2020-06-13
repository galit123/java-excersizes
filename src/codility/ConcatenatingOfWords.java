package codility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConcatenatingOfWords {

	public int solution(String[] words){
		Map<Byte, List<Integer>> prefixes = new HashMap<Byte, List<Integer>>();
		Map<Byte, List<Integer>> suffixes = new HashMap<Byte, List<Integer>>();
		Map<Byte, List<Integer>> singles = new HashMap<Byte, List<Integer>>();
		Map<Byte, List<Integer>> intSingles = new HashMap<Byte, List<Integer>>();

		for (int i = 0; i < words.length; i++){
			byte[] bytes = words[i].getBytes();	
			
			byte pref = bytes[0];	
			byte suff = bytes[bytes.length -1];
			
			List<Integer> sequences = getSequences(bytes);
			
			int prefSize = sequences.get(0);//getPrefSize(words[i]);
			int sufSize = sequences.get(sequences.size() - 1);//getSuffSize(words[i]);			
			//aacccff
			//2, 2, 2
			int loc = sequences.get(0); // 2
			for (int j = 1; j < sequences.size() - 1; j++){
				byte curByte = bytes[loc]; // c
				
				addToMap(intSingles, curByte, sequences.get(j));
				loc += sequences.get(j);
			}
			
			
			if (prefSize == bytes.length){
				addToMap(singles, pref, prefSize);
			} else if (pref == suff){
				if (prefSize > sufSize){
					addToMap(prefixes, pref, prefSize);
				} else if (prefSize == sufSize){
					if (prefixes.containsKey(pref)){
						addToMap(suffixes, suff, sufSize);
					} else {
						addToMap(prefixes, pref, prefSize);
					}
				} else {
					addToMap(suffixes, suff, sufSize);
				}
			} else {
				addToMap(prefixes, pref, prefSize);
				addToMap(suffixes, suff, sufSize);
			}			
		}

		char curChar = 'a';
		int maxLetterLength = 0;
		while (curChar <= 'z'){
			int maxPrefLen = getMax(prefixes.get((byte)curChar));
			int maxSuffLen = getMax(suffixes.get((byte)curChar));
			int sumSingles = getSum(singles.get((byte)curChar));
			int maxIntern = getMax(intSingles.get((byte)curChar));

			int curMax = Math.max((maxPrefLen + maxSuffLen + sumSingles), maxIntern);
			
			if (maxLetterLength < curMax){
				maxLetterLength = curMax;
			}
			curChar++;
		}

		return maxLetterLength;		
	}
	
	private List<Integer> getSequences(byte[] bytes) {
		List<Integer> res = new ArrayList<Integer>();
		int i = 1; // 2, 
		int size = 1; // 2, 

		while (i < bytes.length){// 10
			//aaabbbbfff
			byte cur = bytes[i]; // 
			byte prev = bytes[i-1];
			if (cur == prev){
				size++;
				i++;
			} else {
				res.add(size); // 
				size = 1;
				i++;
			}
		}
		res.add(size); // 

		return res;
	}

	private void addToMap(Map<Byte, List<Integer>> map, byte pref, int prefSize) {
		List<Integer> list = map.get(pref);
		if (list == null){
			list = new ArrayList<Integer>();
		}
		list.add(prefSize);
		map.put(pref, list);		
	}

//	private int getPrefSize(String w){
//		byte[] bytes = w.getBytes();	
//
//		byte cur = bytes[0];			
//		int inx = 0;
//		while ((inx < bytes.length) && (cur == bytes[inx])){
//			inx++;
//		}						
//		return inx;		
//	}
//	
//	private int getSuffSize(String w){
//		byte[] bytes = w.getBytes();	
//
//		int inx = bytes.length - 1;
//		byte cur = bytes[inx];			
//		int size = 0;
//		while ((inx >= 0) && (cur == bytes[inx])){
//			inx--;
//			size++;
//		}
//		return size;
//		
//	}

	private int getSum(List<Integer> list) {
		if (list == null){
			return 0;
		}
		int sum = 0;
		for (int item: list){
			sum += item;
		}
		return sum;
	}


	private int getMax(List<Integer> list) {
		if (list == null){
			return 0;
		}
		int maxVal = 0;
		for (int item: list){
			if (maxVal < item){
				maxVal = item;
			}			
		}

		return maxVal;
	}


	public static void main(String[] args) {
		ConcatenatingOfWords c = new ConcatenatingOfWords();

		String[] ar = {"aabb", "aaaa", "bbab"};
		int res = c.solution(ar);
		MissingInteger.printArr(ar);		
		System.out.println("res:" + res);

		String[] ar1 = {"xxbxx", "xbx", "x"}; //x(2) b(1) x(2), x(1)b(1)x(1),
		res = c.solution(ar1);
		MissingInteger.printArr(ar1);		
		System.out.println("res:" + res);
		
		String[] ar2 = {"dxxxxxxxxxaaadddc", "cbc", "cccd"};
		res = c.solution(ar2);
		MissingInteger.printArr(ar2);		
		System.out.println("res:" + res);

		String[] ar3 = {"dddddddxxxxaaadddd", "dbc", "dcccd"};
		res = c.solution(ar3);
		MissingInteger.printArr(ar3);		
		System.out.println("res:" + res);


	}


}
