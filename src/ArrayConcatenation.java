
public class ArrayConcatenation {

	public static void main(String[] args) {
		int arr[] = {15,88},pieces[][] = {{88},{15}};
		boolean canForm = canFormArray(arr,pieces);
		System.out.println("can form array : " + canForm);
	}
	
	 public static boolean canFormArray(int[] arr, int[][] pieces) {
	        StringBuilder sb = new StringBuilder();
	        for(int x : arr){
				sb.append("#");
	            sb.append(x);
	            sb.append("#");
	        }
	        for(int i = 0; i < pieces.length; i++){
	            StringBuilder res = new StringBuilder();
	            for(int j = 0; j < pieces[i].length; j++){
					res.append("#");
	                res.append(pieces[i][j]);
	                res.append("#");
	            }
	            if(!sb.toString().contains(res.toString())){
	                return false;
	            }
	        }
	        return true;
	 }
}
