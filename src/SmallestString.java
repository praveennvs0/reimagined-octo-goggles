
public class SmallestString {
	private static int count;
	private static String currMin = "";

	public static void main(String[] args) {
		String x = getSmallestString(3,27);
		System.out.println("string is : " + currMin);
		
		
	}
	
	  public static String getSmallestString(int n, int k) {
		  
		  char[] charArray = new char[26];
			int i=0;
			for(char ch='a';ch<='z';ch++) {
				charArray[i] = ch;
				i++;
			}
			
			printAllCombinations(charArray,0,"",0,n,k);
			
	        return "";
	    }

	private static void printAllCombinations(char[] charArray, int start, String combination, int weight, int n, int k) {
		
		if(combination.length() == n && weight == k) {
			//System.out.println(combination);
			count++;
			if(currMin == "") 
				currMin = combination;
			if(combination.compareTo(currMin) < 0) {
				currMin = combination;
			}
		}
		
		if(combination.length() > n || weight > k)
			return;
		
		for(int i=start; i < charArray.length ; i++) {
			int charWeight = charArray[i] - 'a' + 1;
			printAllCombinations(charArray,start,combination+charArray[i],weight + charWeight,n,k);
		}
	}
	  
	  

}
