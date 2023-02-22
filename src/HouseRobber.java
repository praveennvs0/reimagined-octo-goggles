import java.util.ArrayList;
import java.util.List;

public class HouseRobber {

	public static void main(String[] args) {
		int nums[] = {1,2,3,1};
		
		List<Integer> robbedHousesList = new ArrayList<>();
		
		int amount = rob(nums,0,robbedHousesList );
		System.out.println("amount is : " + amount);
	}

	private static int rob(int[] nums, int currHouse, List<Integer> list) {
		int amount = 0,taken=0,notTaken=0;
		
		if(currHouse >= nums.length) {
			return 0;
		}
		
		if(list.size() >=1 && currHouse != list.get(list.size()-1)) {
			 taken = nums[currHouse] + rob(nums,currHouse+1,getList(list,currHouse)) ;
		}
		
		
		notTaken = rob(nums,currHouse+1,list) ;
		
		  
		
		amount = Math.max(taken, notTaken);
		return amount;
	}

	private static List<Integer> getList(List<Integer> list, int currHouse) {
		list.add(list.size(),currHouse);
		return list;
	}
}
