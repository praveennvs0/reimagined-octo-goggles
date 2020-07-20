package DataStructures;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.HashMap;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Map;
//import java.util.Set;
//import java.util.TreeSet;
//
public class KClosestPoints {
//	class Point {
//		int x;
//		int y;
//		Point(int x,int y) {
//			this.x = x ;
//			this.y = y ;
//		}
//	}
//	
//	public static void main(String[] args) {
//		int[][] points =  {{1,3},{-2,2}};
//		
//		int k = 1 ;
//		int[][] kClosest = kClosest(points,k);
//		System.out.println("hello world");
//	}
//
//	private static int[][] kClosest(int[][] points,int k) {
//		int[][] kClosest = new int[k][];
//		Map<Point,Integer> distanceIndexMap = new HashMap<>();
//		double distance = 0;
//		double[] distances = new double[points.length];
//		
//		for(int i=0;i<points.length;i++) {
//			int[] point = points[i];
//			distance = Math.sqrt(Math.pow(point[0],2) + Math.pow(point[1], 2));
//			System.out.println("distance is : " + distance );
//			distances[i] = distance;
//			
//		}
//		
//		double[] distancesCopy = Arrays.copyOf(distances,distances.length);
//		Arrays.sort(distancesCopy);
//		Set<Double> distancesWithoutDuplicates = new TreeSet<>();
//		
//		for(int i=0;i<distancesCopy.length;i++)
//			distancesWithoutDuplicates.add(distancesCopy[i]);
//		
//		TreeSet s ;
//		List<Integer> indices = new ArrayList<>();
//		List<Integer> alreadyChosenIndices = new ArrayList<Integer>();
//		for(int i=0; i < k ; i++) {
//			
//		  	List<Integer> innerIndices = searchForIndices(distances,distancesWithoutDuplicates[i]); 
//		  	indices.addAll(innerIndices);
//		///  	if(indices.)
//		}
//		
//		
//		return null;
//	}
//
//	private static List<Integer> searchForIndices(double[] distances, double d) {
//		List<Integer> indices = new ArrayList<>();
//		for(int i=0 ; i < distances.length; i++) {
//			if(distances[i] == d)
//				indices.add(i);
//			
//		}
//		return indices;
//	}
//
}
