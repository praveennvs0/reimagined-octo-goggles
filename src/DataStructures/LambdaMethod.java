package DataStructures;

import java.util.ArrayList;
import java.util.List;

public class LambdaMethod {
	
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		
		list.add("one");
		list.add("two");
		
		method(list);
		
		
		
	}

	private static  void method(List<String> list) {
		list.forEach(LambdaMethod:: send);
		
	}

	private static void send(String x) {
		switch(x) {
		case "one": {
			System.out.println("one");
			break;
		}
		case "two": {
			System.out.println("two");
			break;
		}
		
		case "three": {
			System.out.println("three");
			break;
		}
			
			
		}
	}

}
