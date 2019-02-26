import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class ForEachLoop {

    
    enum Face { ONE,TWO,THREE,FOUR,FIVE,SIX} 
    Collection<Face> faces = Arrays.asList(Face.values()) ;
    
    public static void main(String args[]) {
        ForEachLoop f = new ForEachLoop() ;
        f.printPossibleRolls() ;
    }

    private void printPossibleRolls() {
        int count = 0;
        for(Iterator<Face> i = faces.iterator() ; i.hasNext(); ) {
            for(Iterator<Face> j = faces.iterator() ; j.hasNext(); ) {   
                count++; 
                System.out.println(count);
                System.out.println(i.next() + "  "  + j.next());
            }
        }
    }
    
}
