import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class CoinChangeBFS {

	public static void main(String args[]) {
		int[] coins = {1,2,5};
		int x = findMinCoins(coins,11) ;
		System.out.println("min no. of coins is : " + x) ;
	}

	private static int findMinCoins(int[] coins, int amount) {
		
		Queue<Integer> queue = new LinkedList<>() ;
		queue.add(amount);
		Map<Integer,Integer> valueToLevelMap = new HashMap<Integer,Integer>();
		 valueToLevelMap.put(amount,0) ;
		Set<Integer> visited = new HashSet<Integer>();
		int currLevel=0;
		while(!queue.isEmpty()) {
			int element = queue.remove();
			for(Integer coin:coins) {
				if(!visited.contains(element-coin)) {
				queue.add(element-coin) ;
			    currLevel = valueToLevelMap.get(element) ;
				valueToLevelMap.put(element-coin,currLevel+1 );
				visited.add(element-coin);
				if(element-coin==0) {
					return currLevel+1 ;
				}
					
				
				}
				
			}
			
			
		}
		
		return currLevel;
	}
}
