
public class PermutationsOfAString {
	
	public static void main(String[] args) {
		String s = "abc";
		permuteHelper(s,"");
	}

    
    static void permuteHelper(String s,String chosen) {
        if(s.isEmpty()) {
            System.out.println(chosen);
        }
        
        else {
            for(int i=0 ; i < s.length() ; i++) {
                // choose
                char c = s.charAt(i) ;

                permuteHelper(s.substring(0,i)+s.substring(i+1),chosen+c);
                
                
            }
        }
    }
    
    
}
