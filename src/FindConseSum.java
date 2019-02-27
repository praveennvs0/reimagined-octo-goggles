import java.util.ArrayList;
import java.util.List;

public class FindConseSum {

    public static void main(String args[]) {
        
        ConsecutiveNumbers cn = new ConsecutiveNumbers() ;
        
        for(int i=0 ; i < 20 ; i ++) {
         int k = cn.consecutiveNumbersSum(i) ;
         System.out.println("no. of ways for " + i + " is  :" + k);
        }
     
    }
}
