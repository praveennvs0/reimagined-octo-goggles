package newPackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FirstMissingPositive {
	public static void main(String args[]) {
		int[] nums = {0,-1};
		int smallest = firstMissingPositive(nums) ;
		System.out.println("smallest is : " + smallest ) ;
	}
	 public static int firstMissingPositive(int[] nums) {
	        int nums2[]={0,2,2,1,1};
	        nums=nums2;
	        
	        List<Integer> posList = new ArrayList<Integer>();
	        for(int i=0;i<nums.length; i++) {
	            if(nums[i]>0){
	            	posList.add(nums[i]);
	            }
	        }
	        
	        Collections.sort(posList); 
	        
	        if(posList.isEmpty() || posList.get(0) > 1) {
	            return 1 ;
	        }
	        
	        
	        int smallest = 1;
	        int i=0;
	        for( i=0;i<posList.size()-1;i++) {
	        	if(posList.get(i+1) == posList.get(i)) 
	        		continue ;
	            if(posList.get(i+1) != posList.get(i)+1) {
	            smallest = posList.get(i) + 1 ;
	                break ;
	            }
	        }
	        
	        if(i==posList.size()-1) 
	            smallest = posList.get(posList.size()-1) + 1 ;
	        
	        return smallest;
	    }
}
