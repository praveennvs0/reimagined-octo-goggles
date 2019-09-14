import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Anagrams {

	public static void main(String args[]) {
		
		ArrayList<String> places = new ArrayList<String>(
			    Arrays.asList("code","doce","ecod","frame","framer"));
		List<String> anagrams = funWithAnagrams(places) ;
		System.out.println("hello") ;
	}
	
	public static List<String> funWithAnagrams(List<String> s) {
	    // Write your code here
		List<String> anagramRemovedList = new ArrayList<String>() ;
	    List<Integer> indicesToBeRemoved = new ArrayList<Integer>();
	    for(int i=1; i< s.size() ; i++) {
	        for(int j=0;j<i;j++) {
	        	boolean isAnagram = isAnagram(s.get(j),s.get(i)) ;
	        	if(isAnagram) {
	        		indicesToBeRemoved.add(i);
	        		break ;
	        	}
	        		
	        }
	    }
	    
	    int index=0;
	    for(String string : s) {
	    	if(!indicesToBeRemoved.contains(index)) {
	    		anagramRemovedList.add(string) ;
	    	}
	    	index++;
	    }
	    	
	    return anagramRemovedList ;
	    
	    }

	private static boolean isAnagram(String s1, String s2) {
		if(s1.length() != s2.length()) 
			return false;
		
		char[] ch1 = s1.toCharArray() ;
		char[] ch2 = s2.toCharArray() ;
		Arrays.sort(ch1);
		Arrays.sort(ch2);
		String sortedString1 = new String(ch1) ;
		String sortedString2 = new String(ch2) ;
		
		return sortedString1.equals(sortedString2);
	}
}
