package microsoft;

import java.util.HashSet;
import java.util.Set;

public class ParenthesisCombinations {
	
	public static void main(String[] args) {
		ParenthesisCombinations c = new ParenthesisCombinations();
		Set<String> res = c.getCombinations(1);
		System.out.println("n = 1, " + res);

		res = c.getCombinations(2);
		System.out.println("n = 2, " + res);

		res = c.getCombinations(3);
		System.out.println("n = 3, "  + res);
		
		res = c.getCombinations(4);
		System.out.println("n = 4, "  + res);

	}
	
	public Set<String> getCombinations(int n){
		Set<String> res = new HashSet<String>();
		if (n == 0){
			res.add("");			
		} else {
			Set<String> list = getCombinations(n-1);
			for (String item: list){
				res.add("()" + item);
				res.add(item + "()");
				res.add("(" + item + ")");
			}
			
		}
		return res;
	}

}
