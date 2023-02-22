import java.util.ArrayList;
import java.util.List;

public class PartitionEqualSubset {
	
	static boolean canPartition = false;

	public static void main(String[] args) {
		int nums[] = {1,5,11,5};
		
		boolean canPartition = canPartition(nums);
		System.out.println(canPartition);
		
	}

	public static boolean canPartition(int[] nums) {
		int totalSum = findSum(nums);
		if(totalSum %2 == 1)
			return false;
		List<List<Integer>> list = new ArrayList<>();
		boolean canPartition = subsets(list,new ArrayList<Integer>(),totalSum,0,nums,0);
		return canPartition;
	}

	private static int findSum(int[] nums) {
		int sum = 0;
		for(int i=0; i < nums.length ; i++)
			sum+=nums[i];
		return sum;
	}

	private static boolean subsets(List<List<Integer>> list, List<Integer> resultList, int totalSum, int currSum,int[] nums, int index) {

		list.add(new ArrayList<>(resultList));
		if(currSum == totalSum-currSum) {
			System.out.println("equal partition found");
	        canPartition = true;
			return canPartition;
		}
		
		for(int i=index; i < nums.length && !canPartition ; i++) {
			resultList.add(nums[i]);
			subsets(list,resultList,totalSum,currSum+nums[i],nums,i+1);
			resultList.remove(resultList.size()-1);
			
		}
		return canPartition;
		
	}
}
