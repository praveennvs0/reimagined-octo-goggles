import java.util.Stack;

public class DecodeString {

	public static void main(String[] args) {
		
		
		String s = "3[a]2[bc]";
		String decoded = decodedString(s);

	}

	private static String decodedString(String s) {
		String output = "";
		Stack<String> stack = new Stack<String>();
		for(int i=0;i<s.length();i++) {
			char ch = s.charAt(i);
			if(Character.isDigit(ch)) {
				stack.push(Character.toString(ch));
			}
			else if(ch == '[') {
				stack.push(Character.toString(ch));
			}
			else if(ch == ']') {
				String temp = "";
				String s1 = stack.pop();
				while(s1 != "[") {
					temp = s1 + temp;
					s1 = stack.pop();
				}
			}
		}
		
		return output;
	}

}
