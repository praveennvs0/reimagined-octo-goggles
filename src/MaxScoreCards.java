import java.util.HashMap;
import java.util.Map;

public class MaxScoreCards {
	public static void main(String[] args) {
		int[] cardPoints = {9,7,7,9,7,7,9};
								
		int maxScore = maxScore(cardPoints,7);
		System.out.println("Max score is : " + maxScore);
	}
	
	public static int maxScore(int[] cardPoints, int k) {
		  int[][] cache = new int[cardPoints.length][cardPoints.length];
          int maxScore = maxScore(cardPoints,k,0,cardPoints.length-1,0,cache);  
          return maxScore;
    }
	
	

	
	private static int maxScore(int[] cardPoints, int k, int left, int right, int currScore, int[][] cache) {
		
		System.out.println(k + "," + left + "," + right + "," + currScore);
		
		if(k==0) {
			return currScore;
		}
		
		if(cache[left][right] != 0) {
			return cache[left][right];
		}
		
		
		int leftScore = maxScore(cardPoints, k-1,left+1,right,currScore+cardPoints[left],cache);
		int rightScore = maxScore(cardPoints, k-1,left,right-1,currScore+cardPoints[right],cache);
		int max = Math.max(leftScore, rightScore);
		cache[left][right] = max;
		
		return max;
		
		
	}

}
