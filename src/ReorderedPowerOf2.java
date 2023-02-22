
public class ReorderedPowerOf2 {
	
	static boolean isPowerOf2 = false;
	
	public static void main(String[] args) {
		int N = 1;
		boolean reOrdered = reorderedPowerOf2(N);
		System.out.println(reOrdered);
		
	}
	
	 public static boolean reorderedPowerOf2(int N) {
		 String str = String.valueOf(N);
	     checkPermutations(str);
		 
		 return isPowerOf2;
	    }

	private static void checkPermutations(String str) {
		
		checkPermutations(str,"",str.length());
		
		return ;
	}

	private static void checkPermutations(String str, String permutation,int length) {

		if(permutation.length() == length) {
			isPowerOf2 = checkIfPowerOfTwo(permutation);
			return;
		}
		
		for(int i=0; i < str.length() ; i++) {
			if(!isPowerOf2) {
			char ch = str.charAt(i);
			checkPermutations(str.substring(0,i)+str.substring(i+1),permutation+ch,length);
			}
		}
		
		
		
	}

	private static boolean checkIfPowerOfTwo(String permutation) {
		if(permutation.charAt(0) == '0')
			return false; //numbers with leading zeroes are not considered
		int n = Integer.parseInt(permutation);
		 if (n == 0)
	            return false;
	         
	        while (n != 1)
	        {
	            if (n % 2 != 0)
	                return false;
	            n = n / 2;
	        }
	        return true;
	}

}
