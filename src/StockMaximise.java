
public class StockMaximise {

	public static void main(String args[]) {
	
		int[] prices = {5,4,3,4,5} ;
		int maxProfit = stockMax(prices) ; 
				
		System.out.println("maximum profit is : " + maxProfit) ;
	}

	private static int stockMax(int[] prices) {
		
		int profit = stockMaximise(prices,0,0,0) ;
		return profit;
	}

	private static int stockMaximise(int[] prices, int profit, int i, int stockCount) {
		if(i>=prices.length) {
			return profit;
		}
		
		int buy = stockMaximise(prices,profit-prices[i],i+1,stockCount+1) ;
		int doNothing=stockMaximise(prices,profit,i+1,stockCount);
		int sell = 0 ;
		for (int k=1; k<= stockCount ; k++) {
			int sellingPrice = stockMaximise(prices,profit+(prices[i] * k) ,i+1, stockCount-k);
			sell = Math.max(sell, sellingPrice) ;
			
		}
		
		profit = Math.max(Math.max(buy, doNothing),sell);
		return profit;
	}
	
	
}
