package newPackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SimpleMax {
public static void main(String args[]) {
	int numsArray[] = {7,1,2,5};
	List<Integer> nums = new ArrayList<Integer>() ;
	nums.add(7);
	nums.add(1);
	nums.add(2);
	nums.add(5);
	int diff = maxDifference(nums);
	System.out.println("max difference is " + diff) ;
}


public static int maxDifference(List<Integer> nums) {
      int maxDiff = Integer.MIN_VALUE;
      boolean isPairFound = false;
      for(int i=0;i<nums.size();i++) {
    	  int left = nums.get(i) ;
    	  for(int j=i+1;j<nums.size();j++) {
    		  int right = nums.get(j) ;
    		  if(right>=left) {
    			  isPairFound = true ;
    			  int currDiff = right-left;
    			  maxDiff = Math.max(maxDiff, currDiff);
    		  }
    	  }
    	  
      }
      
      
      if(!isPairFound) 
    	  return -1;
      return maxDiff;
		
    }


}
