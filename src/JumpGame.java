public class JumpGame {
	
	public static void main(String[] args) {
		int[] nums = {2,3,1,1,4};
		boolean x = canJump(nums);
		System.out.println(x);
	}
	
    public static boolean canJump(int[] nums) {
        
        return canJump(nums,0);
        
    }
    
    public static boolean canJump(int[] nums,int currIndex) {
        
        if(currIndex == nums.length-1)
            return true;
        
        for(int i=1;i<=nums[currIndex] && i < nums.length ;i++) {
                    if(canJump(nums,currIndex+i))
                        return true;
        }
        return false;
        
    }
}