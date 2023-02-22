
public class FindMinInSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int nums[] = {4,5,1,2,3};
		int x = findMin(nums,0,nums.length-1) ;
		System.out.println(x);
	}

	private static int findMin(int[] nums,int left,int right) {
        if(left <= right) {
		int mid = left + ((right-left)/2);
     
	 if(mid < nums.length -1 && nums[mid+1] < nums[mid]) {
			return nums[mid+1] ;
		}
		else if(nums[mid] > nums[left]) {
			return findMin(nums,mid,right) ;
		}
		else if(nums[mid] < nums[left]) {
			return findMin(nums,left,mid);
		}
        }
        return -1;
		
	}

}
