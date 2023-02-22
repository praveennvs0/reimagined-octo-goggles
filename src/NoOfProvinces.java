
public class NoOfProvinces {
	
	public static void main(String[] args) {
		int[][]  isConnected = {{1,1,0},{1,1,0},{0,0,1}};
		int x = findCircleNum(isConnected);
		System.out.println("no. of provinces is : " + x);
		
		}

	 public static int findCircleNum(int[][] isConnected) {
	        int n = isConnected.length;
	        
	        boolean[] visited = new boolean[n];
	        int count = 0;
	        for(int i=0;i<n;i++) {
	            if(!visited[i])
	            	count++;
	                DFS_Visit(isConnected,visited,i,n);
	        }
	        
	        return count;
	    }
	    
	    public static void DFS_Visit(int[][] isConnected,boolean[] visited,int vertex,int n) {
	        
	        visited[vertex] = true;
	        
	        for(int i=0;i<n;i++) {
	            if( i != vertex && isConnected[vertex][i] == 1 && !visited[i]) {
	                DFS_Visit(isConnected,visited,i,n);
	            }
	        }
	    }
	    
}
