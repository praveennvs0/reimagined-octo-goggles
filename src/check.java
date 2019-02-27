
public class check {

    
    public static void main(String args[]) {

        String s = "geekgeek" ;
        String p = "geek(.*)";
        if(s.matches(p) ) {
            System.out.println("matching");
        }
        else {
            System.out.println("not matching");
        }
        
    }
}
