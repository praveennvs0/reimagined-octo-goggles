import java.util.List;

public class Outfits {

	public static void main(String args[]) {
		
	}
	
	public static int getMaximumOutfits(List<Integer> outfits, int money) {
	    // Write your code here
		int max = 0,price = 0,length=0;
		for(int i=0;i<outfits.size() ;i++) {
			price = 0;
			length=0;
			for(int j= i; j<outfits.size() ; j++) {
				if(price + outfits.get(j) <= money) {
					price = price + outfits.get(j) ;
					length++;
				}
				else
					break ;
				
			}
			
			max=Math.max(max, length);
 			
		}
		
		
		return max ;
	    }
}
