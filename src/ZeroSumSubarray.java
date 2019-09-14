/*package whatever //do not write package name here */

import java.util.*;

public class ZeroSumSubarray {
	public static void main (String[] args) {
		
	 int a[]= {4, 2, -3, 1, 6}  ;
	 
	 String x = isSubArrayWithZeroSumPresent(a) ;
	 System.out.println(x);
	 
	}
	
	public static String isSubArrayWithZeroSumPresent(int[] a) {
	    String x = "No" ;
	    Map<Integer,Integer> prefixSumToPresentMap = new HashMap<Integer,
	    Integer>() ;
	    
	    int currentSum = 0;
	    for(int i=0;i<a.length;i++) {
	        currentSum = currentSum+a[i] ;
	        if(currentSum==0) {
	            x="Yes" ;
	            break;
	        }
	        Integer valueInMap = prefixSumToPresentMap.get(currentSum) ;
	        if( valueInMap!=null && valueInMap.intValue() == 1) {
	            x="Yes" ;
	            break;
	        }
	        
	        prefixSumToPresentMap.put(currentSum,1);
	    }
	    
	    return x;
	    
	}
}