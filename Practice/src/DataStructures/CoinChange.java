package DataStructures;

import java.util.ArrayList;
import java.util.List;

public class CoinChange {

    public static void main(String args[]) {
        int[] coins = {25,10,5,1} ;
        List<Integer> solution = new ArrayList<Integer>() ;
         change(10,coins,solution) ;
        
        System.out.println("no. of coins needed : "  );
    }
    
    public static int change(int x,int[] coins,List<Integer> solution) {
        if(x==0){

            solution.forEach(ele->System.out.print(ele+":"));
            System.out.println("print solution: ");
           // solution.clear();
            return 0 ;
        }
        int min = x ;
        for(int coin : coins) {
            if(x>=coin) {
                solution.add(coin) ;
                int c= change(x-coin,coins,solution) ;
                solution.remove(solution.size()-1) ;
                if(min>c+1)
                    min = c+1 ;
            }
        }
        return min ;
    }
}
