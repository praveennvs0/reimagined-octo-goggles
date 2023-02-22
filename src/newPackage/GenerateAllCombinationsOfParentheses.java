package newPackage;

public class GenerateAllCombinationsOfParentheses {
	public static void main(String[] args) {
	String[] str = {"(",")"};
	generateParentheses(str,4,"");
	
	}

	private static void generateParentheses(String[] str,int n,String combination) {
		if(combination.length() == n ) { 
		System.out.println(combination);
		return ;
		}
		System.out.println();
		for(int i=0; i < str.length; i++) {
			//combination = combination + str[i];
			generateParentheses(str,n,combination+str[i]);
		}
		
	}

}
