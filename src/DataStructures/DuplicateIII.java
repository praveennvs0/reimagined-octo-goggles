package DataStructures;

public class DuplicateIII {
	public static void main(String args[]) {
		int[] nums = {-2147483648,2147483647};
		int k =1, t=1;
		boolean isFound = containsNearbyAlmostDuplicate(nums,k,t);
		System.out.println(isFound);
	}
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {        
        for(int i=0;i<nums.length;i++) {
            for(int j=i+1; j < nums.length;j++) {
                if(Math.abs(nums[i]-nums[j]) <= t && Math.abs(i-j) <= k)
                    return true;
            }
        }
        return false;
    }
}