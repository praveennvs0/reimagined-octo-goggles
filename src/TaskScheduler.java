import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class TaskScheduler {

	public static void main(String args[]) {
		char[] tasks = {'B','B','A','A','A'} ;
		int number = leastInterval(tasks,2) ;
		System.out.println("least interval is :" + number) ;
	}

	private static int leastInterval(char[] tasks, int n) {
		Map<Character,Integer> taskMap = buildTaskMap(tasks) ;
		
		char[] interval = new char[200] ;
		for(int i=0;i<interval.length;i++) {
			interval[i] = '*' ;
		}
		
		
		
		Set<Character> charSet = taskMap.keySet() ;
		
		Iterator<Character> itr = charSet.iterator() ;
		int lastIndex=0;
		while(itr.hasNext()){
			Character ch = itr.next() ;
			System.out.println("Scheduling for task " + ch) ;
			int currFreq=taskMap.get(ch) ;
			lastIndex = fillInIntervalArray(interval,ch,currFreq,n,lastIndex);
			
			}
		return lastIndex+1;
	}

	

	private static int fillInIntervalArray(char[] interval, Character ch,
			int currFreq,int coolingPeriod,int lastIndex) {
		int i=0,currentLastIndex=0;
		while(i<interval.length) {
			if(currFreq==0)
				break;
			if(interval[i]=='*') {
				interval[i]=ch;
				currentLastIndex=i;
				
				i=i+coolingPeriod+1;
				currFreq--;
			}
			else {
				i++;
			}
		
	}
		System.out.println("current last index : " + currentLastIndex) ;
		lastIndex=Math.max(lastIndex, currentLastIndex);
		return lastIndex;
	}

	private static Map<Character, Integer> buildTaskMap(char[] tasks) {
		Map<Character,Integer> taskMap = new HashMap<Character,Integer>() ;
		for(int i=0;i<tasks.length;i++) {
			if(!taskMap.keySet().contains(tasks[i])) {
				taskMap.put(tasks[i],1);
			}
			else {
			int currFrequency = taskMap.get(tasks[i]);
			taskMap.put(tasks[i],currFrequency+1) ;
		}
		}
		
		return taskMap;
	}
}
