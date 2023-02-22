import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {

	
	public static void main(String[] args) {
		String s = "C";
		List<String> result = new ArrayList<>();
		printLetterCasePermutation(s,"",s.length(),result,0);
	}

	private static void printLetterCasePermutation(String s,String permutation,int length,List<String> result, int startIndex) {
		if(permutation.length() == length) {
			System.out.println(permutation);
			result.add(permutation);
			return ;
		}
		
		    char ch = s.charAt(startIndex) ;
			if(Character.isDigit(ch)) {
				printLetterCasePermutation(s,permutation+ch,length,result, startIndex+1);
			}
			else {
			printLetterCasePermutation(s, permutation + ch, length, result, startIndex + 1);
			if (Character.isLowerCase(ch)) {
				printLetterCasePermutation(s, permutation + Character.toUpperCase(ch), length, result, startIndex + 1);
			}
			if (Character.isUpperCase(ch)) {
				printLetterCasePermutation(s, permutation + Character.toLowerCase(ch), length, result, startIndex + 1);
			}
				
			}
		
		}
}
