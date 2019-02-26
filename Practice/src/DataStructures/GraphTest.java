package DataStructures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GraphTest {

    public static void main(String args[]) {
        Graph g = initializeGraph() ;
   
        
        findAllPaths(g) ;
    
    
            }

    private static void findAllPaths(Graph g) {
        List<ArrayList<Integer>> paths = new ArrayList<ArrayList<Integer>>() ;
        
        List<ArrayList<Integer>> finalPaths = new ArrayList<ArrayList<Integer>>() ;
        Vertex start = g.getVertices().get(5) ;
        Vertex goal = g.getVertices().get(1) ;
        Queue<Vertex> q = new Queue<Vertex>() ;
        q.enqueue(start);
        int [][] adjacencyMatrix = g.getAdjacencyMatrix() ; 
        int [][] traversalMatrix = fullCopy(adjacencyMatrix) ;
        Map<Vertex, Vertex> parentMap = new HashMap<Vertex,Vertex>() ;
        
        
         while(!q.isEmpty()){
             Vertex current = q.dequeue() ;
             List<Vertex> adjacentList = current.getAdjacentVertices() ;
             for(Vertex v : adjacentList) {
                 int edgeValue = traversalMatrix[current.getKey()][v.getKey()] ;
                     if(v==goal && current == start) {
                         System.out.println("Direct path found from "+current.getKey()+" : "+v.getKey());
                         
                     }
                         
                     else if(v==goal && current != start){
                         traversalMatrix[current.getKey()][v.getKey()]  = 0 ;
                         List<ArrayList<Integer>> filteredPaths = new ArrayList<ArrayList<Integer>>() ;
                         filteredPaths  = filterPaths(paths,current.getKey(),goal.getKey()) ;
                             
                                 finalPaths.addAll(filteredPaths) ;
                         
                     }
                     
                     else if (edgeValue == 1) {
                 
                 traversalMatrix[current.getKey()][v.getKey()]  = 0 ;
                 q.enqueue(v);
                 
                 List<Integer> path = createPath(current,parentMap) ;
                 if(!path.contains(v.getKey())) {
                 path.add(v.getKey()) ;
                 }
                 parentMap.put(v, current) ;
                 System.out.println("parent map : " );
                 parentMap.forEach((key, value) -> System.out.println(key.getKey() + " : " + value.getKey()));

                 paths.add((ArrayList<Integer>) path) ;
               
             }
             
         }
         }
         
        printPaths(finalPaths) ;
    }


    private static List<ArrayList<Integer>> filterPaths(List<ArrayList<Integer>> paths, int key,int goal) {
        List<ArrayList<Integer>> filteredPaths = new ArrayList<ArrayList<Integer>>() ;
        if(paths.isEmpty()) 
            return filteredPaths;
        for(int i=0 ; i < paths.size() ; i++) {
            ArrayList<Integer> path = paths.get(i) ;
            int lastElement = path.get(path.size()-1) ;
            if(lastElement == key) {
                path.add(goal) ;
                filteredPaths.add(path) ;
            }
        }
        
        List<ArrayList<Integer>> copyOfPaths = createCopyOfPaths(filteredPaths) ;
        return copyOfPaths;
    }

    private static List<ArrayList<Integer>> createCopyOfPaths(List<ArrayList<Integer>> filteredPaths) {
        List<ArrayList<Integer>> pathsToReturn = new ArrayList<ArrayList<Integer>>() ;
        filteredPaths.forEach(path->pathsToReturn.add(createCopyOfPath(path)));
        return pathsToReturn;
    }

    private static ArrayList<Integer> createCopyOfPath(ArrayList<Integer> path) {
        List<Integer> pathToReturn = new ArrayList<Integer> () ;
        path.forEach(n->pathToReturn.add(n));
        
        return (ArrayList<Integer>) pathToReturn;
    }

    private static List<Integer> createPath(Vertex current, Map<Vertex, Vertex> parentMap) {
        List<Integer> path = new ArrayList<Integer> () ;
        Vertex temp = current ;
        List<Integer> elementseEncounteredSoFar = new ArrayList<Integer>() ;
        while(temp != null) {
            if(elementseEncounteredSoFar.contains(temp.getKey()))
                break ;
            path.add(0,temp.getKey()) ;
            elementseEncounteredSoFar.add(temp.getKey()) ;
            temp=parentMap.get(temp) ;
        }
        return path;
        
    }


    private static void printPaths(List<ArrayList<Integer>> paths) {
        
        if(paths.size() == 0){
        return ;
        }
        
        
        System.out.println("no. of paths is : " + paths.size()) ;

        paths.forEach(n->printPath(n));
            
    }

    private static void printPath(ArrayList<Integer> n) {
        System.out.println("Path  : " );
        n.forEach(v->System.out.print(v+" : "));
        
        System.out.println(" ");

    }


    private static int[][] fullCopy(int[][] adjacencyMatrix) {
        int [][] matrix  = new int[6][6] ;
        for(int i=0 ; i < 6 ; i++)
            for(int j=0 ; j<6 ; j++)
                matrix[i][j] = adjacencyMatrix[i][j] ;
        return matrix;
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
        
        List<Vertex> adjacentVerticesV0 = new ArrayList<Vertex>(
                Arrays.asList(v1,v3,v5));
        v0.setAdjacentVertices(adjacentVerticesV0);
        
        List<Vertex> adjacentVerticesV1 = new ArrayList<Vertex>(
                Arrays.asList(v2));
        v1.setAdjacentVertices(adjacentVerticesV1);
        
        
        List<Vertex> adjacentVerticesV2 = new ArrayList<Vertex>(
                Arrays.asList(v3));
        v2.setAdjacentVertices(adjacentVerticesV2);
        
        List<Vertex> adjacentVerticesV3 = new ArrayList<Vertex>(
                Arrays.asList(v4));
        v3.setAdjacentVertices(adjacentVerticesV3);
        
        List<Vertex> adjacentVerticesV4 = new ArrayList<Vertex>(
                Arrays.asList(v2,v0));
        v4.setAdjacentVertices(adjacentVerticesV4);
        
        List<Vertex> adjacentVerticesV5 = new ArrayList<Vertex>(
                Arrays.asList(v2,v3,v1));
        v5.setAdjacentVertices(adjacentVerticesV5);
        
        
        vertices.add(v0) ;
        vertices.add(v1) ;
        vertices.add(v2) ;
        vertices.add(v3) ;
        vertices.add(v4) ;
        vertices.add(v5) ;
        
        g.setVertices(vertices);
        
        
        int[][] adjacencyMatrix = new int[6][6] ;
        for(int i=0 ; i < 6 ; i++)
            for(int j=0 ; j < 6 ; j++)
                adjacencyMatrix[i][j]=0;
        
        adjacencyMatrix[0][1] = 1 ;
        adjacencyMatrix[0][5] = 1 ;
        adjacencyMatrix[0][3] = 1 ;
        adjacencyMatrix[1][2] = 1 ;
        adjacencyMatrix[2][3] = 1 ;
        adjacencyMatrix[3][4] = 1 ;
        adjacencyMatrix[4][2] = 1 ;
        adjacencyMatrix[5][2] = 1 ;
        adjacencyMatrix[5][3] = 1 ;
        adjacencyMatrix[4][0] = 1 ;
        adjacencyMatrix[5][1] = 1 ;
        
        g.setAdjacencyMatrix(adjacencyMatrix);
        return g ;
    }
}
