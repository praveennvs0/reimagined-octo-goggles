package newPackage;

public class Square {
public int i;
public int j;


public Square(int i,int j) {
    this.i=i;
    this.j=j;
}


public boolean isInTheFiringLine(Square s) {
    int ti = s.i ;
    int tj = s.j ;
    
    if(ti == i || tj == j) {
        return true;
    }
    
    int diffHorizontal = ti-i;
    int diffVertical = tj-j ;
    
    int hor = Math.abs(diffHorizontal) ;
    int ver = Math.abs(diffVertical) ;
    if(hor == ver)
        return true ;
    
    return false;
}
}