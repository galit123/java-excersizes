package Squares;

import java.util.ArrayList;
import java.util.List;

public class FindSquareSize {

	public static void main(String[] args) {
		
		FindSquareSize obj = new FindSquareSize();
		List<String> words = new ArrayList<String>();

		words.add("0100000");
		words.add("0011111");
		words.add("0011100");
		words.add("0011100");
		words.add("0000001");
		words.add("1111001");
		words.add("1111101");
		words.add("1111010");
		words.add("1111100");
		words.add("1000010");
		words.add("0111011");				


		int max = obj.findMaxSquareSize(words);
		System.out.println(max);
	}
	
	private int findSquareSize(List<String> words, int i, int j) {
		String w = words.get(i);
		byte[] wBytes = w.getBytes();

		int squareSize = findLineSize(wBytes, j);

		for (int i1 = i + 1; i1 < i + squareSize && i1 < words.size(); i1++ ){
			w = words.get(i1);
			wBytes = w.getBytes();

			int curlineSize = findLineSize(wBytes, j);
			if (squareSize > curlineSize){
				squareSize = curlineSize;
			}
		}
		
		return squareSize;
	}


	private int findMaxSquareSize(List<String> words) {
		int i = 0;
		int maxSize = 0;
		for (String w: words){
			byte[] wBytes = w.getBytes();
			int size = 1;

			for (int j = 0; j < wBytes.length; j+=size){
				byte b = wBytes[j];
				if (b == '1'){
					size = findSquareSize(words, i, j);
					if (size > maxSize){
						maxSize = size;
					}
				}
			}
			i++;
		}
		
		return maxSize ;
	}
	
	
	private int findLineSize(byte[] wBytes, int j) {
		int line = 1;
		for (int j1 = j + 1; j1 < wBytes.length; j1++){
			if (wBytes[j1] != '1'){
				break;
			} else {
				line++;
			}
		}
		return line;
	}


}
