package newPackage;

import java.util.HashMap;
import java.util.Map;

public class MinLengthSubStringWithExactlyKDistinctCharacters {

	public static void main(String args[]) {
		String s = "ababcb" ;
		int k=3 ;
		String min = getMinLengthSubstring(s,k) ;
		System.out.println("Minimum string is : " + min) ;
	}
	
	public static String getMinLengthSubstring(String s,int k) {
		int left =0, right =0, minLength=Integer.MAX_VALUE,currentLength=0;
		String minString = "" ;
		int formed = 0,minLeft=0,minRight=0;
		boolean isExists = false ;
		Map<Character,Integer> dictionary = new HashMap<Character,Integer> () ;
		while(left<=right && right < s.length()) {
			
			char ch = s.charAt(right) ;
			if(dictionary.get(ch) == null || dictionary.get(ch)==0) {
				dictionary.put(ch,1);
				formed++;
			}
			else {
				dictionary.put(ch,dictionary.get(ch)+1);
			}
			
			while(formed == k && left <= right) {
				isExists = true ;
				char leftChar = s.charAt(left) ;
				currentLength = right-left+1;
			
				if(currentLength < minLength) {
					minLength = currentLength ;
					minLeft = left ;
					minRight = right ;
				}
				dictionary.put(leftChar, dictionary.get(leftChar)-1) ;
				if(dictionary.get(leftChar) <= 0) {
					formed--;
				}
				left++;
			}
			
			
			right++;
		}
		
		
		if(isExists && minLength >0) {
			minString = s.substring(minLeft,minRight+1) ;
		}
		else {
			 minString = "No such substring exists";
		}
		return  minString ;
		
	}
}
