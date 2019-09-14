import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MapStream {

	
	public static void main(String args[]) {
		List<Integer> numbers = new ArrayList<Integer>();
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
		numbers.add(4);
		numbers.add(5);
		numbers.add(6);
		
		List<Integer> list2 = new ArrayList<Integer>();
		numbers.forEach(list2::add);
		List<Integer> newList = numbers.stream().map(n->{
			Integer x = n*3 ;
			return x;
		}).filter(n->n%2==0).collect(Collectors.toList()) ;
		
		newList.forEach(x->{System.out.print(x);
		System.out.print(",");}
		);
		
		
		List<Integer> thirdList = numbers.stream().map(n-> {
			Integer x = n* 5 ;
			return x ;
		}).collect(Collectors.toList()) ;
		System.out.println("hello");
	}
}

