import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution1 {

    // Complete the stockmax function below.
    static int stockmax(int[] prices) {

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
      

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] prices = new int[n];

            String[] pricesItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int pricesItem = Integer.parseInt(pricesItems[i]);
                prices[i] = pricesItem;
            }

            int result = stockmax(prices);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
