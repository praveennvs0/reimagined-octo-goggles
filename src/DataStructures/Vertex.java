package DataStructures;

import java.util.List;

public class Vertex {
    private int key;
    List<Vertex> adjacentVertices ;

    public List<Vertex> getAdjacentVertices() {
        return adjacentVertices;
    }

    public void setAdjacentVertices(List<Vertex> adjacentVertices) {
        this.adjacentVertices = adjacentVertices;
    }

    public Vertex(int key) {
        this.key = key ;
    }
    
    public int getKey() {
        return key ;
    }
}
