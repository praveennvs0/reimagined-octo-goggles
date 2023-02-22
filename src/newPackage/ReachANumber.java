package newPackage;

public class ReachANumber {
	private static Integer min = Integer.MAX_VALUE ;
	public static void main(String args[]) {
		int target = -1000000000;
		int num = reachNumber(target);
		System.out.println("min number of steps needed is : " + num);
		
	}
    public static int reachNumber(int target) {
        
       int min = reachNumber(0,target,1,0,0,Integer.MAX_VALUE);
        return min ;
    }
    
    public static int reachNumber(int curr,int target,int n,int stepLeft,int stepRight,int min) {    
        if(curr == target)
            return stepLeft+stepRight;
    if(Math.abs(curr-n) <= Math.abs(target)) { 
     int left = reachNumber(curr-n,target,n+1,stepLeft+1,stepRight,min) ;
     if(left < min)
    	 min = left;
    }
    if(Math.abs(curr+n) <= Math.abs(target)) { 
     int right = reachNumber(curr+n,target,n+1,stepLeft,stepRight+1,min) ;
     if(right < min)
    	 min = right;
    }
    
    return min;
              
    }
}