package DataStructures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;
import java.util.LinkedList;

public class VerticalOrderTraversal {

	public static void main(String[] args) {
		TreeNode three = new TreeNode(3);
		TreeNode one = new TreeNode(1);
		TreeNode four = new TreeNode(4);
		TreeNode zero = new TreeNode(0);
		TreeNode two1 = new TreeNode(2);
		TreeNode two2 = new TreeNode(2);
		
		
		three.left = one;
		three.right = four;
		
		one.left = zero;
		one.right = two1;
		
		four.left = two2;
		
		List<List<Integer>> verticalList = verticalTraversal(three);
		System.out.println("Vertical order traversal");
		
	}
	
	 public static List<List<Integer>> verticalTraversal(TreeNode root) {
	        Map<Integer, Map<Integer, List<Integer>>> levelNodesMap = createLevelNodesMap(root);
	        
	        List<List<Integer>> lists = buildSortedListsFromMap(levelNodesMap);
	        return lists;
	        
	    }

	private static Map<Integer, Map<Integer, List<Integer>>> createLevelNodesMap(TreeNode root) {
		Map<Integer,Map<Integer,List<Integer>>  > map = new TreeMap<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		Map<TreeNode,Integer> levelMap = new HashMap<>();
		
		levelMap.put(root, 0);
		
		Map<TreeNode,Integer> depthMap = new HashMap<>();
		depthMap.put(root,0);
		while(!queue.isEmpty()) {
			TreeNode treeNode = queue.poll();
			int level = levelMap.get(treeNode);
			int depth = depthMap.get(treeNode);
			addToLevel(map,treeNode,level,depth);
			if(treeNode.left != null) {
				queue.add(treeNode.left);
				levelMap.put(treeNode.left,level-1);
				depthMap.put(treeNode.left,depth+1);
			}
			
			if(treeNode.right != null) {
				queue.add(treeNode.right);
				levelMap.put(treeNode.right,level+1);
				depthMap.put(treeNode.right,depth+1);
				
			}
			
		}
		
		return map;
	}

	private static void addToLevel(Map<Integer, Map<Integer, List<Integer>>> map, TreeNode treeNode, int level,int depth) {
		Map<Integer, List<Integer>> mapVertical = map.getOrDefault(level, new TreeMap<Integer, List<Integer>>());
		List<Integer> list = mapVertical.getOrDefault(depth, new ArrayList<>());
		list.add(treeNode.val);
		mapVertical.put(depth, list);
		map.put(level, mapVertical);
	}

	private static List<List<Integer>> buildSortedListsFromMap(Map<Integer, Map<Integer, List<Integer>>> levelNodesMap) {
		List<List<Integer>> lists = new ArrayList<>();
		for(Integer verticalLevel : levelNodesMap.keySet()) {
			Map<Integer, List<Integer>> horizontalMap = levelNodesMap.get(verticalLevel);
			
			for(Integer depth: horizontalMap.keySet()) {
				
			List<Integer> horizontalList = horizontalMap.get(depth) ;
			Collections.sort(horizontalList);
			horizontalMap.put(depth, horizontalList);
			}
			
			List<Integer> joinListsAtSameVerticalLevel = new ArrayList<>();
			for(Integer depth: horizontalMap.keySet()) {
				List<Integer> verticalLevelList = horizontalMap.get(depth);
				joinListsAtSameVerticalLevel.addAll(verticalLevelList);
			}
			
			lists.add(joinListsAtSameVerticalLevel);
			
			
		}
		return lists;
	}
}
