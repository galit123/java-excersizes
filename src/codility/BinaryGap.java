package codility;

public class BinaryGap {
	public int solution(int N) {
		String n = Integer.toBinaryString(N);
		System.out.println("Binary represntation of " + N + " is " + n);
		int candidate = 0;

		int start = n.indexOf("1");
		//		System.out.println("start = " + start);
		// 10001001001011100100
		//  
		if (start < 0){
			return 0;
		}
		int cur = 0;
		for (int i = start + 1; i < n.length(); i++){
			char curChar = n.charAt(i);
			//			System.out.println("i = " + i);
			//			System.out.println("cur = " + cur);
			//			System.out.println("curChar = " + curChar);

			if (curChar == '0'){
				cur++;
			} else {
				if (cur == 0){
					continue;
				} else {
					if (candidate < cur){
						candidate = cur;
					}
					cur = 0;
				}
			}
		}
		return candidate;
	}

	public static void main(String[] args) {
		BinaryGap co = new BinaryGap();
		int x = co.solution(32);		
		System.out.println("32: " +x);

		x = co.solution(9);		
		System.out.println("9: " + x);		

		x = co.solution(529);		
		System.out.println("529: " + x);

		x = co.solution(20 );		
		System.out.println("20: " + x);

		x = co.solution(15 );		
		System.out.println("15: " + x);

		x = co.solution(1041 );		
		System.out.println("1041: " + x);

		x = co.solution(561892 );		
		System.out.println("561892: " + x);
	}

}
