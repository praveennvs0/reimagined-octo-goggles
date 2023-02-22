
public class Interview1 {

public static void main(String[] args) {
String s = "geeksforgeeks" ;
String substr = "geeks";

int count = findOccurrences(s,substr) ;
System.out.println(count);
}

private static int findOccurrences(String s, String substr) {
  int count = 0,j=0;
  int target = substr.length();
	for(int i=0; i < s.length()-target+1 ;) {
		char ch = s.charAt(i);
		 String curr = s.substring(i, i+target);
		 if(curr.equals(substr)) {
			 count++;
			 i = i + target;
		 }
		 i++;
		 
		
		
		
	}
	
	
	
	return count;
}


}
