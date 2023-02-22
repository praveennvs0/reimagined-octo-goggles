import java.util.HashMap;

public class TwoSum {

	public static void main(String[] args) {
		int res[] = {3,4,2};
		int result[] = findIndices(res,6);
		System.out.println(result[0]);
		System.out.println(result[1]);
		
		
	}
	
	public static int[] findIndices(int[] nums,int targetSum) {
		if(nums == null || nums.length < 2) 
			return new int[] {-1,-1};
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i=0;i<nums.length;i++) 
			map.put(nums[i],i);
		for(int i=0; i < nums.length ; i++) {
			int complement = targetSum - nums[i];
			if(map.containsKey(complement) && map.get(complement) != i) {
				return new int[] {i,map.get(complement)};
			}
			
		}
		
		return new int[] {-1,-1};
	}
}
