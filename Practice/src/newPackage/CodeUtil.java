package newPackage;

public class CodeUtil {

    
    public static void main(String  args[]) {
        int[] nums={2};
        int x = findSmallestNotOccuring(nums) ;
        System.out.println("smallest number is : " + x);
        
    }

    private static int findSmallestNotOccuring(int[] nums) {
        
        sort(nums) ;
        int count = 0;
        int[] numsCopy = new int[nums.length] ;
        for(int i=0 ; i < nums.length ; i++) {
            if(nums[i] > 0) {
                count++ ;
                numsCopy[i] = nums[i] ;
            }
        }
        
        nums = numsCopy ;
        
        if(nums[nums.length-1] < 0 || nums[nums.length-1] == 0)
            return 1 ;
        
        if(nums.length == 1 ) {
            if(nums[0]==1)
                return 2 ;
            if(nums[0] > 1)
                return nums[0]-1 ;
        }
        int smallest = 0 ;
        for(int i=0;i+1<count ; i++) {
            if(nums[i+1] == nums[i])
                continue ;
            else if(nums[i+1] - nums[i]==1) 
                continue ;
            else if(nums[i+1] < 0 && nums[i] < 0)
                continue ;
            else if(nums[i] < 0)
                continue ;
            else if(nums[i+1] - nums[i] > 1) {
                smallest = nums[i] + 1;
                break ;
            }
            
        }
        
        
        return smallest;
    }

    private static void sort(int[] nums) {
        int index;
        for(int i=0;i<nums.length ;i++) {
            index = i ;
            for(int j=i+1;j<nums.length ; j++) {
                if(nums[j] < nums[index]) {
                    index = j;
                }
            }
            int temp=nums[i] ;
            nums[i] = nums[index] ;
            nums[index] = temp ;
        }
    }
}
