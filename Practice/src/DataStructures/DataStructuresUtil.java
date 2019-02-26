package DataStructures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class DataStructuresUtil {
    
    public static void main(String args[]) {
        Map<Integer,Integer> nodeMap = new HashMap<Integer,Integer>() ;
        nodeMap.put(80, 2) ;
        nodeMap.put(50, 0) ;
        nodeMap.put(20, -2) ;
        nodeMap.put(70, 1) ;
        nodeMap.put(40, 0) ;
        nodeMap.put(60, 0) ;
        nodeMap.put(30, -1) ;
        decorate(nodeMap) ;
    }

    
    public static void decorate(Map<Integer,Integer> map) {

        Set<Integer> valueSet = new HashSet<Integer>() ;
        

        Map<Integer,List<Integer>> distanceNodesListMap = new TreeMap<Integer,List<Integer>>() ;
        
      //iterating over values only
      for (Integer key : map.keySet()) {
          System.out.println("key = " + key);
          System.out.println("value = " + map.get(key));
          
          
          updateDistanceNodesListMultiMap(distanceNodesListMap,map.get(key),key) ;
      }
        
      
      System.out.println("vertical traversal of the tree is ");
      
      for(Integer key: distanceNodesListMap.keySet()) {
          List<Integer> nodeList = distanceNodesListMap.get(key) ;
          printList(nodeList) ;
          System.out.println();
      }
    }

    private static void printList(List<Integer> nodeValues) {

        nodeValues.forEach(n->System.out.print(n + " ") );
    }


    private static void updateDistanceNodesListMultiMap(Map<Integer, List<Integer>> distanceNodesListMap, Integer key,
            Integer value) {
        List<Integer> valueList = distanceNodesListMap.get(key) ;

        if(valueList == null || valueList.isEmpty()) {
            valueList = new ArrayList<Integer>() ;
        }
        valueList.add(value) ;
        distanceNodesListMap.put(key, valueList) ;
        System.out.println("hello");
        
    }
}
