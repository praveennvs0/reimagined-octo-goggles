
public class CountSortedVowelStrings {

	public static void main(String[] args) {
		
		int n=1;
		sortedVowels(n);
	}

	private static void sortedVowels(int n) {
		char[] vowels = {'a','e','i','o','u'};
		sortedVowels(vowels,n,0,"");
	}

	private static void sortedVowels(char[] vowels, int n,int start,String vowelString) {
			if(vowelString.length() == n) {
				System.out.println(vowelString);
				return ;
			}
			
		
		for(int i=start;i < vowels.length ; i++) {
			char ch = vowels[i];
			sortedVowels(vowels,n,i,vowelString+ch);
		}
		
	}
}
