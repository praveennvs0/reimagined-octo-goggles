package DataStructures;

public class TreeNode {

     public int val ;
     public TreeNode left ;
     public TreeNode right;
     public TreeNode parent;
    
    public TreeNode(int key){
        this.setKey(key) ;
        setLeft(null);
        setRight(null);
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public int getKey() {
        return val;
    }

    public void setKey(int key) {
        this.val = key;
    }
    
    @Override
    public  String toString() {
    	return Integer.toString(val);
    }
}
