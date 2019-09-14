package newPackage;

public class LocalInversions {

	public static void main(String args[]) {
		
		int[] a= {5,4,1,3,2};
		int x = countLocalInversions(a,0,a.length-1) ;
		System.out.println("no. of local inversions is :" + x);
		
		int g = mergeSort(a) ;
		System.out.println("No. of global inversions is : " + g) ;
	}

	  public boolean isIdealPermutation(int[] A) {
		     int local =  countLocalInversions(A,0,A.length-1);
		     int global = mergeSort(A);
		        
		       return local==global;
		    }
	  
	private static int mergeSort(int[] a) {

		 int temp[] = new int[a.length]; 
	        return mergeSort(a, temp, 0, a.length - 1); 
	}

	private static int noOfLocalInversionsBruteForce(int[] a) {
		int count = 0;
		for(int i=0;i+1<a.length ; i++ ) {
			if(a[i+1] < a[i])
				count++;
		}
		return count;
	}
	
	private static int mergeSort(int[] a,int[] temp,int low,int high) {
		int inversionCount = 0 ;
		int mid = (low+high)/2;
		if(low<high) {
		inversionCount = mergeSort(a,temp,low,mid) ;
		inversionCount+= mergeSort(a,temp,mid+1,high);
		inversionCount+= merge(a,temp,low,mid+1,high);
		
				
		}
		return inversionCount ;
		
	}
	
	

	 static int merge(int arr[], int temp[], int left, int mid, int right) 
	    { 
	        int i, j, k; 
	        int inv_count = 0; 
	  
	        i = left; /* i is index for left subarray*/
	        j = mid; /* j is index for right subarray*/
	        k = left; /* k is index for resultant merged subarray*/
	        while ((i <= mid - 1) && (j <= right)) { 
	            if (arr[i] <= arr[j]) { 
	                temp[k++] = arr[i++]; 
	            } 
	            else { 
	                temp[k++] = arr[j++]; 
	  
	                /*this is tricky -- see above explanation/diagram for merge()*/
	                inv_count = inv_count + (mid - i); 
	            } 
	        } 
	  
	        /* Copy the remaining elements of left subarray 
	       (if there are any) to temp*/
	        while (i <= mid - 1) 
	            temp[k++] = arr[i++]; 
	  
	        /* Copy the remaining elements of right subarray 
	       (if there are any) to temp*/
	        while (j <= right) 
	            temp[k++] = arr[j++]; 
	  
	        /*Copy back the merged elements to original array*/
	        for (i = left; i <= right; i++) 
	            arr[i] = temp[i]; 
	  
	        return inv_count; 
	    } 
	  
	 
	private static int countLocalInversions(int[] a,int low,int high) {
		// TODO Auto-generated method stub
		int count = 0;
		int mid = (low+high)/2;
		
		if(low<high) {
		count= countLocalInversions(a,low,mid);
		count+= countLocalInversions(a,mid+1,high);
		count+= mergeSimple(a,low,mid,high) ;
		
		
		}
		return count;
	}

	private static int mergeSimple(int[] a, int low, int mid, int high) {
		if(a[mid] > a[mid+1])
		    return 1;
		
		return 0;
	}
}
