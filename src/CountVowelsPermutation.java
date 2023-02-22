import java.util.HashMap;
import java.util.Map;

public class CountVowelsPermutation {
	public static void main(String[] args) {
		int num = countVowelPermutation(5);
		System.out.println("no. of vowel permutations is : " + num);
	}

	private static int countVowelPermutation(int n) {
		char[] vowels =  {'a','e','i','o','u'};
		int totalPermutations = 0;
		Map<String,Integer> cache = new HashMap<>();
		for(int i=0;i<vowels.length ;i++) {
			totalPermutations+= countVowelPermutation(vowels,Character.toString(vowels[i]),vowels[i],n,cache);
		}
		return totalPermutations;
	}

	private static int countVowelPermutation(char[] vowels, String permutation,char currChar, int n, Map<String, Integer> cache) {
		String key = permutation+"_"+currChar;
		if(cache.get(key) != null)
			return cache.get(key);
		int count = 0;
		if(permutation.length() == n) {
			//System.out.println(permutation);
			return 1;
		}
		
			if(currChar == 'a') {
				count = count + countVowelPermutation(vowels,permutation + 'e','e',n,cache) ;
			}
			if(currChar == 'e') {
				count = count + countVowelPermutation(vowels,permutation + 'a','a',n,cache) ;
				count = count + countVowelPermutation(vowels,permutation + 'i','i',n,cache) ;
			}
			if(currChar == 'i') {
				count = count + countVowelPermutation(vowels,permutation+'a','a',n,cache);
				count = count + countVowelPermutation(vowels,permutation+'e','e',n,cache);
				count = count + countVowelPermutation(vowels,permutation+'o','o',n,cache);
				count = count + countVowelPermutation(vowels,permutation+'u','u',n,cache);
				
			}
			
			if(currChar == 'o') {
				count = count + countVowelPermutation(vowels,permutation + 'i','i',n,cache) ;
				count = count + countVowelPermutation(vowels,permutation + 'u','u',n,cache) ;
			}
			
			if(currChar == 'u') {
				count = count + countVowelPermutation(vowels,permutation + 'a','a',n,cache) ;
			}
			
			cache.put(key,count);
			return count;
		}

}
