import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Collectors;

public class WatchVideos {
	
	public static void main(String[] args) {
		
		List<String> list1 = Arrays.asList("A","B");
		List<String> list2 = Arrays.asList("C");
		List<String> list3 = Arrays.asList("B","C");
		List<String> list4 = Arrays.asList("D");
		
		Map<Integer,Integer> sm = new HashMap<>();
		int i = 0; String s ="hello";
		sm.put(s.charAt(i),1 + sm.getOrDefault(s.charAt(i),0));
		
		List<List<String>> mainList = new ArrayList<>();
		mainList.add(list1);
		mainList.add(list2);
		mainList.add(list3);
		mainList.add(list4);
		
	  int[][] friends = {{1,2},{0,3},{0,3},{1,2}};
	  List<String> result = watchedVideosByFriends(mainList,friends,0,2);
	  System.out.println("hello world");
	}
	
	 public static List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
	        Queue<Integer> queue = new LinkedList<>() ;
	        queue.add(id);
	        int currLevel = 0;
	        boolean visited[] = new boolean[friends.length];
	        visited[id] = true;
	        List<Integer> result = new ArrayList<>();
	        while(!queue.isEmpty()) {
	            int size = queue.size();
	            if(currLevel == level-1) {
	                for(int i=0;i<size;i++) {
	                    result.add(queue.poll());
	                    
	                }
	                break;
	            }
	            
	            
	            //Dequeuing the current level
	            for(int i=0;i<size;i++) {
	                int currVertex = queue.poll();
	                int[] adjacent = friends[currVertex];
	                //Pushing all the adjacent vertices - unvisited
	                for(int j=0;j<adjacent.length;j++) {
	                    if(!visited[adjacent[j]]) {
	                    	visited[adjacent[j]] = true;
	                        queue.offer(adjacent[j]);
	                }
	                }
	                
	            }
	            
	            
	            currLevel++;
	        }
	        
	        
	        
	        List<String> videos = new ArrayList<>() ;
	        for(Integer friend : result) {
	        	List<String> individualList = watchedVideos.get(friend);
	        	videos.addAll(individualList);
	        }
	        Map<String,Integer> freq = new HashMap<>();
	        for(String video: videos) {
	        	freq.put(video,freq.getOrDefault(video,0)+1);
	        }
	        
	        Map<String, Integer> sortedByFrequency = freq.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue()) .collect(Collectors.toMap(e -> e.getKey(),e -> e.getValue()));

	        List<String> sortedList = new ArrayList<>();
	        sortedList.addAll(sortedByFrequency.keySet());
	        return sortedList;

}
}
