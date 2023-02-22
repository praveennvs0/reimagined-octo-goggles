import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class SortedFactors {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
          int n = 100;
           int k = 3 ;
          List<Integer> factors = new ArrayList<>();
		  Vector<Integer> v = new Vector<>();
	        for (int i = 1; i <= Math.sqrt(n); i++) {
	            if (n % i == 0) {
	 
	                // check if divisors are equal
	                if (n / i == i) {
	                	k--;
	                    System.out.println( i);
	                    if(k==0) {
	                    	System.out.println("k th divisor is : " + i);
	                    	break;
	                    }
	                    factors.add(i);
	                }
	                else {
	                	k--;
	                	factors.add(i);
	                	if(k==0) {
	                    	System.out.println("k th divisor is : " + i);
	                    	break;
	                    }
	                    System.out.println( i);
	 
	                    // push the second divisor in the vector
	                    v.add(n / i);
	                }
	            }
	}
	        for (int i = v.size() - 1; i >= 0; i--) {
	        	k--;
	        	if(k==0) {
                	System.out.println("k th divisor is : " + v.get(i));
                	break;
                }
	        	factors.add(v.get(i));
	            System.out.println( v.get(i));
	        }

	        System.out.println("helloworld");
}
}
