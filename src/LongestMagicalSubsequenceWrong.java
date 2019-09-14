
public class LongestMagicalSubsequenceWrong {

	public static void main(String args[]) {
		String s = "aeiaaioooaauuaeiou" ;
		String v= "aeiou";
		
		String x = getLongestMagicalSubSequence(s,v,0,0) ;
		System.out.println("Longest Magical subsequence is : " +x + " and its length is : " + x.length()) ;
		
		
	}

	private static String getLongestMagicalSubSequence(String givenString, String vowels, int i, int j) {
		String subSequence = "" ;
		int index,noOfVowelsUsed=5;
		
		while(i<givenString.length() && j < vowels.length()) {
			if(givenString.charAt(i) != vowels.charAt(j)) {
				i++;
			}
			else {
				char ch = givenString.charAt(i);
				index = findConsecutiveLastIndex(givenString,i,ch) ;
				String toBeAdded = givenString.substring(i, index+1);
						
				subSequence = subSequence + toBeAdded ;
				i=index+1 ;
				j++;
				noOfVowelsUsed = noOfVowelsUsed-1 ;
			}
				
			
		}
		
		if(noOfVowelsUsed >0) 
			return "No Magical subsequence exists for the given String" ;
		
		return subSequence;
	}


	private static int findConsecutiveLastIndex(String string, int startIndex, char ch) {
		int index = startIndex ;
		int i;
		for( i=startIndex ; i+1 < string.length() ; i++) {
			if(string.charAt(i+1) != ch) {
				index = i ;
				break;
			}
		}
		if(i==string.length()-1 && string.charAt(i) == ch)
			index = string.length()-1;
			
		return index ;
	}
}
