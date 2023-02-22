package DataStructures;

import java.util.ArrayList;
import java.util.List;

public class AllPaths {

	public static void main(String[] args) {
		int[][] graph ={{1,3},{2},{3},{}};
		int n = graph.length ;
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> path = new ArrayList<>();
		path.add(0);
		allPathsSourceTarget(graph,result,path,0,n-1);
		System.out.println("result");
		
		
	}
	
	public static List<List<Integer>> allPathsSourceTarget(int[][] graph,List<List<Integer>> result, List<Integer> path, int curr, int goal) {
		if(curr == goal ) {
			System.out.println("path found");
			printList(path);
			result.add(new ArrayList<>(path));
		}
		int[] neighbours = graph[curr];
		for(int i=0;i<neighbours.length ; i++) {
			int v = neighbours[i];
			path.add(v);
			allPathsSourceTarget(graph,result,path,v,goal);
			path.remove(path.size()-1);
		}
		
		return result;
	}

	private static void printList(List<Integer> path) {
		path.forEach(x-> {System.out.print(x) ;
		System.out.print("->");});
	}
}
