package DataStructures;

public class BinaryTilt {
	
	int binaryTilt = 0;

	public static void main(String[] args) {
		
	}
	
	
public int findTilt(TreeNode root,int sum) {
        
	if(root == null)
		return 0;
	
	if(root.left == null && root.right == null)
		return 0;
	
	
      int leftSum =  findSum(root.left);
      int rightSum = findSum(root.right);

      int tilt = Math.abs(leftSum-rightSum);
      binaryTilt+= tilt;
        
        return binaryTilt;
    }



public int findSum(TreeNode node) {
	int sum = 0;
	
	return sum;
}
}
