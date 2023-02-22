
public class Exceptionchecker {
	
	public static void main(String[] args) throws Exception {
		func();
	}

	private static void func() throws Exception {
		String forexString = "12345567";
		int index = forexString.indexOf(".");
		
		String precision = forexString.substring(0,index);
		String scale = forexString.substring(index+1);
		System.out.println("precision is : " + precision);
		System.out.println("scale is : " + scale);
				
		
	}

}
