
public class CombinationsOfAGivenLength {

	public static void main(String[] args) {
		String s = "abcd" ;
		printCombinations(s,3);
		
	}

	private static void printCombinations(String s, int len) {
		printCombinations(s,len,0,"");
	}

	private static void printCombinations(String s, int len, int startIndex, String combination) {
		if(combination.length() == len) 
			System.out.println(combination);
		if(combination.length() > len)
			return;
		for(int i=0 ; i < s.length() ; i++) {
			combination = combination + s.charAt(i);
			printCombinations(s.substring(i+1),len,0,combination);
			combination = combination.substring(0, combination.length()-1);
		}
		
		
	}
}
