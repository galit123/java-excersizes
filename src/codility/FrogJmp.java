package codility;

public class FrogJmp {
	public int solution(int X, int Y, int D) {
		if (X == Y){
			return 0;
		}
		
		double  x;
		if ((Y - X) % D > 0){
			x = (Y - X)/D + 0.5;
		} else {
			x = (Y - X)/D;
		}
		return (int) Math.round(x);

	}

	public static void main(String[] args) {
		FrogJmp m = new FrogJmp();
		
		int res = m.solution(10, 85, 30);
		System.out.println(res);

		res = m.solution(25, 25, 30);
		System.out.println(res);

		res = m.solution(2, 125, 3);
		System.out.println(res);

		res = m.solution(1000, 124350000, 3);
		System.out.println(res);

		

	}
}
