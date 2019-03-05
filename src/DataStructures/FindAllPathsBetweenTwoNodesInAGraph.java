package DataStructures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllPathsBetweenTwoNodesInAGraph {

    public static void main(String args[]) {
        Graph g = initializeGraph() ;
        boolean[] visited = {false,false,false,false,false}; 
        
        List<Integer> path = new ArrayList<Integer>();
        
        path.add(g.getVertices().get(0).getKey()) ;
        
        DFS_VisitPathFinder(g.getVertices().get(0),g.getVertices().get(2),visited,path) ;
      
    
            }

   
    private static void DFS_VisitPathFinder(Vertex v,Vertex destination,boolean[] visited, List<Integer> path) {
        visited[v.getKey()] = true ;
       // System.out.print(v.getKey()+":");
        if(v.getKey()==destination.getKey()) {
        printPath(path) ; 
        path.remove(path.size()-1) ;
        visited[v.getKey()]=false;
        return ;
        }
        
        
        for(Vertex adj :v.getAdjacentVertices()) {
            if(visited[adj.getKey()] == false) {
                path.add(adj.getKey());
                DFS_VisitPathFinder(adj,destination,visited,path) ;
            }
        }
        
        path.remove(path.size()-1) ;
        
    }
    
    private static void printPath(List<Integer> path) {
        System.out.println("------");
        System.out.println("path found");
        path.forEach(x->
        {System.out.print(x);
        System.out.print(":");
        }
        );
    }


    private static void DFS(Graph g,boolean[] visited) {
        for(Vertex v : g.vertices) {
            if(visited[v.getKey()] == false ) {
                DFS_Visit(v,visited) ;
            }
        }
        
    }


    private static void DFS_Visit(Vertex v,boolean[] visited) {
        visited[v.getKey()] = true ;
        System.out.print(v.getKey()+":");
        for(Vertex adj :v.getAdjacentVertices()) {
            if(visited[adj.getKey()] == false)
                DFS_Visit(adj,visited) ;
        }
        
        
    }


    private static Graph initializeGraph() {
       
        Graph g = new Graph() ;
        List<Vertex> vertices = new ArrayList<Vertex>() ;
     
        Vertex v0 = new Vertex(0) ;
        Vertex v1 = new Vertex(1) ;
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3) ;
        Vertex v4 = new Vertex(4) ;
        
        List<Vertex> adjacentVerticesV0 = new ArrayList<Vertex>(
                Arrays.asList(v1,v3));
        v0.setAdjacentVertices(adjacentVerticesV0);
        
        List<Vertex> adjacentVerticesV1 = new ArrayList<Vertex>(
                Arrays.asList(v0,v2,v4));
        v1.setAdjacentVertices(adjacentVerticesV1);
        
        
        List<Vertex> adjacentVerticesV2 = new ArrayList<Vertex>(
                Arrays.asList(v1,v4));
        v2.setAdjacentVertices(adjacentVerticesV2);
        
        List<Vertex> adjacentVerticesV3 = new ArrayList<Vertex>(
                Arrays.asList(v0,v4));
        v3.setAdjacentVertices(adjacentVerticesV3);
        
        List<Vertex> adjacentVerticesV4 = new ArrayList<Vertex>(
                Arrays.asList(v2,v3,v1));
        v4.setAdjacentVertices(adjacentVerticesV4);
        
        
        vertices.add(v0) ;
        vertices.add(v1) ;
        vertices.add(v2) ;
        vertices.add(v3) ;
        vertices.add(v4) ;
        
        g.setVertices(vertices);
        
        
        int[][] adjacencyMatrix = new int[5][5] ;
        for(int i=0 ; i < 5 ; i++)
            for(int j=0 ; j < 5 ; j++)
                adjacencyMatrix[i][j]=0;
        
        adjacencyMatrix[0][1] = 1 ;
        adjacencyMatrix[0][3] = 1 ;
        
        adjacencyMatrix[1][0] = 1 ;
        adjacencyMatrix[1][2] = 1 ;
        
        
        
        adjacencyMatrix[2][1] = 1 ;
        adjacencyMatrix[2][4] = 1 ;
        
        adjacencyMatrix[3][0] = 1 ;
        adjacencyMatrix[3][4] = 1 ;
        
        adjacencyMatrix[4][2] = 1 ;
        adjacencyMatrix[4][3] = 1 ;
        
        g.setAdjacencyMatrix(adjacencyMatrix);
        return g ;
    }
}
