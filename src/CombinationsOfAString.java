
public class CombinationsOfAString {

	
	public static void main(String args[]) {
		
		
		String s = "guuuun" ;
		String t= "rabbit";
		String combination = "" ;
		int number = numDistinct(s,t) ;
		System.out.println("no. of distinct subsequences is :" + number) ;
	}
	
	

public static int numDistinct(String s, String t) {
        
	 combination(s,"",t) ;
	return 5 ;
    }


public static void combination(String s,String combination,String t) {

System.out.println(combination) ;

for(int i=0; i < s.length() ; i++) {
combination+=s.charAt(i) ;
combination(s.substring(i+1,s.length()),combination,t);
combination = combination.replace(combination.substring(combination.length()-1),"");


}

}
}
