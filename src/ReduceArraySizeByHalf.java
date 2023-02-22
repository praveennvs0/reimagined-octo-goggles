import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class ReduceArraySizeByHalf {

	public static void main(String[] args) {

		int[] arr= {7,7,7,7,7,7,7};
		int minSize = minSetSize(arr);
		System.out.println("minimum size is : " + minSize);
		
	}
	
	 public static int minSetSize(int[] arr) {
	        int n = arr.length, countRemoved = 0,count=0;
	        Map<Integer,Integer> freqMap = new HashMap<>();
	        for(int i=0;i<arr.length;i++) {
	            freqMap.put(arr[i],freqMap.getOrDefault(arr[i],0)+1);
	        }
	        
	        Map<Integer,Integer> map = new TreeMap<>(Collections.reverseOrder());
	        
	        
	        
	        for(Entry<Integer,Integer> entry : freqMap.entrySet()) {
	            int value = entry.getValue();
	            map.put(value,map.getOrDefault(value,0) + 1 );
	             
	        }
	        
	        for(Entry<Integer,Integer> entry : map.entrySet()) {
	        	int key = entry.getKey();
	        	int num = entry.getValue();
	        	
	        	for(int i=0;i<num;i++) {
	        		countRemoved+= key;
	        		count++;
	        		if(countRemoved >= n/2) {
	        			return count ;
	        		}
	        	}
	        	
	        }
	        
	        
	        
	        return 0;
	        
	        
	    }

}
