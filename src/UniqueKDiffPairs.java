import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueKDiffPairs {

	public static void main(String[] args) {

		int[] nums = {6,3,5,7,2,3,3,8,2,4};
				
				
		//int[] nums = {1,2,3,4,5};
		int count = findPairs(nums,2);
		System.out.println("count is : " + count);
		
	}
	
	  public static int findPairs(int[] nums, int k) {
	        Set<Integer> set = new HashSet<Integer>();
	        Map<Integer,Integer> map = new HashMap<>();
	        int count=0;
	        for(int i=0;i<nums.length;i++) {
	        	if(k==0) {
	        		if(!set.contains(nums[i])) {
	        			set.add(nums[i]);
	        			map.put(nums[i],1);
	        		}
	        		else {
	        			map.put(nums[i],map.getOrDefault(nums[i],0)+1);
	        			if(map.get(nums[i]) > 2) 
	        				continue;
	        			count++;
	        		}
	        	}
	        	
	        	else {
	            if(set.contains(nums[i]))  {
	                continue;
	            }
	          
	            set.add(nums[i]);
	            if((set.contains(nums[i]+k) || set.contains(nums[i]-k)) && k>0) {
	            	System.out.println("index " + i + " value " + nums[i] );
	                count++;
	            }
	        	}
	            
	        }
	      return count;  
	    }

}
