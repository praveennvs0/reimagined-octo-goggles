
public class CoinChange {
	public static void main(String[] args) {
		int[] coins = {2};
		int amount = 3;
		int min = coinChange(coins,amount);
		System.out.println("Minimum no. of coins is : " + min);
		
	}

	
public static int coinChange(int[] coins, int amount) {

	if(amount == 0)
		return 0;
	int min = amount;
	for(int i=0;i<coins.length;i++) {
		if(coins[i]<= amount) {
		int curr = 1 + coinChange(coins,amount-coins[i]);  
		min = Math.min(curr, min);
		}
		
	}
	
	
	return min;
    }

}
