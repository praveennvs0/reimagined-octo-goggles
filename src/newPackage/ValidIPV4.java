package newPackage;

import java.util.*;
import java.io.*;

// Main class should be named 'Solution'




public class ValidIPV4 {
    private static List<String> result = new ArrayList<>();
    
    public static void main(String[] args) {
        String s = "101023";
        validIPs(s);
        
    }


private static void validIPs(String s) {
    List<Integer> positions = new ArrayList<>();
    findIPs(s,0,3,positions,s);
}


/**

Q1: All Possible Valid IPs

String -> Input
All Possible Valid IPs -> By placing 3 dots.
Output -> List of strings -> each string is a valid ip.

String[] ValidIPs(String)

Input: "0000"
Output: ["0.0.0.0"]

Input : "25525511135"
Output : ["255.255.11.135", "255.255.111.35"]

Input : "255.05011535"
Output : []

Valid IPv4:
1. 4 segments - each separated by a dot.
2. Every segment:
    1. 0 <= x <= 255
    2. only digits
    3. no leading zeros
        01 -> invalid (0.01.0.1)
        0 -> valid (0.1.0.1)

**/


public static void findIPs(String s,int index,int count,List<Integer> positions,String temp) {
    if(index >= s.length())
    return ;
    
    if(count == 0) {
        
        String lastSegment = s.substring(index);
        
        if(isValid(lastSegment)) {
            String validIp = generateIp(temp,positions) ;
            result.add(validIp);
        }
        else {
            return ;
        }
    }

    for(int i=index;i<s.length() && i < index+4;i++) {
        String substr = s.substring(index,i);
        if(isValid(substr)) {
            
            positions.add(i);
            findIPs(s,i,count-1,positions,temp) ;
            if(positions.size() > 0) {
                positions.remove(positions.size()-1);
            }
        }
    }
}
    
    
    
private static String generateIp(String s,List<Integer> positions) {
   String result = "";
   
   int j = 0;
   for(int i=0;i<s.length() ;i++) {
       if(j == 3 ) {
           result+= s.substring(i);
           break;
       }
       if( i == positions.get(j)) {
           
           result += ".";
           
           j++;
       }
       result+= s.charAt(i);
       
   }
   return result;

}

private static boolean isValid(String s) {
    if(s.isEmpty()) return false;
    if(s.charAt(0) == '0') {
        return s.length() == 1 ;
    }
    
    
    
    try {
    int number = Integer.parseInt(s) ;
    if(number < 0 || number > 255)
    return false;
    }
    catch(NumberFormatException e) {
        return false;
    }
    
    return true;
}}