package newPackage;

public class SubarrayWithBoundedMaximum {
	
	public static void main(String[] args) {
		int[] A = {2,1,0,4,3};
		int count = numSubarrayBoundedMax(A,2,3);
		System.out.println("count is : " + count);
	}
	
	public static int numSubarrayBoundedMax(int[] A, int L, int R) {
        int start = -1, last = -1, res = 0;
        for(int i = 0; i < A.length; i++) {
            if(A[i] > R) {
                start = last = i;
                continue;
            }
            
            if(A[i] >= L)
                last = i;

            res += last - start;
        }
        
        return res;
    }

}
