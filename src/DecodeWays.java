import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DecodeWays {
	private static int count;
	static Map<Integer,String> map = new HashMap<>();
	static Set<String> set = new HashSet<>();
	static Map<String,Integer> cache = new HashMap<>();
	static {
		char ch = 'A';
		for(int i=1;i<=26;i++) {
		  map.put(i,Character.toString(ch));
		  set.add(Integer.toString(i));
		  ch++;
		}
	}
	
	public static void main(String[] args) {
		String s = "226";
		int x = numDecodings(s,"");
		
		System.out.println("no.of ways is : " + x);
	}
	
	
	public static int numDecodings(String s) {
		return numDecodings(s,"");
	}
	
	   public static int numDecodings(String s,String decoded) {
		   int x = 0;
		   if(cache.get(s) != null) {
			   return cache.get(s);
		   }
		   if(s== null || s.isEmpty()) {
			   count++;
			   System.out.println(decoded);
			   return 1;
		   }
		   
		   for(int i=0; i < s.length(); i++) {
			   String num = s.substring(0, i+1);
			if(set.contains(num)) {
				   String key = map.get(Integer.parseInt(num));
				   x = x+numDecodings(s.substring(i+1),decoded+key);
				   
			   }
			cache.put(s,x);
			System.out.println("substring is " + s);
		   }
		   
		   
		   return x;
		   
	    }
}
