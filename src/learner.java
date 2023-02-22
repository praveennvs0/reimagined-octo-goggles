import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class learner {
    
    public static void main(String args[]) {
    	int[] A = {2,1,3,5,4};
    	int x = bulbCount(A);
    	System.out.println("No. of bulbs : " + x);
    	
    }
    
    private static int bulbCount(int[] bulbs) {
    	 int max = 0,val=0;
   	  int count = 0;
   	  int bulbsCount = bulbs.length;
   	  for (int moment = 0; moment < bulbsCount; moment++) {
   	     val = bulbs[moment];
   	    max = Math.max(max, val);
   	    if (max == moment + 1) count++;
   	  }
   	  return count;
    }
    
}