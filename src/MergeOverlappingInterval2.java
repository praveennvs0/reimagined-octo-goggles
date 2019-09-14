import java.util.ArrayList;
import java.util.List;

public class MergeOverlappingInterval2 {
	public static void main(String args[]) {
		Interval i1 = new Interval(1,10);
		Interval i2 = new Interval(2,3);
		Interval i3 = new Interval(4,5);
		Interval i4 = new Interval(6,7);
		Interval i5 = new Interval(8,9);
		
		
		
		List<Interval> intervalList = new ArrayList<Interval>();
		
		intervalList.add(i1);
		intervalList.add(i2);
		intervalList.add(i3);
		intervalList.add(i4);
		intervalList.add(i5);
		
	    boolean isOverlap = overlappingIntervals(i1,i5) ;
	    System.out.println(isOverlap);
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
		Interval lastElementOfFirstList = left.get(left.size()-1) ;
		Interval firstElementOfSecondList = right.get(0);
		List<Interval> mergedList = new ArrayList<Interval>();
		if(overlappingIntervals(lastElementOfFirstList,firstElementOfSecondList)) {
			int startingTime = Math.min(lastElementOfFirstList.start, firstElementOfSecondList.start) ;
			int maxEnd = Math.max(lastElementOfFirstList.end, firstElementOfSecondList.end);
			
			Interval combinedInterval = new Interval(startingTime,
					maxEnd) ;
			//remove the last element of the left list and the first element of the right list
			left.remove(left.size()-1) ;
			left.add(combinedInterval);
			//joining the compartments
			right.remove(0);
			left.addAll(right);
			return left ;
			
		}
		else
		{
			mergedList.addAll(left);
			mergedList.addAll(right);
			return mergedList ;
		}
		
	}

	private static boolean overlappingIntervals(Interval first, Interval second) {
		if(second.start >= first.start && second.start <= first.end) 
			return true ;
		if(second.start <= first.start && second.end >= first.start)
			return true ;
		
		
		return false;
	}
}
