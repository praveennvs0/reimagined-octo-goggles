import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SherlockAndAnagram {
	
	public static void main(String args[]) {
		
		String s = "kkkk" ;
		int count = sherlockAndAnagrams(s) ;
		System.out.println("no .of anagram pairs is : " + count) ;
	}

	static int sherlockAndAnagrams(String s) {

		int count = 0;
		Map<String, Integer> subStringFrequencyMap = buildSubStringFrequencyMap(s);
		for (String key : subStringFrequencyMap.keySet()) {
			if (subStringFrequencyMap.get(key) > 1) {
				count++;
			}

		}

		return count;

	}

	public static Map<String, Integer> buildSubStringFrequencyMap(String s) {

		Map<String, Integer> subStringFrequencyMap = new HashMap<String, Integer>();
		for (int i = 0; i < s.length(); i++) {
			for (int j = i; j < s.length(); j++) {
				String substr = s.substring(i, j+1);
				char[] ch = substr.toCharArray();

				Arrays.sort(ch);
				String newString = new String(ch);

				if (subStringFrequencyMap.get(newString) == null) {
					subStringFrequencyMap.put(newString, 1);
				} else {
					int currentFrequency = subStringFrequencyMap.get(newString);
					subStringFrequencyMap.put(newString, currentFrequency + 1);

				}
			}
		}
		return subStringFrequencyMap;

	}
}
