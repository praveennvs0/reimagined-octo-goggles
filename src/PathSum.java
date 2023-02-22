import DataStructures.TreeNode;

public class PathSum {
	public static void main(String[] args) {
		TreeNode ten = new TreeNode(10);
		TreeNode five = new TreeNode(5);
		TreeNode three = new TreeNode(3);
		TreeNode two = new TreeNode(2);
		TreeNode three2 = new TreeNode(3);
		TreeNode minusTwo = new TreeNode(-2);
		TreeNode one = new TreeNode(1);
		TreeNode minusThree = new TreeNode(-3);
		TreeNode eleven = new TreeNode(11);
		
		ten.left = five;
		ten.right = minusThree;
		
		five.left = three;
		five.right = two;
		
		three.left = three2;
		three.right = minusTwo;
		
		five.right = two;
		two.right = one;
		
		minusThree.right = eleven ;
		
		int sum = 8;
		int pathSum = pathSum(ten,sum);
		System.out.println("no. of ways is : " + pathSum);
		
		
	}

	private static int pathSum(TreeNode node, int sum) {

		if(node == null)
			return 0 ;
		
		if(sum == 0) {
			System.out.println("Path found");
			return 1;
		}
		
		
		
		int left = pathSum(node.left,sum-node.getKey()) ;
		int right = pathSum(node.right,sum-node.getKey());
		int notChosenAndGoLeft = pathSum(node.left,sum);
		int notChosenAndGoRight = pathSum(node.right,sum);
		
		int total = left + right + notChosenAndGoLeft +  notChosenAndGoRight ;
		return total;
	}

}
