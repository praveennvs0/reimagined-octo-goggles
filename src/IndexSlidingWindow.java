
public class IndexSlidingWindow {

	
	public  static  void main(String[] args) { 
        boolean arr[] = {true, true, false, false, true, 
            false, true, true, true, false, true, true, true,}; 
  
        // bool arr[] = {1, 1, 1, 1, 0};  
        int n = arr.length; 
        System.out.println("Index of 0 to be replaced is "
                + maxOnesIndex(arr, n)); 
    }




// Java program to find index of zero  
// to be replaced by one to get longest  
// continuous sequence of ones. 
  

  
// Returns index of 0 to be replaced  
// with 1 to get longest continuous  
// sequence of 1s. If there is no 0  
// in array, then it returns -1.  
    static int maxOnesIndex(boolean arr[], int n) { 
  
        // To store starting point of  
        // sliding window.  
        int start = 0; 
  
        // To store ending point of  
        // sliding window.  
        int end = 0; 
  
        // Index of zero with maximum number  
        // of ones around it.  
        int maxIndex = -1; 
  
        // Index of last zero element seen  
        int lastInd = -1; 
  
        // Count of ones if zero at index  
        // maxInd is replaced by one.  
        int maxCnt = 0; 
  
        while (end < n) { 
  
            // Keep increasing ending point  
            // of sliding window until one is  
            // present in input array.  
            while (end < n && arr[end]) { 
                end++; 
            } 
  
            // If this is not first zero element  
            // then number of ones obtained by  
            // replacing zero at lastInd is  
            // equal to length of window.  
            // Compare this with maximum number  
            // of ones in a previous window so far.  
            if (maxCnt < end - start && lastInd != -1) { 
                maxCnt = end - start; 
                maxIndex = lastInd; 
            } 
  
            // The new starting point of next window  
            // is from index position next to last  
            // zero which is stored in lastInd.  
            start = lastInd + 1; 
            lastInd = end; 
            end++; 
        } 
  
        // For the case when only one zero is  
        // present in input array and is at  
        // last position.  
        if (maxCnt < end - start && lastInd != -1) { 
            maxCnt = end - start; 
            maxIndex = lastInd; 
        } 
  
        return maxIndex; 
    } 
  
    // Driver function  
   
}
