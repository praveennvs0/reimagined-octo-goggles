package newPackage;

import java.util.ArrayList;
import java.util.List;

public class PartitionString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "dbaa";
		partitionString(s);
	}

	private static void partitionString(String s) {
		List<String> result = new ArrayList<>();
		partitionString(s,result);
		
	}

	private static void partitionString(String s, List<String> result) {

		if(s.isEmpty()) {
			printList(result);
			
			return ;
		}
		
		for(int i=0;i<s.length();i++) { 
			String curr = s.substring(0,i+1);
			if(isPalindrome(curr)) {      
				result.add(curr);  
				partitionString(s.substring(i+1),result);  
				if(result.size() > 0)
				result.remove(result.size()-1);
			}
			
		}
	}
	
	private static void printList(List<String> result) {
		System.out.println("result");
		result.forEach(x->System.out.print(x));
		
	}

	private static boolean isPalindrome(String s) {
		int i = 0, j = s.length()-1;
		while(i <= j ) {
			if(s.charAt(i) != s.charAt(j))
				return false;
			i++;
			j--;
		}
		return true;
	}

}
