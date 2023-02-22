import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LongestSubarrayWithAbsDiff {

	public static void main(String[] args) {
		
		int arr[] = {8,2,4,7};
		int size = longestAbsDiff(arr,4);
	}

	private static int longestAbsDiff(int[] arr,int limit) {
		int maxLen = 0;
		
		int start = 0, end = 1, currLen=0;
		
		while(start < end && start < arr.length && end-1 < arr.length) {
			
			if(Math.abs(arr[end]-arr[end-1]) <= limit) {
				end++;
				currLen++;
			}
			
			
			
		}
		
		List<Integer> list = new LinkedList<>();
		Iterator it = list.iterator();
		
		
		Object t = it.next();
		
		
		
		return maxLen;
	}
}
