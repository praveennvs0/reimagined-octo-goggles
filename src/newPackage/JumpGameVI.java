package newPackage;

import java.util.HashMap;
import java.util.Map;

public class JumpGameVI {
	
	public static void main(String[] args) {
		int nums[] = {1,-1,-2,4,-7,3};
		int k = 2 ;
		int maxScore = maxResult(nums,k);
		System.out.println(maxScore);
		
	}

    public static int maxResult(int[] nums, int k) {
    	Map<String,Integer> cache = new HashMap<>();
        int max = maxResult(nums,k,0,nums.length-1,nums[0],cache);
        return max;
    }
    
    public static int maxResult(int[] nums,int k,int currStep,int destination,int currScore, Map<String, Integer> cache) {
    	System.out.println("current step is : " + currStep + " current score is : " + currScore) ;
    	String key = String.valueOf(currStep) + String.valueOf(currScore);
    	if(cache.get(key) != null)
    		return cache.get(key);
    	int max = Integer.MIN_VALUE ; 
        if(currStep == destination) {
        	return currScore;
        }
        
        for(int i=1; i<=k && currStep+i < nums.length ;i++) {
            int jumpScore = maxResult(nums,k,currStep+i,destination,
                                     currScore+nums[currStep+i],cache);
            max = Math.max(max,jumpScore);
            
            
        }
        
        cache.put(key,max);
        return max;
    }
}