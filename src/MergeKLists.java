import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeKLists {

    public static void main(String args[]) {
        List<Integer> l1 = new ArrayList<Integer>(
                Arrays.asList(4, 11, 75));
        
        List<Integer> l2 = new ArrayList<Integer>(
                Arrays.asList(5, 7, 45,80));
        
        
        List<Integer> l3 = new ArrayList<Integer>(
                Arrays.asList(3, 14, 70));
        
        
       List<List<Integer>> totalList = new ArrayList<List<Integer>> () ;
       totalList.add(l1) ;
       totalList.add(l2) ;
       totalList.add(l3) ;
       
        List<Integer> mergedList = merge(totalList) ;
        
        System.out.println("merged List is : " + mergedList );
        
        
        
    }
    
    
    public static List<Integer> merge(List<List<Integer>> lists ) {
        List<Integer> currentList = new ArrayList<Integer> () ;
        for(int i=0 ; i < lists.size() ; i++) {
            currentList = mergeTwoLists(currentList,lists.get(i)) ;
        }
        
        return currentList ;
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
