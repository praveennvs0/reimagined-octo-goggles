package newPackage;

import java.util.ArrayList;

public class Position {

    int x ;
    int y ;
    
    ArrayList<Integer> positionAsList ;
    
    Position(int x,int y) {
        this.x = x ;
        this.y = y ;
        positionAsList = new ArrayList<Integer> () ;
        positionAsList.add(x) ;
        positionAsList.add(y) ;
    }
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    
    ArrayList<Integer> returnList() {
       
        return positionAsList ;
    }
    
    
    
}
