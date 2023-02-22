import java.util.HashMap;
import java.util.Map;

public class MinStepsAnagram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "leetcode";
		String t = "practice";
		int min = minSteps(s,t);
		System.out.println("min steps is : " + min);
	}

	
	    public static int minSteps(String s, String t) {
	        Map<Character,Integer> sm = buildFrequency(s);
	        Map<Character,Integer> tm = buildFrequency(t);
	        int minSteps = 0;
	        for(int i=0;i<t.length();i++) {
	            char ch = t.charAt(i);
	            if(sm.get(ch) == null) {
	            	minSteps += tm.get(ch);
	            }
	            else if(tm.get(ch) != null && tm.get(ch) < sm.get(ch)) {
	                minSteps += 1;
	            }
	            
	        }
	        
	        return minSteps;
	        
	    }
	    
	    private static Map<Character,Integer> buildFrequency(String s) {
	        Map<Character,Integer> sm = new HashMap<>();
	        for(int i=0;i<s.length();i++) {
	            sm.put(s.charAt(i),1 + sm.getOrDefault(s.charAt(i),0));
	        }
	        return sm;
	    }
}
