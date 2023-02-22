import java.util.Arrays;
import java.util.List;

public class KeysAndRooms {
	
	public static void main(String[] args) {
		List<List<Integer>> roomsList = Arrays.asList(
                Arrays.asList(1,3),
                Arrays.asList(3,0,1),
                Arrays.asList(2),
                Arrays.asList(0)
              );
		
		boolean canVisit = canVisitAllRooms(roomsList);
		System.out.println(canVisit);
	}
	
	    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
	       boolean x = DFS(rooms,0);
	       return x;
	       
	    }
	    
	    private static boolean DFS(List<List<Integer>> rooms,int source) {
	        boolean[] visited = new boolean[rooms.size()];
	        DFS_Visit(rooms,visited,source);
	        return rooms.size() == visited.length;
	    }
	    
	    private static void DFS_Visit(List<List<Integer>> rooms,boolean[] visited,int vertex) {
	        visited[vertex] = true;
	        List<Integer> adjList = rooms.get(vertex);
	        for(Integer adjVertex : adjList) {
	            if(!visited[adjVertex]) {
	            DFS_Visit(rooms,visited,adjVertex);
	            }
	        }
	}

}
