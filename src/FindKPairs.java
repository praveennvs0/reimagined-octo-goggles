import java.util.ArrayList;
import java.util.List;

public class FindKPairs {
	private static List<List<Integer>> result = new ArrayList<>();
	public static void main(String[] args) {
		int[] num1 = {1,7,11} ;
		int[] num2 = {2,4,6};
		
		findKPairs(num1,num2,0,0) ;
	}

	private static void findKPairs(int[] num1, int[] num2,int i,int j) {
		
		while(i < num1.length && j < num2.length) {
		
		
		
		   int sumLeft = num1[i+1] + num2[j] ;
		   int sumRight = num1[i] + num2[j+1] ;
		   
		   if(sumLeft<=sumRight) {
			   List<Integer> list1 = new ArrayList<>();
				list1.add(num1[i+1]) ;
				list1.add(num2[j]);
				result.add(list1);
				j++;
		
		
		}
		   else {
			   List<Integer> list2 = new ArrayList<>();
				list2.add(num1[i+1]) ;
				list2.add(num2[j]);
				result.add(list2);
		   }
		
			}

}
}
