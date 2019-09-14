package newPackage;

public class Constructor {
static String str ; 
public  Constructor() {
	System.out.println("In constructor") ;
	str = "Hello World" ;
}

public static void main(String args[]) {
	int a = 3 , b =5 ;
	a=a&b; b =a|b;a=a|b;
	
	System.out.println(a) ;
	System.out.println(b);
}

}
