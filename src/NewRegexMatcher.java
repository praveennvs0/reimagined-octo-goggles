import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class NewRegexMatcher {
    
    public static  boolean solutionFound ;
    
    public static void main(String args[]) {
        
        String s = "GeeksforGeeks" ;
        String p = "aba";
        
        regexHelper(s,p) ;
        
    }
    
    
    private static void regexHelper(String s, String p) {

        Map<Character,String> solution = new HashMap<Character,String>() ;
        
        Set<Character> patternChars = formSetWithChars(p) ;
        
        findRegex(s,p,solution,patternChars) ;
        
        Set<Character> solutionChars = solution.keySet() ;
        
        
        
        if(solutionChars.containsAll(patternChars) && patternChars.containsAll(solutionChars))
        System.out.println("solution found : " + solution );
        else 
        System.out.println("regex does not match");
        
      
        
    }



    private static Set<Character> formSetWithChars(String p) {
        Set<Character> charSet = new HashSet<Character>() ;
        for(int i=0; i < p.length() ; i++) {
            charSet.add(p.charAt(i)) ;
        }
        
        return charSet;
    }


    private static boolean findRegex(String s, String pattern,Map<Character,String> solution ,Set<Character> patternChars) {
        
       
       if(pattern.isEmpty() && solution.isEmpty()){
           return true ;
       }
        
        String current = "" ;
        for(int i=0 ; i < s.length() ; i++) {
            if(!solutionFound) {
            
           current = current + s.charAt(i) ;
           
           String temp = s.replaceAll(current, "X") ;
           char nonXPattern = pattern.charAt(0) ; 
           String firstNonXCharFromThePattern = Character.toString(nonXPattern) ;
           String tempPattern = pattern.replaceAll(firstNonXCharFromThePattern, "X");
           if(isIdenticalPattern(temp,tempPattern)) {
               
               solution.put(nonXPattern, current) ;
               
               String tempSRemoved = temp.replaceAll("X","") ;
               String tempPatternRemoved = tempPattern.replaceAll("X", "");
               
               if(!findRegex(tempSRemoved,tempPatternRemoved,solution,patternChars)) {
                   solution.remove(nonXPattern) ;
               }
                
           }
           
        }
        }
        
        if(solution.keySet().containsAll(patternChars)){
            solutionFound = true ;
            return true ;
        }
        return false ;
        
    }



    public static boolean isIdenticalPattern(String s, String p) {
        if(getCount(s) != getCount(p)) {
            return false ;
        }
        
        boolean isIdenetical = (getCountXFollowedBy(s) == getCountXFollowedBy(p) && 
                getCountSomethingFollowingX(s)== getCountSomethingFollowingX(p)) ;
        
        return isIdenetical ;
    }


    
    private static int getCountXFollowedBy(String s) {
        int count = 0;
        for(int i=0; i < s.length() ; i++) {
            if(s.charAt(i) == 'X' && i+1 < s.length() && s.charAt(i+1) != 'X' ) 
                count++ ;
            
        }
        
        
        return count;
    }

    private static int getCountSomethingFollowingX(String s) {
        int count = 0;
        for(int i=0; i < s.length() ; i++) {
            if(s.charAt(i) == 'X' && i-1 >= 0 && s.charAt(i-1) != 'X' ) 
                count++ ;
            
        }
        
        return count;
    }



    private static int getCount(String s) {
        int count = 0 ;
        for(int i=0 ; i < s.length() ; i++) {
            if(s.charAt(i)=='X') {
                count++;
            }
        }
        return count ;
    }
}
