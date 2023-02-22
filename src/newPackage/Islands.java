package newPackage;

public class Islands {
	public static void main(String[] args) {
	
		char[][] grid = {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
		int x = numIslands(grid);
		System.out.println("number of islands is : " + x);
		
	}
	
    public static int numIslands(char[][] grid) {
        
        int size = grid.length;
        int elementSize = grid[0].length;
        boolean[][] visited = new boolean[size][elementSize];
        int count = 0;
        for(int i=0;i<size;i++)
            for(int j=0; j < elementSize; j++) {
                if(visited[i][j] == false && grid[i][j] == '1') {
                System.out.println("CC Found");
                count++;
                DFS_Visit(grid,i,j,visited);
            }
                }
              
        return count;
            }
    
    
    public static void DFS_Visit(char[][] grid,int i,int j,boolean[][] visited) {
        visited[i][j] = true;
        
        if(isSafe(i+1,j,grid,visited))
            DFS_Visit(grid,i+1,j,visited);
        if(isSafe(i-1,j,grid,visited))
            DFS_Visit(grid,i-1,j,visited);
        if(isSafe(i,j+1,grid,visited))
            DFS_Visit(grid,i,j+1,visited);
        if(isSafe(i,j-1,grid,visited))
            DFS_Visit(grid,i,j-1,visited);
    }

public static boolean isSafe(int i,int j,char[][] grid,boolean[][] visited) {
        if(i<0 || i >= grid.length || j <0 || j >= grid[0].length)
        return false;
    if(visited[i][j] == true)
        return false;
    if(grid[i][j]=='0')
        return false;
    return true;
    
}
}