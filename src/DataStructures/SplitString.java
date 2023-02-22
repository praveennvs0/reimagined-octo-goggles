package DataStructures;

import java.util.ArrayList;
import java.util.List;

public class SplitString {
	static int max = 0;
	public static void main(String[] args) {
		String s = "aa";
		maxUniqueSplit(s);
		System.out.println("Maximal Split is : " + max);
	}

	private static int  maxUniqueSplit(String s) {
		List<String> result = new ArrayList<>();
		maxUniqueSplit(s,0,result);
		return max;
	}

	private static void maxUniqueSplit(String s,int index, List<String> result) {
		if(index == s.length()) {
			max = Math.max(max, result.size());
//			System.out.println("Split found : ");
//			result.forEach(x->{System.out.print(x); System.out.print(",");});
//			System.out.println();
			return ;
		}
		
		for(int i=index;i<=s.length();i++) {
			String substring = s.substring(index, i);
			if(!substring.isEmpty() && !result.contains(substring)) {
				result.add(substring);
				maxUniqueSplit(s,i,result);
				if(result.size() >= 1 ) { 
				result.remove(result.size()-1);
			}
			}
		}
	}

}
