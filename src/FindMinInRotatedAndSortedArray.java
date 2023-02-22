
public class FindMinInRotatedAndSortedArray {

	public static void main(String[] args) {
		int nums[] = {4,5,6,7,0,1,2};
		int min = findMin(nums);
		System.out.println("minimum value is : " + min);
		
	}

	private static int findMin(int[] nums) {
		if(nums.length == 1)
			return nums[0];
		int min = findMin(nums,0,nums.length-1);
		return min;
	}

	private static int findMin(int[] nums, int start, int end) {
		int mid = start + (end - start) / 2;            		
		if(mid-1 >=0 && mid-1 < nums.length && mid+1 >=0 && mid+1 < nums.length && mid >=0  && nums[mid] < nums[mid-1] && nums[mid] < nums[mid+1]) {
			return nums[mid];
		}
            
        if(nums[end] > nums[0])
            return nums[0];
		
		if(nums[mid] > nums[start]) {
		   return findMin(nums,mid+1,end);	
		}
		else {
			return findMin(nums,start,mid-1);
		}
		
		
	}
}
