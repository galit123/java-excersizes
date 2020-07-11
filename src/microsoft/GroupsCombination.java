package microsoft;

import java.util.ArrayList;
import java.util.List;

public class GroupsCombination {
	public static void main(String[] args) {
		GroupsCombination c = new GroupsCombination();
		List<String> res = c.getCombinations("AB");
		System.out.println(res);
		
		res = c.getCombinations("ABH");
		System.out.println(res);

	}

	public List<String> getCombinations(String str){
		System.out.println(str);
		List<String> res = new ArrayList<String>();
		if ((str == null) || (str.length() == 0)){
			res.add("");
		} else {
			List<String> list = getCombinations(str.substring(1, str.length()));
			for (String item: list){
				res.add(item);
				res.add(str.charAt(0) + item);
			}
		}
		return res;		
	}

}
