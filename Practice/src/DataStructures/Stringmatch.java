package DataStructures;

public class Stringmatch {
    
    public static void main(String []args) {
        String s = "forforjavafo" ;
        String substr = "for";
        findMatches(s,substr) ;
    }

    public static void findMatches(String s,String substr) {
        
        int j= 0, sublen = 0 ;
        for(int i=0 ; i < s.length() ; i++) {
            if(s.charAt(i) == substr.charAt(0)) {
                //possible match. 
            if(isRightMatch(s,i,substr)) {
                int endIndex = i + substr.length() ;
                System.out.println("Match starts at index : " + i +" and ends at index : " + endIndex );
            }
            }
            
        }
    }

    private static boolean isRightMatch(String s, int startIndex, String substr) {
        int count = 0;
        for(int i=startIndex,j=0; i< s.length() && j < substr.length(); i++,j++) {
            char stringchar = s.charAt(i) ;
            char substringchar = substr.charAt(j) ;
            if( stringchar!= substringchar) {
                return false ;
            }
            else{
                count++ ;
        }
        }
        
        
        return count==substr.length();
    }
}
