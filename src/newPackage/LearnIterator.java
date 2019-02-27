package newPackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LearnIterator {
   public static void main(String args[]) {
       List<String> solution = new ArrayList<String>() ;
       solution.add("first");
       solution.add("second");
       solution.add("third");
       
        for (Iterator<String> iter = solution.iterator(); iter.hasNext();) {
            String s = iter.next();
            System.out.println(s);
        }
    
   }
}
