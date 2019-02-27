
public class Driver {
    
    public static void permute(String s) {
        permuteHelper("",s) ;
    }
    
    public static void permuteHelper(String prefix,String suffix) {
        System.out.println("prefix is : " + prefix + " suffix is : " + suffix);
        
        if(suffix.length() == 0) {
            System.out.println(prefix);
        }
        
        else {
        
        for(int i=0; i<suffix.length() ; i++) {
            permuteHelper(prefix+suffix.charAt(i),suffix.substring(0,i)+suffix.substring(i+1,suffix.length())) ;
        }
        
        }
    }

    public static void main(String args[]) {
        String s="CAR" ;
      permute(s) ;
      Boolean b ;
      
   
        
        
    }
}
