import java.util.HashMap;
import java.util.Map;

public class MinJumps {

	
	public static void main(String args[]) {
		int[] nums= {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9} ;
		int jumps = jump(nums) ;
		System.out.println("Minimum no. of jumps is :" + jumps);
	}
	
	   public static int jump(int[] nums) {
	        Integer[][] cache = new Integer[nums.length][nums.length];
	        int jump = jump(nums,0,nums.length-1,0,Integer.MAX_VALUE,cache) ;
	        return jump;
	    }
	    
	    public static int jump(int[] nums,int currentPosition,int target,int count,Integer min,Integer[][] cache) {
	    	
	    	if(cache[currentPosition][count] !=null  ) {
	    		return cache[currentPosition][count] ;
	    	}
	        if(currentPosition==target){
	           System.out.println("no. of jumps is : "+ count) ;
	          return count;
	        }
	            
	        else {
	            for(int i=nums[currentPosition]; i>=1; i--) {
	                if(currentPosition+i <= nums.length-1) {
	                	
	                    int k = jump(nums,currentPosition+i,target,count+1,min,cache) ;
	                    cache[currentPosition][count] = k;
	                    
	                min= Math.min(min,k) ;
	                
	                    
	                    }
	            }
	            
	        }
	        
	        return min;
	    }
}
