import java.util.ArrayList;
import java.util.List;

public class MergeOverlappingInterval {
	public static void main(String args[]) {
		Interval i1 = new Interval(8,10);
		Interval i2 = new Interval(1,3);
		Interval i3 = new Interval(15,18);
		Interval i4 = new Interval(2,6);
		
		
		
		List<Interval> intervalList = new ArrayList<Interval>();
		intervalList.add(i1);
		intervalList.add(i2);
		intervalList.add(i3);
		intervalList.add(i4);
	
		List<Interval> mergedList = merge(intervalList) ;
		print(mergedList);
		
	}
	  private static void print(List<Interval> mergedList) {
		  System.out.println("Printing time intervals") ;
		  for(Interval i: mergedList) {
			  System.out.print("[");
			  System.out.print(i.start);
			  System.out.print(",");
			  System.out.print(i.end);
			  System.out.print("],");
		  }
		  
	}
	public static List<Interval> merge(List<Interval> intervals) {
		if(intervals.isEmpty())
			return intervals ;
		List<Interval> mergedList = merge(intervals,0,intervals.size()-1) ;
		return mergedList ;
		
	    }

	private static List<Interval> merge(List<Interval> intervals, int low, int high) {
		if(low < high) {
			int mid = (low+high)/2 ;
			List<Interval> left = merge(intervals,low,mid);
			List<Interval> right = merge(intervals,mid+1,high);
			List<Interval> combined = mergeOverlapping(left,right) ;
			return combined ;
		}
		else {
			List<Interval> singleElement = new ArrayList<Interval>();
			singleElement.add(intervals.get(low));
			return singleElement ;
		}
		
		
	}
	private static List<Interval> mergeOverlapping(List<Interval> left, List<Interval> right) {
		List<Interval> mergedList = new ArrayList<Interval>();
		int i=0,j=0;
		
		while(i<left.size() && j < right.size()) {
			Interval leftInterval = left.get(i) ;
			Interval rightInterval = right.get(j) ;
			if(overlappingIntervals(leftInterval,rightInterval)) {
				int startingTime = Math.min(leftInterval.start, rightInterval.start) ;
				int endingTime = Math.max(leftInterval.end, rightInterval.end) ;
				Interval newNode = new Interval(startingTime,endingTime);
				mergedList.add(newNode) ;
				i++;
				j++;
			}
			
			else if(leftInterval.start <= rightInterval.start) {
				mergedList.add(leftInterval);
				i++ ;
							}
			
			else {
				mergedList.add(rightInterval);
				j++;
			}
		}
		
		if(i < left.size()) {
			mergedList.addAll(left.subList(i, left.size())) ;
		}
		
		if(j<right.size()) {
			mergedList.addAll(right.subList(j, right.size())) ;	
		}
		
		
		return mergedList;
	}
	

	private static boolean overlappingIntervals(Interval first, Interval second) {
		if(second.start >= first.start && second.start <= first.end) 
			return true ;
		if(second.start <= first.start && second.end >= first.start)
			return true ;
		
		
		return false;
	}
}
