import java.lang.reflect.Array;

public class SearchInSortedAndRotatedArray {
	public static void main(String[] args) {
		int[] a = {1,3,5};
		int index = search(a,2) ;
		System.out.println("index is : " + index);
		
	}

	private static int search(int[] a, int target) {
		int index = search(a,0,a.length-1,target);
		return index;
	}

	private static int search(int[] a, int start, int end,int target) {
		if(start <= end) {
		int mid = start + (end - start)/2;
		if(mid < 0 || mid > a.length - 1)
			return -1;
		
		if(a[mid] == target)
			return mid;
		if(a[mid] >= a[start]) {
			if(target >= a[start] && target < a[mid]) 
				return normalBinarySearch(a,start,mid,target);
			else
			   return search(a,mid+1,end,target);		
			
		}
		else if(a[mid] < a[start]){
			if(target > a[mid] && target <= a[end])
				return normalBinarySearch(a,mid+1,end,target);
			else
				return search(a,start,mid-1,target);
			
			
		}
			
		
		
		
		}
		return -1;
	}

	public static int normalBinarySearch(int arr[], int first, int last, int key){  
        if (last>=first){  
            int mid = first + (last - first)/2;  
            if (arr[mid] == key){  
            return mid;  
            }  
            if (arr[mid] > key){  
            return search(arr, first, mid-1, key);//search in left subarray  
            }else{  
            return search(arr, mid+1, last, key);//search in right subarray  
            }  
        }  
        return -1;  
    }  

}
