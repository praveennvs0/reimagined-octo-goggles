package newPackage;

import java.util.Comparator;

public class SquareComparatorX implements Comparator<Square> {

    @Override
    public int compare(Square o1, Square o2) {
        
        int result = o1.i-o2.i ;
        return result;
    }

}
