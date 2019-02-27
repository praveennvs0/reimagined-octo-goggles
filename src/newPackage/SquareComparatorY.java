package newPackage;

import java.util.Comparator;

public class SquareComparatorY implements Comparator<Square> {
    @Override
    public int compare(Square o1, Square o2) {
        
        int result = o1.j-o2.j ;
        return result;
    }
}
