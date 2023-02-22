package DataStructures;
import java.util.Stack;


public class RemovingStarsFromAString {

	public RemovingStarsFromAString() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		
		String s = "erase*****";
		String t = removeStars(s);
		System.out.println("String is : " + t);
	}

	private static String removeStars(String s) {
		Stack<Character> stack = new Stack<Character> ();
		int index = 0;
		
		String res = "";
		while(index < s.length()) {
			char ch = s.charAt(index);
			if(ch == '*') {
				stack.pop();
			}
			else {
				stack.push(ch);
			}
			index++;
		}
		
		
		while(!stack.isEmpty()) {
			res += stack.pop(); 
		}
		
		StringBuilder sb=new StringBuilder(res);  
	    sb.reverse();  
	    
		return sb.toString();
	}

}
