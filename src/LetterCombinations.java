import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LetterCombinations {
	static Set<String> result = new HashSet<>();
	public static void main(String[] args) {
		Map<Character,List<Character>> map = buildMap();
		String digits = "";
		letterCombinations(digits,0,map,new StringBuilder());
		
		 List<String> resultList = new  ArrayList<String>(result);
		 List<String> result2 = Collections.<String>emptyList();
		 System.out.println("Combinations found"); 
		 
	}
	
	private static Map<Character,List<Character>> buildMap() {
		Map<Character,List<Character>> map = new HashMap<>();
		map.put('1',Collections.<Character>emptyList());
		map.put('2',Arrays.asList('a','b','c'));
		map.put('3',Arrays.asList('d','e','f'));
		map.put('4',Arrays.asList('g','h','i'));
		map.put('5',Arrays.asList('j','k','l'));
		map.put('6',Arrays.asList('m','n','o'));
		map.put('7',Arrays.asList('p','q','r','s'));
		map.put('8',Arrays.asList('t','u','v'));
		map.put('9',Arrays.asList('w','x','y','z'));
		return map;
		
	}
	  private  static void letterCombinations(String digits, int index,Map<Character, List<Character>> map, StringBuilder sb) {
		  
		  if(digits == "" || digits == null) {
	            System.out.println("empty");
	        }
		  
		  if(sb.length() == digits.length()) {
			  System.out.println(sb.toString());
			  result.add(sb.toString());
			  return;
		  }
		  
	        for(int i=index; i < digits.length(); i++) {

	  		  char ch = digits.charAt(index);
	  		  List<Character> list = map.get(ch);
	  		
	  		  for(int j=0;j<list.size() ; j++) {
	  			  sb.append(list.get(j));
	  			  letterCombinations(digits,index+1,map,sb);
	  			  if(sb.length() > 0) {
	  				 sb.deleteCharAt(sb.length() - 1);
	  			  }
	  		  }
	        	
	        }
	    }

}
