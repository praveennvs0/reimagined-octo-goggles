import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CountOfLongestIncreasingSubsequenceMemoization {
	
	 public static void main(String[] args) {
		 int[] arr = {1,3,5,4,7};
		 int x = lengthOfLIS(arr);
		 System.out.println("length is : " + x);
		 
		 
	 }
	
	 public static int lengthOfLIS(int[] nums) {
	        int memo[][] = new int[nums.length + 1][nums.length];
	        for (int[] l : memo) {
	            Arrays.fill(l, -1);
	        }
	        Map<String, Integer> countMap = new HashMap<>();
			int x = lengthofLIS(nums, -1, 0, memo,countMap);
	        return x;
	    }
	 
	    public static int lengthofLIS(int[] nums, int previndex, int curpos, int[][] memo,Map<String,Integer> countMap) {
	        if (curpos == nums.length) {
	            return 0;
	        }
	        if (memo[previndex + 1][curpos] >= 0) {
	            return memo[previndex + 1][curpos];
	        }
	        int taken = 0;
	        if (previndex < 0 || nums[curpos] > nums[previndex]) {
	            taken = 1 + lengthofLIS(nums, curpos, curpos + 1, memo,countMap);
	        }
	        String keyTaken = "Taken" + String.valueOf(previndex) + " * " + String.valueOf(curpos) + " = " + String.valueOf(taken);   
	        countMap.put(keyTaken,1+countMap.getOrDefault(keyTaken,0));

	        
	        int nottaken = lengthofLIS(nums, previndex, curpos + 1, memo,countMap);
	        
	        String keyNotTaken = "NotTaken" + String.valueOf(previndex) + " * " + String.valueOf(curpos) + " = " + String.valueOf(taken);
	        countMap.put(keyNotTaken,1+countMap.getOrDefault(keyNotTaken,0));
	        memo[previndex + 1][curpos] = Math.max(taken, nottaken);
	        return memo[previndex + 1][curpos];
	    }

}
