
public class Parentheses {

    
    
    public static boolean remove(String s) {
        
        if(isValid(s.toCharArray())) {
            System.out.println(s);
        }
        
        else {
            for(int i=0 ;i < s.length() ; i++) {
            char chToRemove=s.charAt(i) ;
            
            remove(s.substring(0,i) + s.substring(i+1,s.length())) ;
            
            }
        }
        
        
        return false ;
        
    }
    
    private static boolean isValid(char[] cs) {
        char left = '(' , right = ')' ;
        int count = 0;
        for(int i=0 ; i < cs.length ; i++) {
            if(cs[i]==left) {
                count++ ;
            }
            else {
                count-- ;
            }
        }
        
        return count==0;
    }

    public static void main(String args[]) {
        String s = "((()))))))()))" ;
        remove(s) ;
        
    }
}
