import java.util.HashSet;
import java.util.Set;

public class SoldierRank {
public static void main(String args[]) {
	int[] ranks = {4,4,3,3,1,0};
	int x = solution(ranks) ;
	System.out.println(x) ;
}
	
	
	 public static int solution(int[] ranks) {
	        // write your code in Java SE 8
		 Set<Integer> rankSet = new HashSet<Integer>() ;
		 for(int i=0;i<ranks.length ; i++ ) 
			 rankSet.add(ranks[i]) ;
		 
		 int count = 0;
		 
		 for(int i=0;i<ranks.length;i++) {
			 int rank = ranks[i] ;
			 if(rankSet.contains(rank+1))
				 count++;
			 
		 }
		 
		 return count;
	    }
}
