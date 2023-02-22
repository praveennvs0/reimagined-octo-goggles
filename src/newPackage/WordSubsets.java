package newPackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordSubsets {
	
	public static void main(String[] args) {
		
		String[] words1 = {"amazon","apple","facebook","google","leetcode"};
		String[] words2 = {"e","o"} ;
		
		List<String> result = wordSubsets(words1,words2);
		System.out.println("hello world");
	}
	
	 
    public static List<String> wordSubsets(String[] words1, String[] words2) {
        
        Map<String,Map<Character,Integer>> freqMap = buildFreqMap(words2) ;
        List<String> result = new ArrayList<>();
        boolean matching ;
        for(int i=0;i<words1.length;i++) {
        	matching = true;
        	for(int j=0;j<words2.length;j++) {
               if(!checkOneWord(words1[i],words2[j],freqMap)) {
            	   matching = false;
               break;
               }
           }
        	if(matching) {
        	result.add(words1[i]);
        	}
        }
        return result;
    }
    
    private static Map<String, Map<Character, Integer>> buildFreqMap(String[] words2) {
    	Map<String,Map<Character,Integer>> result = new HashMap<>();
		for(String word : words2) {
			Map<Character,Integer> subsetMap = buildMapForWord(word);
			result.put(word,subsetMap);
		}
		return result;
	}


	private static Map<Character, Integer> buildMapForWord(String word) {
		Map<Character,Integer> map = new HashMap<>();
		for(int i=0;i<word.length();i++) {
			char ch = word.charAt(i) ;
			map.put(ch, map.getOrDefault(ch,0) + 1 );
		}
		return map;
	}


	private static boolean checkOneWord(String mainWord,String targetWord,Map<String,Map<Character,Integer>> freqMap) {
		Map<Character,Integer> mainWordFrequency = buildMapForWord(mainWord);
		Map<Character,Integer> targetWordFrequency = freqMap.get(targetWord);
		
		for(Character ch : targetWordFrequency.keySet()) {
			if(mainWordFrequency.get(ch) == null || targetWordFrequency.get(ch) > mainWordFrequency.get(ch)) {
				return false;
			}
		}
		
		return true ;
		
    	
    }

}
