package DataStructures;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class DPWorld {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			int[] answers = {1,1,2};
			int x = numRabbits(answers) ;
	}

	private static int numRabbits(int[] answers) {
		int count = 0;
		Arrays.sort(answers) ;
		Map<Integer,List<Integer>> listMap = new TreeMap<>();
		Map<Integer,Integer> componentMap = new HashMap<>();
		for(int i=0;i<answers.length ;i++) {
			int curr = answers[i];
			if(componentMap.get(curr) == null) { // new rabbit
				// check for all colors
				for(Entry<Integer,List<Integer>> entry : listMap.entrySet()) {
					int color = entry.getKey();
					List<Integer> list = entry.getValue();
					if(list.size() == 0) {
						
					}
				}
			}
			
		}
		
		
		return count;
	}

}
