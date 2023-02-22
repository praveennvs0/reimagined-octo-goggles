package DataStructures;

public class MinCost {
	
	public static void main(String[] args) {
		int[] days = {1,4,6,7,8,20};
		int[] costs = {2,7,15};
		int minCost = mincostTickets(days,costs);
		System.out.println("min cost is : " + minCost);
		
	}
	
	    public static int mincostTickets(int[] days, int[] costs) {
	        return helper(days, costs, 0);
	    }
	    
	    private static int helper(int[] days, int[] costs, int day) {
	        if(day >= days.length)
	            return 0;
	        
	        int ondDayPass = helper(days, costs, day + 1) + costs[0]; // for 1 day pass
	        
	        int i;
	        for(i = day; i < days.length; i++)
	            if(days[i] >= days[day] + 7)
	                break;
	        
	        int sevenDayPass = helper(days, costs, i) + costs[1]; // for 7 day pass
	        
	        for(i = day; i < days.length; i++)
	            if(days[i] >= days[day] + 30)
	                break;
	        
	        int thirtyDayPass = helper(days, costs, i) + costs[2]; // for 30 day pass 
	        
	        return Math.min(ondDayPass, Math.min(sevenDayPass, thirtyDayPass));
	    }
	}
	 


