import java.util.Arrays;
import java.util.Comparator;

public class InsertIntervalLeetcode {
	
public static void main(String args[]) {
//		
//	int[][] intervals = {
//			{1,2},{3,5},{8,10},{12,16}
//		};
//	
//
//	int newInterval[] = {0,1};
	int[][] intervals ={{2,7},{8,8},{10,10},{12,13},{16,19}};
	
	int newInterval[] = {9,17};
	
	display(intervals);
	int[][] intervalsList = insert(intervals,newInterval) ;
	display(intervalsList);
	
	
}
    private static void display(int[][] intervalsList) {
    	System.out.println();
    	for(int i=0 ; i < intervalsList.length ; i++) {
    		int[] interval = intervalsList[i] ;
    		System.out.print(interval[0]);
    		System.out.print(",");
    		System.out.print(interval[1]);
    		System.out.print(" -> ");
    	}
    	System.out.println();
}
	public static int[][] insert(int[][] intervals, int[] newInterval) {
        int length = intervals.length ;

        int currStartTime = newInterval[0];
        int currEndTime = newInterval[1];
        
        if(length==0 || (currStartTime <= intervals[0][0] && currEndTime >= intervals[length-1][1])) {
        	int [][] intervalsSingleElement = new int[1][2];
        	intervalsSingleElement[0]= newInterval;
        	return intervalsSingleElement;
        }
        
        
		if(newInterval[1]< intervals[0][0] || newInterval[0] > intervals[length-1][1]) 
			return intervals = addADisjointInterval(intervals,newInterval) ;
        
        boolean leftOverLap = false, rightOverLap = false ;
        int beforeIndex = pickIntervalBefore(intervals,currStartTime);
        
        
        int afterIndex = pickIntervalAfter(intervals,currStartTime,currEndTime);
        
        int[] beforeInterval = new int[2];
        if(beforeIndex >=0) 
        	beforeInterval = intervals[beforeIndex];
        else
        	beforeInterval = null ;
        
       
        int[] afterInterval = new int[2];
        int afterIntervalEndTime = Integer.MIN_VALUE;
        if(afterIndex >=0) {
        afterInterval = intervals[afterIndex];
        afterIntervalEndTime = afterInterval[1];
        }
        else
        	afterInterval = null;
        
        
        
        if(beforeInterval !=null && beforeInterval[1] >= currStartTime) {
        	leftOverLap = true;
        }
        
        if(afterInterval != null && afterInterval[0] <= currEndTime) {
        	rightOverLap = true ;
        }
        
        if(leftOverLap && !rightOverLap) {
        	int[] newInt = new int[2];
        	newInt[0] = beforeInterval[0];
        	if(currEndTime <= beforeInterval[1]) {
        		//do nothing
        	}
        	else {
        	    intervals[beforeIndex][1] = currEndTime ;
        	}
        }
        
        if(rightOverLap && !leftOverLap) {
        	int originalStartTime= afterInterval[0];
        	afterInterval[0] = currStartTime ;
        	   
               int endTime = Math.max(currEndTime, afterIntervalEndTime);
               intervals[afterIndex][1]= endTime;
               intervals = collapseIntervals(intervals,originalStartTime,currStartTime);
            
               
        }
        
        if(!leftOverLap && !rightOverLap) {
        	intervals = addADisjointInterval(intervals,newInterval) ;
        	 
        }
        
        if(leftOverLap && rightOverLap) {
        	int endTime = Math.max(afterIntervalEndTime, currEndTime);
        	intervals[beforeIndex][1] = endTime;
        	intervals = removeAnIndex(intervals,beforeIndex,endTime,afterIndex);
        }
        
        
        return intervals ; 
        
    }
	private static int[][] collapseIntervals(int[][] intervals, int startTimeOfAfterIndex, int currStartTime) {
		int count = 0;
		int[][] newIntervals = new int[intervals.length][2];
		for(int i=0; i < intervals.length ; i++) {
			int[] interval = intervals[i];
			if(interval[0] > currStartTime && interval[1] < startTimeOfAfterIndex ) {
				//do not add this 
			}
			else {
				newIntervals[count] = interval;
				count++;
			}
		}
		newIntervals = filterNullValues(newIntervals,count);
		return newIntervals;
	}
	private static int[][] addADisjointInterval(int[][] intervals, int[] newInterval) {
		int length = intervals.length ;
    	intervals = incrementAndCopy(intervals) ;
    	intervals[length] = newInterval ;
    	 int col = 2; 
         sortbyColumn(intervals, col - 1);
		return intervals;
	}
	private static int[][] incrementAndCopy(int[][] intervals) {
		int length = intervals.length ;
		int[][] newIntervals = new int[length+1][2];
		for(int i=0;i<length;i++) 
			newIntervals[i]=intervals[i];
		
		return newIntervals;
	}
	private static int[][] filterNullValues(int[][] intervals, int count) {
		int[][] intervalsToReturn = new int[count][2];
		
		for(int i=0; i < count ; i++) {
			intervalsToReturn[i] = intervals[i];
		}
		return intervalsToReturn;
	}
	private static int[][] removeAnIndex(int[][] intervals, int beforeIndex, int endTime,int afterIndex) {
		int[][] newIntervals = new int[intervals.length][];
		int startTime = intervals[beforeIndex][0];
		int count = 0;
		for(int i=0;i< intervals.length ;i++) {
			if(i==afterIndex && beforeIndex != afterIndex )
				continue;
			int[] interval = intervals[i];
			if(i!= beforeIndex && interval[0] >= startTime && interval[1]<= endTime) 
				continue ;
			newIntervals[count]=interval;
			count++;
		}
		
		int[][] intervalsToReturn = filterNullValues(newIntervals,count);
		System.out.println("number of intervals is : "+ count);
		return intervalsToReturn;
	}
	
	private static int pickIntervalAfter(int[][] intervals, int currStartTime,int currEndTime) {
		int index = -1;
		for(int i=0; i < intervals.length ; i++) {
			int[] interval = intervals[i];
			
			if(interval[0] > currEndTime) {
				break;
			}
			else if( interval[0] >= currStartTime) { 
				index = i ;
				
			}
			else {
				continue;
			}
		}
		
		if(index < 0) {
			index = returnImmediatelyNext(intervals,currEndTime);
		}
		
		return index;
	}
	
	private static int returnImmediatelyNext(int[][] intervals, int currEndTime) {
		int index = -1;
		for(int i=0;i<intervals.length ; i++) {
			int[] interval = intervals[i];
			if(interval[0] >= currEndTime) 
				return i;
			
			
		}
		
		return index; 
	}
	private static int pickIntervalBefore(int[][] intervals, int currStartTime) {
		int index = -1 ;
		for(int i=0; i < intervals.length ; i++) {
			int[] interval = intervals[i];
			if( interval[0] <= currStartTime) 
				index = i;
			else 
				break;
		}
		return index;
	}
	
	 public static void sortbyColumn(int arr[][], int col) 
	    { 
	        // Using built-in sort function Arrays.sort 
	        Arrays.sort(arr, new Comparator<int[]>() { 
	            
	          @Override              
	          // Compare values according to columns 
	          public int compare(final int[] entry1,  
	                             final int[] entry2) { 
	  
	            // To sort in descending order revert  
	            // the '>' Operator 
	            if (entry1[col] > entry2[col]) 
	                return 1; 
	            else
	                return -1; 
	          } 
	        });  // End of function call sort(). 
	    } 
}