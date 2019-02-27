package DataStructures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShortestPathGraph {
    
    public static void main(String args[]) {
        Graph g = initializeGraph() ;
        Vertex s = g.vertices.get(1) ;
        Vertex v = g.vertices.get(5) ;
        int length = findShortestPath(g,s,v) ;
        System.out.println("shortest distance from " + s.getKey() +" to " + v.getKey() +" is " + length);
        
        
    }

    private static int findShortestPath(Graph g,Vertex s,Vertex v) {
        
        if(s==v) {
            return 0 ;
        }
            
        int shortestDistance = Integer.MAX_VALUE ;
        
        if(s == null || s.adjacentVertices == null) {
            System.out.println("NPE : " + s.getKey());
        }
        
        if(s.adjacentVertices.isEmpty()) {
            return Integer.MAX_VALUE ;
        }
        
        for(Vertex k : s.adjacentVertices) {
            
            int distance = findShortestPath(g,k,v) ;
            if(distance != Integer.MAX_VALUE) {
            shortestDistance = Math.min(shortestDistance,1+distance ) ;
            }
        }
        
        
        return shortestDistance;
    }

    private static Graph initializeGraph() {
        
        Graph g = new Graph() ;
        List<Vertex> vertices = new ArrayList<Vertex>() ;
     
        Vertex v0 = new Vertex(0) ;
        Vertex v1 = new Vertex(1) ;
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3) ;
        Vertex v4 = new Vertex(4) ;
        Vertex v5 = new Vertex(5) ;
        Vertex v6 = new Vertex(6) ;
        
        List<Vertex> adjacentVerticesV0 = new ArrayList<Vertex>(
                Arrays.asList(v1,v2));
        v0.setAdjacentVertices(adjacentVerticesV0);
        
        List<Vertex> adjacentVerticesV1 = new ArrayList<Vertex>(
                Arrays.asList(v3,v6));
        v1.setAdjacentVertices(adjacentVerticesV1);
        
        
        List<Vertex> adjacentVerticesV2 = new ArrayList<Vertex>(
                Arrays.asList(v3,v5));
        v2.setAdjacentVertices(adjacentVerticesV2);
        
        List<Vertex> adjacentVerticesV3 = new ArrayList<Vertex>(
                Arrays.asList(v4,v6));
        v3.setAdjacentVertices(adjacentVerticesV3);
        
        List<Vertex> adjacentVerticesV4 = new ArrayList<Vertex>(
                Arrays.asList());
        v4.setAdjacentVertices(adjacentVerticesV4);
        
        List<Vertex> adjacentVerticesV5 = new ArrayList<Vertex>(
                Arrays.asList(v4));
        v5.setAdjacentVertices(adjacentVerticesV5);
        
        List<Vertex> adjacentVerticesV6 = new ArrayList<Vertex>(
                Arrays.asList(v4));
        v6.setAdjacentVertices(adjacentVerticesV6);
        
        
        vertices.add(v0) ;
        vertices.add(v1) ;
        vertices.add(v2) ;
        vertices.add(v3) ;
        vertices.add(v4) ;
        vertices.add(v5) ;
        vertices.add(v6) ;
        
        g.setVertices(vertices);
        
        
        int[][] adjacencyMatrix = new int[7][7] ;
        for(int i=0 ; i < 7 ; i++)
            for(int j=0 ; j < 7 ; j++)
                adjacencyMatrix[i][j]=0;
        
        adjacencyMatrix[0][1] = 1 ;
        adjacencyMatrix[0][2] = 1 ;
        
        adjacencyMatrix[1][3] = 1 ;
        adjacencyMatrix[1][6] = 1 ;
        
        adjacencyMatrix[2][3] = 1 ;
        adjacencyMatrix[2][5] = 1 ;
        
        adjacencyMatrix[3][4] = 1 ;
        adjacencyMatrix[3][6] = 1 ;
        
        adjacencyMatrix[5][4] = 1 ;
        
        adjacencyMatrix[6][4] = 1 ;
        
        
        
        
        g.setAdjacencyMatrix(adjacencyMatrix);
        return g ;
    }
}
