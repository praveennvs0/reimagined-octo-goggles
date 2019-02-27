import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class DefensiveCopy {

    
    public static void main(String args[]) {
       Set<Integer> set = new TreeSet<Integer>() ;
       
       List<Integer> list = new ArrayList<Integer>() ;
       
       for(int i =-3 ; i<3 ; i++) {
           set.add(i) ;
           list.add(i);
       }
       
       Hashtable t ;
       
       

       for(int i=0 ; i < 3 ; i++){
           list.remove((Integer)i) ;
       }
       
       
       System.out.println(list);
        
        
    }
}
