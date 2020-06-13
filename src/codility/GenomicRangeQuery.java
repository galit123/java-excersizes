package codility;

public class GenomicRangeQuery {
	private void writeLastIn(String s, int[] lastSeen, char c, int inx){
		if (s.charAt(inx) == c){
			lastSeen[inx] = inx;
		} else if (inx > 0){
			lastSeen[inx] = lastSeen[inx - 1];
		}
	}
	
	public void initArr(int[] ar, int val){
		for (int i = 0; i < ar.length; i++){
			ar[i] = val;
		}
	}
	
	public int[] solution(String S, int[] P, int[] Q){
		int M = P.length;
		int N = S.length();

		int[] res = new int[M];
		
		int[] lastA = new int[N];
		initArr(lastA, -1);
		
		int[] lastC = new int[N];
		initArr(lastC, -1);
		
		int[] lastG = new int[N];
		initArr(lastG, -1);
		
		int[] lastT = new int[N];
		initArr(lastT, -1);
		
		for (int i = 0; i < N; i++){
			writeLastIn(S, lastA, 'A', i);
			writeLastIn(S, lastC, 'C', i);
			writeLastIn(S, lastG, 'G', i);
			writeLastIn(S, lastT, 'T', i);
		}

		char[] chars = new char[N];
		S.getChars(0, N, chars, 0);
		
		for (int i = 0; i < M; i++){
			if (lastA[Q[i]] >= P[i]){
				res[i] = 1;
			} else if (lastC[Q[i]] >= P[i]){
				res[i] = 2;
			} else if (lastG[Q[i]] >= P[i]){
				res[i] = 3;
			} else if (lastT[Q[i]] >= P[i]){
				res[i] = 4;
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		GenomicRangeQuery g = new GenomicRangeQuery();

		int[] P = {2, 5, 0};
		int[] Q = {4, 5, 6};

		// res =  [2, 4, 1]
		int[] res = g.solution("CAGCCTA", P, Q);
		Rotation.printArr(res);

//		
//		int[] P1 = {1, 5, 0};
//		int[] Q1 = {7, 20, 6};
//
//		// res =  [2, 4, 1]
//		res = g.solution("CGGGGGGGGGAGGGGGGTGGGGGGGGGGT", P1, Q1);
//		Rotation.printArr(res);

	}
}
