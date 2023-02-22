import java.util.List;

public class FindKClosestElements {
	public static void main(String[] args) {
		int arr[] = {1,2,3,4,5},k=4,x=-1;
		findClosestElements(arr,k,x);
		
	}
	
	 public static void findClosestElements(int[] arr, int k, int x) {
	        
	        
	        int low = 0, high = arr.length-1, mid,lowerBound=0,upperBound=arr.length-1;
	        
	        while(low <= high) {
	            mid = low + ( high - low) /2 ;
	            
	            if(high-low == 1) {
	                if(arr[low] == x) {
	                    lowerBound = upperBound = low;
	                    break;                    
	                }
	                else if ( arr[high] == x) {
	                    lowerBound = upperBound = high;
	                    break;                    
	                }
	               else if(arr[low] < x && x < arr[high]) {
	                   lowerBound = low;
	                   upperBound = high;
	                   break;
	               }
	                
	            }
	            
	            
	            if(arr[mid] == x) {
	                lowerBound = upperBound = mid;
	                break;
	            }
	            else if (x < arr[mid] ) {
	                high = mid-1;
	            }
	            else {
	                low = mid+1;
	            }
	        
	        }
	        
	        
	        System.out.println("Lower bound : " + lowerBound);
	        System.out.println("Upper bound : " + upperBound);
	        
	    }

}
