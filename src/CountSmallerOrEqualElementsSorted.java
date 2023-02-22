
public class CountSmallerOrEqualElementsSorted {

	public static void main(String[] args) {
		int[] arr = {2, 2,2, 2, 2, 5, 7, 9} ;
		int key = 5 ;
		int x = countSmallerElements(arr,0,arr.length-1,key) ;
		System.out.println("no. of smaller elements is : " + x);
	}

	private static int countSmallerElements(int[] arr,int left,int right,int key) {
	 if(arr[right] <= key) {
		 return arr.length;
	 }
		
	   int count = 0;
       while(left <= right) {
    	   int mid = (left) + (right - left ) / 2 ;
    	   System.out.println("mid element is " + arr[mid]);
    	   if(arr[mid] == key) {
    		   System.out.println("key found at index : " + mid);
    		   int index = mid;
    		   while(index+1 < arr.length && arr[index+1] == arr[index]) {
    			   index++;
    		   }
    		   return index+1;
    	   }
    	   else if (key >= arr[mid] && key < arr[mid+1]) {
    		   return mid+1;
    	   }
    	   else if (arr[mid] < key) {
    		   left = mid+1; 
    	   }
    	   else {
    		   right = mid-1;
    	   }
    	   
    	   
       }
		return count;
	}
}
