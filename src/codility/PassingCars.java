package codility;

public class PassingCars {
	public int solution(int[] A){
		int onesCount = 0;
		int count = 0;
		for (int i = A.length - 1; i >= 0; i--){
			if (A[i] == 1){
				onesCount++;
			} else {
				count += onesCount;
			}
			
			if (count > 1000000000){
				return -1;
			}
		}		
		
		return count;
		
	}
	public static void main(String[] args) {
		PassingCars p = new PassingCars();
		
		int[] A = {0, 1, 0, 1, 1};
		    //     3, 2, 2, 1, 0
		int res = p.solution(A);
		System.out.println(res);
	}

}
