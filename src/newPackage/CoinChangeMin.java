package newPackage;

import java.util.ArrayList;
import java.util.List;

public class CoinChangeMin {

	public static void main(String args[]) {
		int[] coins = {1,2,5};
		int amount = 6; 
		List<Integer> coinList = new ArrayList<Integer>();
		int minCoins = findMinCoins(coins,amount,Integer.MAX_VALUE,0,coinList) ;
		System.out.println("min no. of coins is : " + minCoins) ;
		
	}

	private static int findMinCoins(int[] coins, int amount,int minCoins,int change,List<Integer> coinList) {
		if(amount == 0) {
		//	printList(coinList);
			return change;
		}
		
		for(int i=0;i<coins.length; i++) {
			if(coins[i] <= amount ) {
				coinList.add(coins[i]) ;
			 int val = findMinCoins(coins,amount-coins[i],minCoins,change+1,coinList) ;
			if(val < minCoins) {
				minCoins = val ;
			}
			
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
