import java.util.ArrayList;
import java.util.List;

public class PthFactor {

	public static void main(String args[]) {
		long factor = pthFactor(1,1) ;
		System.out.println(factor) ;
	}
	
	
	public static long pthFactor(long n, long p) {
	    // Write your code here
		long factor=0;
		
		List<Long> factorsList = new ArrayList<Long>();
		int factorCount = 0;
		for(long i=1; i<=n ; i++) {
			if(n%i == 0) {
				factorsList.add(i) ;
				factorCount++;
				if(p<=factorCount) {
					factor = factorsList.get((int) (p-1)) ;
					return factor ;
				}
					
				
			}
		}
		
		factorsList.add(n) ;
		int size = factorsList.size() ;
		if(p>size)
			return 0 ;
		return factor;
		
	    }
}
