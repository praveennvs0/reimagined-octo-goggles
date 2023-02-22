import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestCommonSubsequenceMemoization {

    
    public static void main(String args[]) {
    	 String s1 = "bsbininm" ;
         String s2 = "jmjkbkjkv" ;
        
        Map<String,String> map = new HashMap<>();
        String longest = LCS(s1,s2,0,0,"",map) ;
        
        
        System.out.println("Longest common subsequence is : " + longest);
        
    }

    private static String LCS(String s1, String s2, int s1_index, int s2_index,String subsequence, Map<String, String> map) {
    	 if(s1_index >= s1.length() || s2_index >= s2.length())  {
    		 String key1 = s1_index + "*" + s2_index + "* " + subsequence;
    		 map.put(key1, subsequence);
             return subsequence ;
         }
    	 
    	String key = s1_index + "*" + s2_index + "* " + subsequence;
        if(map.get(key) != null) {
        	return map.get(key);
        }
        
        if(s1.charAt(s1_index) == s2.charAt(s2_index))  {
            subsequence = subsequence + s1.charAt(s1_index) ;
            String key1 = s1_index + "*" + s2_index + "*" + subsequence;
            String taken = LCS(s1,s2,s1_index+1,s2_index+1,subsequence, map); 
            map.put(key1, taken);
            return taken;
        }
        
        String maxSeq = longer(LCS(s1,s2,s1_index+1,s2_index,subsequence,map),
                LCS(s1,s2,s1_index,s2_index+1,subsequence,map) ) ;
        
        map.put(key, maxSeq);
        
        return maxSeq; 
    }

    private static String longer(String s1, String s2) {
        if(s1.length() > s2.length())
        return s1;
        else
            return s2;
    }
}
