import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BadSegment {

	public static void main(String args[]) {
		
		List<Integer> badNumbers = new ArrayList<Integer>();
		badNumbers.add(48) ;
		badNumbers.add(14) ;
		badNumbers.add(33) ;
		badNumbers.add(11) ;
		badNumbers.add(17) ;
		badNumbers.add(50) ;
		badNumbers.add(25) ;
		int segment = goodSegment(badNumbers,12,38) ;
		System.out.println("segment size is : " + segment ) ;
	}
	
	 public static int goodSegment(List<Integer> badNumbers, int l, int r) {
		    // Write your code here
		 int maxLength = 0, currentLength = 0 ;
		 int start = l, end = r ;
		 Map<Integer,Boolean> badNumberMap = buildBadNumberMap(badNumbers) ;
		 while(start <= r) {
			 currentLength = 0;
			 int index ;
			 for(index=start;index<=end;index++) {
				 if(badNumberMap.get(index)!=null)
					 break;
				 else {
					 currentLength++;
				 }
			 }
			 maxLength = Math.max(maxLength, currentLength) ;
			 start = index+1 ;
		 }
		 
		 
		 return maxLength ;
		    }

	private static Map<Integer, Boolean> buildBadNumberMap(List<Integer> badNumbers) {
		// TODO Auto-generated method stub
		Map<Integer,Boolean> badNumberMap = new HashMap<Integer,Boolean> () ;
		 for(Integer integer : badNumbers) {
			 badNumberMap.put(integer, true) ;
		 }
		return badNumberMap;
	}
}
