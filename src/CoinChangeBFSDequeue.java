import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class CoinChangeBFSDequeue {
public static void main(String args[]) {
	int[] coins = {1,2,5};
	
	int number = coinChange(coins,11) ;
	System.out.println("number of coins is : " + number) ;
}
	
	
	
	public static int coinChange(int[] coins, int amount){
	    if(coins == null || coins.length == 0 || amount < 1) return 0;

	    Deque<Integer> queue = new ArrayDeque<Integer>();
	    Set<Integer> visited = new HashSet<Integer>();
	    queue.addFirst(amount);
	    visited.add(amount);
	    int level = 0;

	    while(!queue.isEmpty()){
	      int size = queue.size();

	      while(size-- > 0){
	        int curr = queue.removeLast();
	        if(curr == 0) return level;

	        if(curr < 0) continue;

	        for(int coin : coins){
	          int next = curr - coin;
	          if(next >= 0 && !visited.contains(next)){
	            queue.addFirst(next);
	            visited.add(next);
	          }
	        }
	      }

	      level++;
	    }

	    return -1;
	  }
}
