import java.util.HashSet;
import java.util.Set;

public class LongestCommonSubsequence {

    
    public static void main(String args[]) {
        String s1 = "beafd" ;
        String s2 = "abrrff tdx" ;
        
        Set<String> subSeqList = new HashSet<String> () ;
        String longest = LCS(s1,s2,0,0,"",subSeqList) ;
        
        
        System.out.println("Longest common subsequence is : " + longest);
        
    }

    private static String LCS(String s1, String s2, int s1_index, int s2_index,String subsequence,Set<String> subSeqSet) {
        
        if(s1_index >= s1.length() || s2_index >= s2.length()) 
            return subsequence ;
        
        if(s1.charAt(s1_index) == s2.charAt(s2_index))  {
            subsequence = subsequence + s1.charAt(s1_index) ;
            return LCS(s1,s2,s1_index+1,s2_index+1,subsequence,subSeqSet);
        }
        
        String maxSeq = longer(LCS(s1,s2,s1_index+1,s2_index,subsequence,subSeqSet),
                LCS(s1,s2,s1_index,s2_index+1,subsequence,subSeqSet) ) ;
        
        subSeqSet.add(maxSeq) ;
        
        return maxSeq; 
    }

    private static String longer(String s1, String s2) {
        if(s1.length() > s2.length())
        return s1;
        else
            return s2;
    }
}
