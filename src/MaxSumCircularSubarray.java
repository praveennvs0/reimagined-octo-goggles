
public class MaxSumCircularSubarray {

	public static void main(String[] args) {
		
		int a[] = {1,-2,3,-2};
		int[] b = copyArray(a);
		System.out.println(b);
		
	}
	
	  public static int[] copyArray(int[] a){
	        int length = 2 * a.length - 1 ;
	        int[] b = new int[length];
	        for(int i=0 ; i< a.length ; i++) {
	            b[i] = a[i];
	        }
	        for(int i=0,j=a.length ; i < a.length - 1 ; i++,j++) {
	            b[j]=a[i];
	        }
	        return b;
	    }
}
