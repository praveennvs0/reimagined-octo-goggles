import java.util.Map.Entry;

public class Leetcode1513 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       String s = "111111";
       int x = numSub(s);
       System.out.println("number is : " + x);
	}
	
	 public static int numSub(String s) {
		 Entry<Integer,Integer> e ;
		 
	        int num=0, len = s.length();
	        int left = 0, right = 0 ;
	        
	        while(left <= right && left <= len-1  && right <= len-1 ) {
	            if(s.charAt(right) == '1') {
	                right++;
	            }
	            else {
	                int n = right-left;
	                num += (n * (n+1)) / 2 ; 
	                
	                left = right + 1 ;
	                right = left;
	                
	            }
	        }
	        
	        if(s.charAt(len-1) == '1') {
	        	int n = right - left  ;
	        	num += (n * (n+1)) / 2 ; 
	        }
	        
	        return num;
	    }

}
