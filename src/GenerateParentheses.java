
public class GenerateParentheses {

	public static void main(String[] args) {
		String s = "(*)*";
		generateParentheses(s);
	}

	private static void generateParentheses(String s) {
		generateParentheses(s,"");
	}

	private static void generateParentheses(String s, String expression) {
		
		if(s.isEmpty()) {
			System.out.println(expression);
			return;
		}
		
			if(s.charAt(0) == '*') {
				generateParentheses(s.substring(1),expression+"(");
				generateParentheses(s.substring(1),expression+")");
				generateParentheses(s.substring(1),expression);
			}
			else {
				generateParentheses(s.substring(1),expression+s.charAt(0));
			}
			
			
		
	}
}
