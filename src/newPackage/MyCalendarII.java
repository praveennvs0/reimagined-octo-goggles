package newPackage;

import java.util.ArrayList;
import java.util.List;

public class MyCalendarII {
	private static List<int[]> list = new ArrayList<>();

	public static void main(String[] args) {
		boolean b = false;
		b = book(10,20);
		System.out.println(b);
		b = book(50,60);
		System.out.println(b);
		b = book(10,40);
		System.out.println(b);
		b = book(5,15);
		System.out.println(b);
		b = book(5,10);
		System.out.println(b);
		b = book(25,55);
		System.out.println(b);
		
		System.out.println("Completed");

	}

	public static boolean book(int startTime, int endTime) {
		System.out.println();
	System.out.println("Processing interval with startTime " + startTime +" and endTime " + endTime);
	int size = list.size();
	if(size == 0 ) {
		int[] interval = {startTime,endTime};
		list.add(interval);
		return true;
	}
	if(endTime < list.get(0)[1]) {
		boolean canInsert = insertInterval(startTime,endTime,0);
        return canInsert;

	}
	if(startTime > list.get(size-1)[1]) {
		boolean canInsert = insertInterval(startTime,endTime,size-1);
        return canInsert;
	}

int n = list.size();
int right = list.size()-1;
int left = 0 ;
//binary Search
while(left <= right) {
	int mid = (left+right+1)/2;
int[] temp = list.get(mid);            // 10,20, 10,25  10,26  10,27
if(startTime == temp[0]) {
// compare EndTimes 
   for(int currIndex = mid ; currIndex < n ; currIndex++) {
    if(list.get(currIndex)[0] != startTime ) {
    	break;
    }
	if(list.get(currIndex)[1] < endTime && currIndex + 1 < size && list.get(currIndex+1)[1] > endTime ) {
		boolean canInsert = insertInterval(startTime,endTime,currIndex);
        return canInsert;
}
}
}


if(startTime > temp[0] && mid+1 < size && startTime < list.get(mid+1)[0]) {  // mid and mid+1
	boolean canInsert = insertInterval(startTime,endTime,mid);
	return canInsert;

}

if(startTime > temp[0]) {
	left = mid+1;
}
else if (startTime < temp[0]){ 
	right = mid-1;
}

}
return false;
}
	
	private static boolean insertInterval(int startTime,int endTime,int mid) {
		int count = 0;
		      // check on both sides ..right and left  .mid+1,mid+2 ,mid,mid-1 
			int[] interval = {startTime,endTime};
		     if(isOverLap(interval,list,mid+1)) {
		count ++;
		}
		if(isOverLap(interval,list,mid+2)) {
		       count++;
		 
		}

		if(count  == 2)
		return false;

		if(isOverLap(interval,list,mid)) 
		count++;
		if(isOverLap(interval,list,mid-1))
		count++;
		
		if(count>=2)
		return false;
		else {
		  list.add(mid+1,interval);
		  return true;
		}

	}

	private static boolean isOverLap(int[] interval1, List<int[]> list, int i) {
		
		if(i < 0 || i >= list.size() )
			return false;
		int[] interval2 = list.get(i);
		
		if(interval1[1] <= interval2[0] || interval1[0] >= interval2[1]) 
			return false;
		
		if(interval2[1] <= interval1[0] || interval2[0] >= interval1[1]) 
			return false;
		System.out.println();
		System.out.println("These two intervals are overlapping : ");
		System.out.print(interval1[0] + "," + interval1[1] +" and " + interval2[0] + "," + interval2[1]);
		System.out.println();
		return true;
	}


}
