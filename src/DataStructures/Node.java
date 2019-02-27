package DataStructures;

public class Node {

     int key ;
     Node left ;
     Node right;
     Node parent;
    
    public Node(int key){
        this.setKey(key) ;
        setLeft(null);
        setRight(null);
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }
}
