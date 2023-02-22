
public class RotateArray {

	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5,6,7} ;
		int k =3;
		rotate(nums,k);
		System.out.println("Hello");
	}
	
	    public static void rotate(int[] nums, int k) {
	        k = k % nums.length ;
	        int b[] = new int[k];
	        int j=0;
	        // copy the last k elements into a new array
	        for(int i=nums.length-k;i<nums.length;i++) {
	            b[j++] = nums[i];
	        }
	        
	        //Move all the elements in the original array by k steps
	        for(int i=0;i+k<nums.length;i++) {
	            nums[i+k] = nums[i];
	        }
	        
	        //copy the k elements from temp array to the beginning of nums array
	        j=0;
	        for(int i=0;i<k;i++) {
	            nums[i]=b[j++];
	    }
	}
}
