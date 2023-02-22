package newPackage;

import java.util.Arrays;
import java.util.Collections;

public class SmallestValueOfRearranged {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			long num = -7605;
			long x = rearrangeNumber(num);
			System.out.println(x);
			
			
	}

	
	private static long rearrangeNumber(long num) {
		
		if(num > 0) {
		
		return rearrangeNumber1(num);
		
		}
		else {
			return rearrangeNumber2(num);
		}
		
		
	}
	
	private static long rearrangeNumber2(long num) {
		num  = Math.abs(num);
		long digitToRemove = findLargest(num);
		String str = Long.toString(num);
		int index = 0,j=0;
		int[] digitArr = new int[str.length()-1];
		
		for(int i=0;i<str.length();i++) {
			char ch = str.charAt(i);
			if(ch - '0' == digitToRemove) {
				index = i;
				break;
			}
			else {
				digitArr[j++] =  ch - '0';
			} 
		}
		
		for(int i=index+1;i<str.length() ; i++) {
			digitArr[j++] = str.charAt(i) - '0' ;
		}
		
		
		int[] arrDesc = Arrays.stream(digitArr).boxed()
	    .sorted(Collections.reverseOrder())
	    .mapToInt(Integer::intValue)
	    .toArray();
		
		String s = "";
		for(int i=0;i<arrDesc.length;i++) {
			int digit = arrDesc[i];
			
			s = s + String.valueOf(digit);
		}
		
		String smallest = String.valueOf(digitToRemove);
		String res = smallest + s ;
		
		return -Long.valueOf(res);
		
	}
	
	
	private static long rearrangeNumber1(long num) {
		long digitToRemove = findSmallest(num);
		String str = Long.toString(num);
		int index = 0,j=0;
		char[] digitArr = new char[str.length()-1];
		
		for(int i=0;i<str.length();i++) {
			char ch = str.charAt(i);
			if(ch - '0' == digitToRemove) {
				index = i;
				break;
			}
			else {
				digitArr[j++] =  ch;
			} 
		}
		
		for(int i=index+1;i<str.length() ; i++) {
			digitArr[j++] = str.charAt(i) ;
		}
		
		Arrays.parallelSort(digitArr);
		String s = "";
		for(int i=0;i<digitArr.length;i++) {
			s = s + digitArr[i];
		}
		
		String smallest = String.valueOf(digitToRemove);
		String res = smallest + s ;
		
		return Long.valueOf(res);
		
	}

	private static long findSmallest(long num)
    {
		long smallestDigit = 9;
        long digit;
        while(num != 0)
        {
        	
            digit = num % 10;
            if(digit != 0 ) {
            smallestDigit = Math.min(digit, smallestDigit);
            }
            num = num / 10;
        }
        return smallestDigit;
    }
	
	private static long findLargest(long num)
    {
		long largestDigit = 0;
        long digit;
        while(num != 0)
        {
            digit = num % 10;
            if(digit != 0 ) {
            largestDigit = Math.max(digit, largestDigit);
            }
            num = num / 10;
        }
        
        return largestDigit;
    }
 
}
