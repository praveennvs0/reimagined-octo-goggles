import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ArrayLearner {

    public static void main(String args[]){
        
        Number n ;
       System.out.println(Integer.class);
         
         
    }

    private static void printNumbers(List<? extends Number> numList) {

        for(Number n : numList) {
            System.out.println(n);
        }
    }
   
}
