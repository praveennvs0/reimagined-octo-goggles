import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PowerfulIntegers {
	
	public static void main(String[] args) {
		int x = 2,y = 1, bound = 10;
		powerfulIntegers(x,y,bound);
		
	}
	
	 public static List<Integer> powerfulIntegers(int x, int y, int bound) {
		 List<Integer> resultList = new ArrayList<>() ;
		 	if(x==1 && y ==1) {
		 		if(2 <= bound) {
		 			resultList.add(2);
		 		}
		 			
		 	}
		 	else if (x==1) {
		 		int num=0,i=0;
		 		resultList = new ArrayList<>() ;
		 		while(num <= bound) {
		 			num = (int) (1 + Math.pow(y, i));
		 			if(num <= bound) {
		 			resultList.add(num);
		 			}
		 			i++;
		 		}
		 		
		 	}
		 	else if (y == 1) {
		 		int num=0,i=0;
		 		resultList = new ArrayList<>() ;
		 		while(num <= bound) {
		 			num = (int) (1 + Math.pow(x, i));
		 			if(num <= bound) {
		 			resultList.add(num);
		 			}
		 			i++;
		 		}
		 		
		 		
		 	}
		 	
		 	else {
		 
	        Set<Integer> resultSet = new HashSet<>();
			powerfulIntegers(x,y,bound,resultSet,0, 0);
			resultList = new ArrayList<>(resultSet);
		 	}
	        
		 	return resultList ;
	    }

	private static void powerfulIntegers(int x, int y, int bound, Set<Integer> resultSet, int currX,int currY) {
		Integer num = (int) (Math.pow(x, currX) + Math.pow(y, currY));
		if(num <= bound)  {
			if(!resultSet.contains(num)){
				System.out.println(num);
			resultSet.add(num);
			}
		}
		
		if(num>bound)
			return ;
		
		powerfulIntegers(x,y,bound,resultSet,currX+1,currY);
		powerfulIntegers(x,y,bound,resultSet,currX,currY+1);
	}

}
