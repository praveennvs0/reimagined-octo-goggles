package newPackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import DataStructures.BinarySearchTree;
import DataStructures.TreeNode;


public class SerializeBST {


public static void main(String... ar)
{

 BinarySearchTree bst = new BinarySearchTree();
// List<Integer> inputList = Arrays.asList(41,37,44,24,39,42,48,1,35,38,40,43,46,49,0,2,30,36,45,47,4,29,32,
//		 3,9,26,31,34,7,11,25,27,33,6,8,10,16,28,5,15,19,12,18,20,13,17,22,14,21,23);
// for(Integer num : inputList) {
//	 bst.insertNode(num);
// }
 
// bst.insertNode(10);
// bst.insertNode(5);
// bst.insertNode(40);
// bst.insertNode(1);
// bst.insertNode(7);
// bst.insertNode(9);
// bst.insertNode(50);
// bst.insertNode(45);
// 

 List<Integer> preOrderList = new ArrayList<>();
 System.out.println("Preorder is : ");
 bst.preorderAsList(bst.root, preOrderList);
 
 //displayList(preOrderList);
 
 TreeNode n = deserialize(preOrderList);
 System.out.println();
 System.out.println("preorder after deserializing : ");
 bst.preorderRec(n);
 
 
}

private static TreeNode deserialize(List<Integer> preOrderList) {
	Map<Integer,TreeNode> nodeMap = new HashMap<>();
	TreeNode x = new TreeNode(preOrderList.get(0));
	nodeMap.put(preOrderList.get(0),x);
	boolean deletedList[] = new boolean[preOrderList.size()];
	int currIndex=0;
	
	
	while(currIndex < preOrderList.size()) {
		int startInner = currIndex+1;
	    int innerIndex = currIndex;
	    int patternBrokenIndex = -1;
	    
	    while( innerIndex+1 < preOrderList.size() && preOrderList.get(innerIndex+1) < preOrderList.get(innerIndex)) {
	    
	    TreeNode n1 = getNode(nodeMap,preOrderList.get(innerIndex));
	    TreeNode n2 = getNode(nodeMap,preOrderList.get(innerIndex+1));
	    n1.left = n2;
	    innerIndex++;	
	    }
	    
	    patternBrokenIndex = innerIndex+1 ;
	    
	    if(patternBrokenIndex < preOrderList.size()) {
		TreeNode n3 = getNode(nodeMap,preOrderList.get(patternBrokenIndex));
		int max = findTheNextLargestNode(preOrderList,deletedList,patternBrokenIndex);
		TreeNode nextLargestNode = getNode(nodeMap,max);
		if(nextLargestNode.right == null) {
		nextLargestNode.right = n3;
		}
	    
	    // mark visited
	    
	    for(int i=startInner+1 ; i < patternBrokenIndex ; i++)
				deletedList[i] = true;
		
	    }	
				
	    if(patternBrokenIndex != -1) 
	    	currIndex = patternBrokenIndex;
	    else
	    	currIndex++;
	}
	return nodeMap.get(preOrderList.get(0));
}


private static int findTheNextLargestNode(List<Integer> preOrderList, boolean[] deletedList,
		int patternBrokenIndex) {
	int  max = Integer.MIN_VALUE;
	int patternValue = preOrderList.get(patternBrokenIndex);
	for(int i=0; i < patternBrokenIndex ; i++) {
		if(deletedList[i] == true || preOrderList.get(i) > patternValue)
			continue ;
		if(preOrderList.get(i) > max) {
			max = preOrderList.get(i);
		}
		
	}
	return max;
}

private static TreeNode getNode(Map<Integer, TreeNode> nodeMap, Integer key) {
	TreeNode node = nodeMap.get(key);
	if(node == null) {
		node = new TreeNode(key);
		nodeMap.put(key, node);
	}
	return node;
}

private static void displayList(List<Integer> preOrderList) {
	System.out.println("Displaying preOrder");
preOrderList.forEach(x-> System.out.println(x));
	
}



}
