package newPackage;

import java.util.ArrayList;
import java.util.List;

public class CoinChangeMinSet {

	public static void main(String args[]) {
		int[] coins = {1,2,5};
		int amount = 11; 
		
		findMinCoins(coins,amount) ;
		
	}

	private static void findMinCoins(int[] coins, int amount) {
		List<Integer> minCoins = new ArrayList<Integer>();
		List<Integer> coinList = new ArrayList<Integer>();
		
		 minCoins = findMinCoins(coins,amount,minCoins,0,coinList) ;
		 
		 //display
		 System.out.println("Min no. of coins for amount " + amount + " needed is : " + minCoins.size()) ;
		 System.out.print("Coins are : ") ;
		 minCoins.forEach(x-> {System.out.print(x) ;
		  System.out.print(",");
		 }
		 );
		
	}

	private static List<Integer> findMinCoins(int[] coins, int amount,List<Integer> minCoins,int change,List<Integer> coinList) {
		if(amount == 0) {
			return coinList;
		}
		
		for(int i=0;i<coins.length; i++) {
			if(coins[i] <= amount ) {
				coinList.add(coins[i]) ;
			 List<Integer> changeList = findMinCoins(coins,amount-coins[i],minCoins,change+1,coinList) ;
			if(minCoins.isEmpty() || changeList.size() < minCoins.size()) {
				minCoins = createCopyOfList(changeList) ;
			}
			
			if(!coinList.isEmpty())
			coinList.remove(coinList.size()-1);
		
			}
		}
		
		
		return minCoins ;
	}
	
	private static List<Integer> createCopyOfList(List<Integer> originalList) {
		List<Integer> newList = new ArrayList<Integer>();
		for(Integer x: originalList) {
			newList.add(x.intValue()) ;
		}
		return newList;
	}

	private static void printList(List<Integer> numsList) {
		System.out.println("Combination found : " ) ;
		for(Integer x : numsList) {
			System.out.print(x+" : ");
		}
		System.out.println(" ");
		
	}
}
