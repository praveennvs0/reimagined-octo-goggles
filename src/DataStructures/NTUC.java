package DataStructures;

public class NTUC {
	public static void main(String args[]) {
		int M = 3;
//		int A[] = new int[7];
//		A[0] = 1;
//		A[1] = 2;
//		A[2] = 3;
//		A[3] = 3;
//		A[4] = 1;
//		A[5] = 3;
//		A[6] = 1;
		
		int A[] = new int[4];
		A[0]=1;
		A[1]=2;
		A[2]=1;
		A[3]=3;
		int x = solution(4, A);
		System.out.println("most often occuring is : " + x);
	}

	static int solution(int M, int[] A) {
		int N = A.length;
		int[] count = new int[M + 1];
		for (int i = 0; i <= M; i++)
			count[i] = 0;
		int maxOccurence = 1;
		int index = 0;
		for (int i = 0; i < N; i++) {
			if (count[A[i]] > 0) {
				int tmp = count[A[i]]+1;
				if (tmp > maxOccurence) {
					maxOccurence = tmp;
					index = i;
				}
				count[A[i]] = tmp;
			} else {
				count[A[i]] = 1;
			}
		}
		return A[index];
	}
}