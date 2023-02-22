package newPackage;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class SortCharactersByFrequency {
	
	

	public static void main(String[] args) {
		String s = "treegfftkkkk";
		String result = frequencySort(s);
		System.out.println(result);
		
	}
	
	
	  public static String frequencySort(String s) {
	        String result = "";
	        Map<Character,Integer> map = new HashMap<>();
	        for(char c : s.toCharArray()) {
	        	map.put(c, map.getOrDefault(c, 0)+ 1);
	        }
	        List<Entry<Character,Integer>> list = new ArrayList<>(map.entrySet());
	        list.sort(Entry.comparingByValue());
	        for(int i=list.size()-1;i>=0;i--) {
	        	Entry<Character,Integer> entry = list.get(i);
	        	char ch = entry.getKey();
	        	int freq = entry.getValue();
	        	for(int k=0;k<freq;k++) {
	        		result += ch;
	        	}
	        }
	        
	        return result;
	    }
}
