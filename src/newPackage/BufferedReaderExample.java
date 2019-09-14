package newPackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BufferedReaderExample {

	public static void main(String args[]) throws IOException {
		
		Scanner scanner = new Scanner(System.in) ;
		System.out.println("Enter a number ") ;
		String x = scanner.nextLine();
		System.out.println(x) ;
		
		    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));            
		    System.out.println("Enter your name");    
		    String name=br.readLine();    
		    System.out.println("Welcome "+name);    
		
		
	}
}
