//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.LinkedHashMap;
//import java.util.List;
//import java.util.Map;
//
//public class InsertInterval {
//	public static void main(String args[]) {
//	List<Interval> intervalList = new ArrayList<Interval>() ;
//	Interval i1 = new Interval(0,1) ;
//	
//	Interval i2 = new Interval(5,5);
//	Interval i3 = new Interval(6,7);
//	Interval i4 = new Interval(9,11);
//	Interval i5 = new Interval(12,16);
//	
//	intervalList.add(i1);
//	intervalList.add(i2);
//	intervalList.add(i3);
//	intervalList.add(i4);
////	intervalList.add(i5);
//	
//	Interval newInterval = new Interval(12,21) ;
//	List<Interval> inserted = insert(intervalList,newInterval) ;
//	
//	System.out.println("hello");
//	
//	}
//	
//	 public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
//		 if(intervals.isEmpty() ) {
//			 List<Interval> newIntervalList = new ArrayList<Interval>() ;
//			 newIntervalList.add(newInterval);
//			 return newIntervalList;
//		 }
//		 int start = intervals.get(0).start;
//		 int end = intervals.get(intervals.size()-1).end;
//		 if(newInterval.start==newInterval.end) {
////			 
////			 if(newInterval.start < start ) {
////				 intervals.add(0,newInterval) ;
////			 }
////			 return intervals ;
////			 
////		 }
////		 
////		 if(newInterval.start == newInterval.end) {
////			 
////			 if(newInterval.start>end) {
////				 intervals.add(newInterval) ;
////				 return intervals ;
////			 }
////		 }
//		 
//		 if(newInterval.start > end ) {
//			 intervals.add(newInterval) ;
//			 return intervals ;
//		 }
//		 
//		 if( newInterval.end < start) {
//			 intervals.add(0,newInterval) ;
//			 return intervals;
//		 }
//		 List<Interval> intervalsToReturn = new ArrayList<Interval>() ;
//		 Map<Integer,Integer> intervalsMap = buildLinkedHashMap(intervals,newInterval) ;
//		 intervalsMap = updateMap(intervalsMap,newInterval,intervals) ;
//		 
//		 intervalsToReturn = buildListFromMap(intervalsMap) ;
//		 for(Interval i : intervals) {
//			 if(i.start==i.end && i.start < newInterval.start) 
//				 intervalsToReturn.add(i);
//		 }
//		 
//		 
//		 
//		 return intervalsToReturn ;
//	 }
//
//	private static List<Interval> buildListFromMap(Map<Integer, Integer> intervalsMap) {
//		List<Integer> keyList = buildKeyList(intervalsMap) ;
//		List<Interval> intervalsToReturn = new ArrayList<Interval>();
//		int i=keyList.get(0);
//		int start,end;
//		int lastIndex = keyList.get(keyList.size()-1) ;
//		while(i < keyList.get(keyList.size()-1)) {
//			start = i ;
//			end = findFirstZeroFromStart(keyList,intervalsMap,start);
//			Interval interval = new Interval(start,end) ;
//			intervalsToReturn.add(interval);
//			
//			if(end == lastIndex)
//				break ;
//		   i=findIndexOfFirstNonZeroFromCurrentEnd(keyList,intervalsMap,end) ;
//			
//		}
//		
//		return intervalsToReturn;
//	}
//
//	private static int findIndexOfFirstNonZeroFromCurrentEnd(List<Integer> keyList, Map<Integer, Integer> intervalsMap, int end) {
//		int lastIndex = keyList.get(keyList.size()-1) ;
//		int  indexToReturn =0 ;
//		for(int i=end+1 ; i < lastIndex ; i++ ) {
//		 
//		  if(intervalsMap.get(i) >= 1) {
//			  indexToReturn = i;
//			 break ; 
//		
//		  }
//		  }
//		
//		return indexToReturn ;
//		
//	}
//
//	private static int findFirstZeroFromStart(List<Integer> keyList, Map<Integer, Integer> intervalsMap, int start) {
//		int lastIndex = keyList.get(keyList.size()-1) ;
//		int  indexToReturn = 0 ;
//		for(int i=start+1 ; i <= lastIndex ; i++ ) {
//		  if(intervalsMap.get(i) == 0) {
//			  indexToReturn = i;
//			 break ; 
//		
//		  }
//		  }
//		
//		return indexToReturn ;
//	}
//
//	private static List<Integer> buildKeyList(Map<Integer, Integer> intervalsMap) {
//		List<Integer> keyList = new ArrayList<Integer>();
//		
//		  // using iterators 
//        Iterator<Map.Entry<Integer, Integer>> itr = intervalsMap.entrySet().iterator(); 
//          
//        while(itr.hasNext()) 
//        { 
//             Map.Entry<Integer, Integer> entry = itr.next(); 
//             keyList.add(entry.getKey()) ;
//           
//        } 
//     
//	
//		return keyList;
//	}
//
//	private static Map<Integer, Integer> updateMap(Map<Integer, Integer> intervalsMap, Interval newInterval, List<Interval> intervals) {
//		for(int i=newInterval.start ; i < newInterval.end ; i++) {
//			Integer integer = intervalsMap.get(i);
//			if(integer == null) 
//				intervalsMap.put(i,1);
//			else
//			intervalsMap.put(i,integer.intValue()+1) ;
//			
//		}
//	
//		return intervalsMap;
//	}
//
//	private static Map<Integer, Integer> buildLinkedHashMap(List<Interval> intervals, Interval newInterval) {
//		Map<Integer,Integer> intervalsMap = initializeMap(intervals,newInterval) ;
//		for(Interval interval : intervals) {
//			for(int i=interval.start ; i< interval.end ; i++) {
//				int value = intervalsMap.get(i) ;
//				intervalsMap.put(i,value+1) ;
//		   
//		}
//		
//		}
//		return intervalsMap;
//	}
//
//	private static Map<Integer, Integer> initializeMap(List<Interval> intervals, Interval newInterval) {
//		Map<Integer,Integer> initializedMap = new LinkedHashMap<Integer,Integer>() ;
//		int last = intervals.get(intervals.size()-1).end ;
//		int first = intervals.get(0).start ;
//		
//		int smallest=Math.min(first, newInterval.start) ;
//		int largest=Math.max(last, newInterval.end) ;
//		for(int i=smallest;i<=largest;i++)
//			initializedMap.put(i,0) ;
//		
//		return initializedMap;
//	}
//}