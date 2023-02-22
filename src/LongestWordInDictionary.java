import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LongestWordInDictionary {

	public static void main(String[] args) {
		String s = "apple";
		List<String> dictionary = new ArrayList<>();
		dictionary.add("zxc");
		dictionary.add("vbn");
		String result = findLongestWord(s,dictionary);
		System.out.println(result);

	}
	
	public static String findLongestWord(String s, List<String> dictionary) {
		List<String> result = new ArrayList<>();
        dictionary.forEach(x-> {
        	
        	if(isSubSequence(s,x)) {
        		result.add(x);
        	}
        		
        	
        });
        
        Collections.sort(result, new Comparator < String > () {
            public int compare(String s1, String s2) {
                return s2.length() != s1.length() ? s2.length() - s1.length() : s1.compareTo(s2);
            }
        });
        
        return result.isEmpty() ? "" :result.get(0);
	}
        
        
private static boolean isSubSequence(String s, String x) {
	int j=0;
	for(int i=0; i< s.length() && j < x.length() ; i++) {
	     if(s.charAt(i) == x.charAt(j)) {
	    	 j++;
	     }
	}
	
	
	return j==x.length();
}

}
