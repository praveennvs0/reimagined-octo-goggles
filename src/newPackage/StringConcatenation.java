package newPackage;

public class StringConcatenation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] nums = {"777","7","77","77"} ;
		String target = "7777";
		int x = numOfPairs(nums,target);
		System.out.println("number is : " + x);
	}
	
	public static int numOfPairs(String[] nums, String target) {
        int count = 0;
        for(int i=0;i<nums.length;i++) 
            for(int j=i+1;j<nums.length;j++) {
            	String z = nums[i] + nums[j] ;
                if(i != j && z  ==  target) 
                    count++;
            }
        
    
    for(int i=nums.length-1;i>=0;i--) 
        for(int j=i-1;j>=0;j--) {
        	String z = nums[i] + nums[j];
            if(i != j && z == target) 
                count++;
        }
        return count;    
            
    }

}
