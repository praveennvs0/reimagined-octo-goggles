import java.util.Map;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class IteratorForCombinations {

	SortedSet<String> ts
    = new TreeSet<String>();
	static Map<Integer,SortedSet<String>> map = new TreeMap<>();
	public static void main(String[] args) {
		String s = "abc";
		findCombination(s);
		System.out.println("Combinations");
	}

	private static void findCombination(String s) {
       findCombination(s,"",0);		
	}

	private static void findCombination(String s, String result, int index) {

		if(s == null)
			return ;
		if(result.length() > 0 ) {
		SortedSet<String> currSet = map.getOrDefault(result.length(),new TreeSet<String>());
		currSet.add(result);
		map.put(result.length(),currSet);
		System.out.println(result);
		}
		for(int i=0;i<s.length();i++) {
			findCombination(s.substring(i+1),result+s.charAt(i),index) ;
			
		}
	}
}
