import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class genereics {

    
    public static void main(String args[]) {
        Integer a=3, b =4;
        
       // sum(a,b) ;
        
        
        List<Number> numbers = new ArrayList<Number>();
        List<Integer> integers = Arrays.asList(1, 2, 3);
        numbers.addAll(integers); // works!
        
        double c = 5, d = 10 ;
      
        List<String> l = new ArrayList<String>() ;
        l.add("one") ;
        l.add("two");
        l.add("three");
        
        printElementsWithE(l) ;
        printElementsWith(l) ;
        
    }
    
    public static <T> void test(List<T> set){   //T cannot be resolved
        System.out.println(set);
    }

    private static  <T extends Number > void sum(T a, T b) {
        if(a instanceof Integer && b instanceof Integer) {
        Integer c = (Integer) a + (Integer) b ; 
        System.out.println("Sum is : " + c);
        }
        
        if(a instanceof Double && b instanceof Double) {
            Double c =  (Double) a +  (Double) b ; 
            System.out.println("Sum is : " + c);
            }
            
        
        System.out.println(a);
        System.out.println(b);
    }
    
    public static <E> void printElementsWithE(List<E> list) {
        for (E elem : list) {
            System.out.println(elem);
        }
    }
    
   public static void printElementsWith(List<?> list) {
        for (Object elem : list) {
            System.out.println(elem);
        }
    } 
    
    
}
