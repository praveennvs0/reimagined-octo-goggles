
public class Combinations {
public static void main(String args[]) {
    String s = "1234" ;
    printCombinations("",s) ;
}

public static void printCombinations(String prefix,String remaining) {
    
    System.out.println(prefix);
    for(int i=0; i < remaining.length() ; i++) {
        prefix = prefix + remaining.charAt(i) ;
        printCombinations(prefix,remaining.substring(i+1,remaining.length())) ;
        prefix = prefix.substring(0,prefix.length() - 1) ;
        
    }
    
}

}
