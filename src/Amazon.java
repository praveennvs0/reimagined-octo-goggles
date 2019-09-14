import java.util.ArrayList;
import java.util.Arrays;

public class Amazon {
public static void main(String args[]) {
	
	
	ArrayList<Integer> packagesSpace = new ArrayList<Integer>( 
            Arrays.asList(100,180,40,120,10,200,30));
	ArrayList<Integer> sol = IDsOfPackages(250,packagesSpace);
	System.out.println("hello world") ;
	
}

 
	// METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
	public static ArrayList<Integer> IDsOfPackages(int truckSpace, 
	                                 ArrayList<Integer> packagesSpace)
	{
		// WRITE YOUR CODE HERE
		ArrayList<Integer> solution = new ArrayList<Integer>() ;
		int largestPackage=Integer.MIN_VALUE;
		int targetSum = truckSpace - 30 ;
		int first=0,second=0;
		for(int i=0;i<packagesSpace.size() ; i++) {
			int firstElement = packagesSpace.get(i) ;
			for(int j=i+1;j<packagesSpace.size();j++) {
				int secondElement = packagesSpace.get(j) ;
				if(firstElement + secondElement == targetSum) {
					int currMax = Math.max(firstElement, secondElement) ; 
					if(currMax>=largestPackage) {
					first = i;
					second =j;
					largestPackage = currMax ;
					}
				}
					
			}
		}
		
		solution.add(first) ;
		solution.add(second) ;
		return solution ;
		
	}
	// METHOD SIGNATURE ENDS

}
