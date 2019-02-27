package Interview;

import java.util.Arrays;
import java.util.List;

//you can also use imports, for example:
//import java.util.*;

//you can write to stdout for debugging purposes, e.g.
//System.out.println("this is a debug message");

public class Solution {
 
    
public static void main(String args[]) {
    int M=3 ; 
    int[] A = {1,2,2,2} ;
    //int[] A = {2} ;
    
    
    int x = solution(M,A) ;
    System.out.println(x);
}

       public static int solution(int M, int[] A) {
            int N = A.length;
            
            int[] count = new int[M + 1];
            for (int i = 0; i <= M; i++)
                count[i] = 0;
            int maxOccurence = 0;
            int index = 0;
            for (int i = 0; i < N; i++) {
                if (count[A[i]] > 0) {
                    int tmp = count[A[i]];
                    if (tmp > maxOccurence) {
                        maxOccurence = tmp;
                        index = i;
                    }
                    count[A[i]] = tmp + 1;
                } else {
                    count[A[i]] = 1;
                }
            }
            return A[index];
        }
}