
public class QuickSelect {

	public static void main(String args[]) {
		int[] a= {3,2,1,5,6,4};
		int k= 2;
		System.out.println("Given array :" );
		display(a) ;
		int x = quickSelect(a,k) ;
		System.out.println("");
		System.out.println("The element is : " + x) ;
		System.out.println("Array after performing quick select :" ) ;
		display(a);
	}

	private static void display(int[] a) {
		System.out.println("");
		for(int i=0; i < a.length ; i++) {
			System.out.print(a[i]+",");
		}
	}

	private static int quickSelect(int[] a,int k) {
		int x = quickSelect(a,0,a.length-1,k-1) ;
		return a[x];
	}

	private static int quickSelect(int[] a, int p, int r, int k) {
		int q;
		if(p<r) {
			q=partition(a,p,r);
			if(q==k)
				return q;
			else if(k>q) {
				int right = quickSelect(a,q+1,r,k);
				return right ;
			}
			else {
				int left = quickSelect(a,p,q-1,k);
				return left ;
			}
			
		}
		return p;
	}

	private static int partition(int[] a, int p, int r) {
		int pivot = a[r] ;
		int partitionIndex=0;
		for(int j=0;j<=r-1;j++) {
			if(a[j] >= pivot) {
				
				int temp = a[partitionIndex];
				a[partitionIndex]=a[j];
				a[j]=temp;
				
				partitionIndex=partitionIndex+1;
			}
		}
		
		int temp = a[partitionIndex] ;
		a[partitionIndex]=pivot ;
		a[r] = temp ;
		
		return partitionIndex;
	}
}
