public class SlidingWindowMaximum {
	
	public static void main(String args[]) {
		int[] nums= {1,-1};
		int[] maxWindow=maxSlidingWindow(nums,1);
		for(Integer i: maxWindow) 
			System.out.println(i) ;
		
	}
	 public static int[] maxSlidingWindow(int[] nums, int k) {
         if(nums.length==0)
             return new int[0] ;
         if(k==1)
        	 return nums;
        int output[] = new int[nums.length-k+1];
        
        int start,end,largest=nums[0],largestIndex=0;; 
        
        for(int i=0;i<k;i++) {
            if(nums[i]>largest) {
                largest = nums[i];
                largestIndex = i;
            }
        }
        output[0]=largest;
        start = 1; 
        end = k;
        int m=1;
        while(start < end && end < nums.length)  {
            
            if(largestIndex==start-1) {
                int[] largestIndexArray = findLargest(nums,start,end-1);
            largest = largestIndexArray[0];
                largestIndex=largestIndexArray[1];
                
                if(nums[end] > largest) {
                    
                    largest=nums[end];
                    largestIndex=end;
                    output[m]=largest;
                }
            }
            else{
                if(nums[end] > largest) {
                    largest=nums[end];
                    largestIndex=end;
                    
                    
                }
            }
            
            
            
            output[m]=largest;
            m++;
            start++;
            end++;
        }
        return output;
     }
    
    public static int[] findLargest(int[] nums,int start,int endIndex) {
        int largest = nums[start], largestIndex=start;
        int[] arrayIndex = new int[2];
        for(int i=start;i<=endIndex;i++) {
            if(nums[i]>largest) {
                largest=nums[i];
                largestIndex=i;
            }
        }
        
        arrayIndex[0] = largest;
        arrayIndex[1] = largestIndex;
        return arrayIndex;
    }
    
}