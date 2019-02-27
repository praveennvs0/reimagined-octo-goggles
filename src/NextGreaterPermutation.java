import java.util.HashMap;

public class NextGreaterPermutation {

    public static void main(String args[]) {
        int nums[] = {1,3,2} ;
        
        printNextGreaterPermutation(nums) ;
        
      
        for(Integer i : nums) {
            System.out.print(i);
        }
    }

    private static int[] printNextGreaterPermutation(int[] nums) {
        boolean found = false ;
        int i=0;
        for(i=nums.length - 2 ; i >=0 ; i--) {
                //pick the smallest element to the right that is also greater than a[i]
                int index   = findIndexOfSmallest(nums,i) ;
                if(index != i) {
                    found = true ;
                    
                    int temp = nums[i] ; 
                    nums[i] = nums[index] ;
                    nums[index] = temp ;
                    
                    sort(nums,i+1) ;
                    break;
                }
               
              
            }
        
        if(found == false) {
            sort(nums,0) ;
        }
        return nums ;
    }

    private static int findIndexOfSmallest(int[] nums, int i) {
        int index = i, small = Integer.MAX_VALUE;
        for(int k=i+1; k< nums.length ; k++) {
            if(nums[k] > nums[i] && nums[k] < small) {
                small = nums[k] ;
                index = k ;
            }
        }
        
       return index ;
    }

    private static void sort(int[] nums,int startIndex) {
        int index ;
        
        for(int i=startIndex;i<nums.length ; i++){
            index = i ;
            for(int j=i+1 ; j < nums.length ; j++) {
                if(nums[j] < nums[index]) {
                    index = j ;
                }
            }
            int temp = nums[i] ; 
            nums[i] = nums[index] ;
            nums[index] = temp ;
        }
            
        
    }
}
