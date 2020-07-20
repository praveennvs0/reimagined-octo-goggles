
public class HIndex {
	public static void main(String[] args) {
		int[] citations = {0,1,3,5,6} ;
		int hIndex = hIndex(citations,0,citations.length-1);
		System.out.println("hindex is : " + hIndex) ;
	}

	private static int hIndex(int[] citations,int startIndex,int endIndex) {
		int mid = (endIndex - startIndex)/2;
		
	   if(citations[citations.length-mid-1] >= mid) {
			return hIndex(citations,mid+1,endIndex);
		}
		
		
		
		else {
			return hIndex(citations,startIndex,mid);
		}
		
	}

	private static boolean noMoreThanCitations(int[] citations, int index) {
		if(citations[index-1] <= index)
			return true;
		return false;
	}

	private static boolean atleastCitations(int[] citations, int index) {
		int length = citations.length ;
		if(length-index-1 >=0 && index >= 1 && citations[length-index] >= index && citations[length-index-1] < index) 
			return true;

		return false;
	}

}
