public class CourseSchedule {
	public static void main(String[] args) {
		int numCourses = 2 ;
		int[][] prerequisites = {{1,0}};
		boolean canFinish = canFinish(numCourses,prerequisites) ;
		System.out.println(canFinish);
		
	}
	
	
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean isCyclic = isCyclic(prerequisites,numCourses);
        return !isCyclic;
    }
    
    private static boolean isCyclic(int[][] preerequisites,int numCourses) {
        
        boolean[] visited = new boolean[numCourses];
        boolean[] recStack = new boolean[numCourses];
        
        for(int i = 0; i< numCourses ; i++) {
            if(isCyclicUtil(numCourses,i,visited,recStack,preerequisites)) 
                return true;
        }
        return false;
    }
    
    private static boolean isCyclicUtil(int numCourses, int i,boolean[] visited,boolean[] recStack,
                                int[][] prerequisites) {
        if(recStack[i])
            return true;
        
        if(visited[i]) 
            return false;
        
        visited[i] = true;
        recStack[i] = true;
        
        int adjacent = findAdjacent(prerequisites,i) ;
        
        if(adjacent != -1 && isCyclicUtil(numCourses,adjacent,visited,recStack,prerequisites)) {
            return true;
        }
        
        recStack[i] = false ;
        return false;
    }
    
    private static int findAdjacent(int[][] prerequisites,int j) {
        for(int i=0; i < prerequisites.length ; i++) {
            if(prerequisites[i][i] == j)
                return prerequisites[i][0];
        }
        return -1 ;
        
    }
}