import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lottery {

	public static void main(String args[]) {
		List<Long> longList = waysToChooseSum(3,12) ;
		System.out.println("hello") ;
	}
	
	 public static List<Long> waysToChooseSum(long a, long b) {
		    // Write your code here
		 List<Long> ways = new ArrayList<Long>() ;
		 Map<Long,Integer> digitSumFrequencyMap = new HashMap<Long,Integer>() ;
		 for(long l=a;l<=b;l++ ) {
			 long digitSum = findDigitSum(l) ;
			
			 digitSumFrequencyMap.put(l,(int) digitSum) ;
		 }
		 
		 
		 List<Integer> tempList = new ArrayList<Integer>();
		 for(Long sum : digitSumFrequencyMap.keySet()) {
			 tempList.add(digitSumFrequencyMap.get(sum)) ;
		 }
		 
		 Map<Integer,Integer> freqMap = buildFreqMap(tempList) ;
		 
		 List<Integer> temp2List = new ArrayList<Integer>() ;
		 for(Integer key : freqMap.keySet()) {
			 temp2List.add(freqMap.get(key)) ;
		 }
		 
		 Collections.sort(temp2List);
		 int maxWinners = temp2List.get(temp2List.size()-1) ;
		 int noOfWays = findWays(temp2List,maxWinners) ;
		 ways.add((long) noOfWays);
		 ways.add((long) maxWinners) ;
		 return ways ;

		    }

	private static Map<Integer, Integer> buildFreqMap(List<Integer> tempList) {
		// TODO Auto-generated method stub
		Map<Integer,Integer> frequencyMap = new HashMap<Integer,Integer>();
		for(Integer integer: tempList) {
			if(frequencyMap.get(integer)==null)
				frequencyMap.put( integer,1) ;
			else
				frequencyMap.put(integer,frequencyMap.get(integer) + 1 );
		}
		
		return frequencyMap;
	}

	private static int findWays(List<Integer> tempList, int maxWinners) {
		int count = 0;
		for(int i= tempList.size() -1 ; i>=0 ; i-- ) {
			if(tempList.get(i) != maxWinners)
				break;
			else
				count++ ;
			
			
		}
		return count;
	}

	private static long findDigitSum(long num) {
		long sum = 0;
		long digit = 0;
		while(num>0) {
			digit = num % 10 ;
			sum+= digit ;
			num=num/10;
			
		}
		return sum;
	}
}
