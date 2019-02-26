import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeKListsMergeSortTechnique {
public static void main(String args[]) {
    List<Integer> l1 = new ArrayList<Integer>(
            Arrays.asList(4, 11, 75,77));
    
    List<Integer> l2 = new ArrayList<Integer>(
            Arrays.asList(5, 7, 45,80,95));
    
    
    List<Integer> l3 = new ArrayList<Integer>(
            Arrays.asList(9, 14, 70,85));
    
    
    List<Integer> l4 = new ArrayList<Integer>(
            Arrays.asList(2, 3, 6,8));
    
    List<Integer> l5 = new ArrayList<Integer>(
            Arrays.asList(100, 300, 600,800));
    
    List<Integer> l6 = new ArrayList<Integer>(
            Arrays.asList(12, 13, 16,18));
    

    List<List<Integer>> totalList = new ArrayList<List<Integer>> () ;
    totalList.add(l1) ;
    totalList.add(l2) ;
    totalList.add(l3) ;
    totalList.add(l4) ;
    totalList.add(l5) ;
    totalList.add(l6) ;
    
    List<Integer> mergedList = mergeSort(totalList,0,totalList.size()-1) ;
    System.out.println(mergedList);
}
    



public static List<Integer> mergeSort(List<List<Integer>> lists,int start,int end) {
    
    
    if(start==end){
        return lists.get(start) ;
    }
    
    
    else {
    
    int mid = (end+start)/2 ;
    List<Integer> left = mergeSort(lists,start,mid) ;
    List<Integer> right = mergeSort(lists,mid + 1, end) ;
    
    List<Integer> finalList = mergeTwoLists(left,right) ;
    return finalList;
    
}
    
}

public static List<Integer> mergeTwoLists(List<Integer> l1 , List<Integer> l2) {
    List<Integer> l3 = new ArrayList<Integer>() ;
    
    int i,j ;
    for( i=0,j=0; i < l1.size() && j < l2.size() ; ) {
        if(l1.get(i) < l2.get(j)) {
            l3.add(l1.get(i)) ;
            i++ ;
        }
        else {
            l3.add(l2.get(j)) ;
                j++ ;
            
        }
    }
    
    
    if(i < l1.size() ) {
        for(int m=i; m < l1.size() ; m++) {
            l3.add(l1.get(m)) ;
        }
    }
    
    if(j < l2.size()) {
        for(int m=j; m < l2.size() ; m++) {
            l3.add(l2.get(m)) ;
        }
    }
    return l3;
    
}

}