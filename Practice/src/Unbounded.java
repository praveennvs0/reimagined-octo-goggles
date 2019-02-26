import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class Unbounded {

    
    public static void main(String args[]) {
        Set<String> s1 = new HashSet<String>() ;
        s1.add("hello") ;
        s1.add("world") ;
        s1.add("java") ;
        
        Set<String> s2 = new HashSet<String>() ;
        s2.add("Python") ;
        s2.add("world") ;
        s2.add("java") ;
        
        System.out.println("no. of common elements is : " + 5);
            
        }

static  int numElementsInCommon(Set<?> s1, Set<?> s2) { 
    int result = 0;
    for(Object o1: s1) 
        if(s2.contains(o1)) 
            result++;
    return result ;
}
}
