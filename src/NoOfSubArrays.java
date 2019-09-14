
public class NoOfSubArrays {

	public static void main(String args[]) {
		int[] a= {2, 0, 11, 3, 0} ;
		int L=1;
		int R = 10 ;
		int x = noOfSubArrays(a,L,R) ;
		System.out.println("No.of subarrays is : " + x) ;
		
	}
	
	
	public static int noOfSubArrays(int[] a,int L,int R) {
		int noOfSubArrays = 0,start=0,end=0;
		
		
		while(start<= end && end < a.length) {
			if(start==end && a[start] >R) {
				start++;
				end++;
				continue;
			}
				
			
			int count = 0;
			int temp = -1 ;
			while(end < a.length && a[end] <= R ) {
				temp++;
				if(a[end] >= L) {
					count++;
				}
				
				end++;	
			}
			if(count > 0)
			noOfSubArrays=noOfSubArrays+temp ;
			
			int start1=start ;
			int noOfContractingWindows = 0;
			while(start1 >=0 && start1 < end) {
				if(a[start1] >= L && a[start1] <=R)  {
					noOfSubArrays++;
					count--;
				}
				if(count<=0)
					break;
				else 
					noOfContractingWindows++;
				
				start1++;
					
					
			}
			
			noOfSubArrays = noOfSubArrays + noOfContractingWindows;
			start = end ;
		}
		
		
		
		return noOfSubArrays ;
		
	}
}
