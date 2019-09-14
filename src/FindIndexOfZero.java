
public class FindIndexOfZero {

	public static void main(String args[]) {
		
		int[] a= {1, 0,1,0,1,1} ;
		int index = findIndex(a) ;
		System.out.println("Index is : " + index) ;
		
	}

	private static int findIndex(int[] a) {
		int index = -1 ;
		
		int i=0,maxLen = Integer.MIN_VALUE ;
		while(i<a.length-1) {
			int currentLen = 0;
			int j= i ;
			if(a[i] == 1) {
			while(j<a.length-1) {
				if(a[j+1]==0) 
					break;
				
				currentLen++;
				
				j++ ;
			}
			
			i=j+1;
			if(currentLen > maxLen) {
				index = j+1;
				maxLen = currentLen ;
			}
			}
			
			else if(a[i]==0){
				int k=i ;
				while(k<a.length-1) {
					if(a[k+1] == 0)
						break;
					
					currentLen++ ;
					k++;
				}
				
				i=k+1;
				if(currentLen > maxLen) {
					index=k+1;
					maxLen = currentLen ;
				}
			}
		}
		
		
		return index;
	}
}
