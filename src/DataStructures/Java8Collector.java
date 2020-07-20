package DataStructures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Java8Collector {

	public static void main(String[] args) {
//		List<Integer> list = Arrays.asList(1,2,3,4,5,6,7);
//		String joinedList = list.stream().map(String::valueOf).collect(Collectors.joining(","));
//		System.out.println(joinedList);
//		

		String data = "1,2,3,4,5,6";
        List<String> stringList = Arrays.asList(data.split(","));
        List<Integer> preOrderList = new ArrayList<>();
        stringList.forEach(x->preOrderList.add(Integer.parseInt(x)));
        
        System.out.println(stringList);
	}
}
