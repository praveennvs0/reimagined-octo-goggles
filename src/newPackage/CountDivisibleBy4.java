package newPackage;

import java.util.*; 

public class CountDivisibleBy4{ 
    public static int count4Divisibiles(int arr[] ,  
                                             int n ) 
    { 
        // Create a frequency array to count  
        // occurrences of all remainders when  
        // divided by 4 
        int freq[] = {0, 0, 0, 0}; 
        int i = 0; 
        int ans; 
          
        // Count occurrences of all remainders 
        for (i = 0; i < n; i++) 
                ++freq[arr[i] % 4]; 
          
        //If both pairs are divisible by '4' 
        ans = freq[0] * (freq[0] - 1) / 2; 
      
        // If both pairs are 2 modulo 4 
        ans += freq[2] * (freq[2] - 1) / 2; 
      
        // If one of them is equal 
        // to 1 modulo 4 and the 
        // other is equal to 3  
        // modulo 4 
        ans += freq[1] * freq[3]; 
      
        return (ans); 
    } 
    public static void main(String[] args) 
    { 
        int arr[] = {2, 2, 1, 7, 5}; 
        int n = 5; 
        System.out.print(count4Divisibiles(arr, n)); 
    } 
} 