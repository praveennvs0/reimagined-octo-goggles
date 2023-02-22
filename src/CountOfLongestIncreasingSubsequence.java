import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountOfLongestIncreasingSubsequence {
	
	 public static void main(String[] args) {
		 int[] arr = {1,3,5,4,7};
		 int x = lengthOfLIS(arr);
		 System.out.println("length is : " + x);
		 
		 
	 }
	
	 public static int lengthOfLIS(int[] nums) {
		 Map<Integer, Integer> countMap = new HashMap<>();
	        List<Integer> path = new ArrayList<Integer>();
			int x = lengthofLIS(nums, Integer.MIN_VALUE, 0, countMap,path);
	        return x;
	    }

	    public static int lengthofLIS(int[] nums, int prev, int curpos,Map<Integer,Integer> countMap,List<Integer> path) {
	        if (curpos == nums.length) {
	            return 0;
	        }
	        int taken = 0;
	        if (nums[curpos] > prev) {
	            taken = 1 + lengthofLIS(nums, nums[curpos], curpos + 1, countMap,path);
	            path.add(nums[curpos]);
	        }
	        countMap.put(taken,1+countMap.getOrDefault(taken,0));
	        
	        path.remove(path.size()-1);
	        int nottaken = lengthofLIS(nums, prev, curpos + 1, countMap,path);
	        path.add(0);
	        
	        //System.out.println("Taken " + String.valueOf(prev) + "*" + String.valueOf(curpos) + " = " + taken);
	        //System.out.println("Not taken " + String.valueOf(prev) + "*" + String.valueOf(curpos) + " = " + nottaken);
	        printPath(path);
	        return Math.max(taken, nottaken);
	    }

		private static void printPath(List<Integer> path) {
			path.forEach(x-> { System.out.print(x) ; 
			System.out.print("->");} );
			System.out.println("");
			
		}
}
