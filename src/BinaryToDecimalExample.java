
public class BinaryToDecimalExample {
	public static void main(String args[]){  
		String binaryString="011100";  
		int decimal=Integer.parseInt(binaryString,2);  
		
		System.out.println(decimal);  
		int x = solution(binaryString) ;
		System.out.println( x) ;
		}
	
	
	
	 public static int solution(String s) {
		 int number=Integer.parseInt(s,2);  
		 int count = 0;
		 
		 while(number > 0) {
			 
			 if(number % 2 == 0) 
				 number = number/2;
			 else
				 number=number-1;
			 
			 count++;
		 }
		 
		return count;
	        // write your code in Java SE 8
	    }
	 
	 
	 
}
