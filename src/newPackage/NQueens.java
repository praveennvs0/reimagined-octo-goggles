package newPackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NQueens {
    

public static void main(String args[]) {
    List<Square> board = new ArrayList<Square> () ;
    int n = 8 ,noOfQueens = 8;
   for(int i=0;i < n ; i++) 
       for(int j=0; j<n ; j++) {
           
       Square s = new Square(i,j) ;
       board.add(s) ;
       
   }
   
   ArrayList<Square> solution = new ArrayList<Square>() ;
   List<Square> underFire = new ArrayList<Square>() ;
   List<ArrayList<Square>> resultList = new ArrayList<ArrayList<Square>> () ;
   
   
//   solve(board,solution,underFire,n) ;
//   System.out.println("------------------");
//   System.out.println("Hey guys ...the solution is : " );
//   printlist(solution) ;
//   
   
   
   
   
   
findAllConfigurations(board,solution,underFire,noOfQueens,resultList);
   
   System.out.println("------------------");
   
   
   System.out.println("Hey guys ...solution is : " );
   System.out.println("no. of solutions is : " + resultList.size());
 
   resultList.forEach(element->printlist(element));
   
    
}
    
public static boolean findAllConfigurations(List<Square> availablePositions,List<Square> solution,List<Square> underFireList,int num, List<ArrayList<Square>> resultList) {
    if(solution.size() == num && !alreadyVisitedConfig(solution,resultList)){
        ArrayList<Square> oneSolution = (ArrayList<Square>) solution ;
        ArrayList<Square> copy = createCopyList(oneSolution) ;
        System.out.println("SOLUTION FOUND : " );
        printlist(oneSolution) ;
        resultList.add(copy) ;
        
        return false ;
    }
    for(int i=0; i < availablePositions.size() ; i++) {
        
        Square pos = availablePositions.get(i) ;
        if(isSafe(pos,underFireList,solution)) {
            solution.add(pos) ;
          //  System.out.println("current position is : " + pos.i+","+pos.j );
            List<Square> newlyAttackedList = newlyAttacked(availablePositions,pos,underFireList) ;
//            System.out.println("newly attacked list is : " ) ;
//            printlist(newlyAttackedList);
            underFireList.addAll(newlyAttackedList) ;
//            System.out.println("under fire list is : " ) ;
//            printlist(underFireList);
            if(findAllConfigurations(availablePositions,solution,underFireList,num,resultList)) {
                return true ;
            }
            
            //we could not solve..therefore, backtrack
            underFireList.removeAll(newlyAttackedList) ;
            solution.remove(pos) ;
            
        }
    }
    return false;

    
    
  
}

public static boolean solve(List<Square> availablePositions,List<Square> solution,List<Square> underFireList,int num) {
    if(solution.size() == num ){
        return true  ;
    }
    for(int i=0; i < availablePositions.size() ; i++) {
        
        Square pos = availablePositions.get(i) ;
        if(isSafe(pos,underFireList,solution)) {
            solution.add(pos) ;
          //  System.out.println("current position is : " + pos.i+","+pos.j );
            List<Square> newlyAttackedList = newlyAttacked(availablePositions,pos,underFireList) ;
//            System.out.println("newly attacked list is : " ) ;
//            printlist(newlyAttackedList);
            underFireList.addAll(newlyAttackedList) ;
//            System.out.println("under fire list is : " ) ;
//            printlist(underFireList);
            if(solve(availablePositions,solution,underFireList,num)) {
                return true ;
            }
            
            //we could not solve..therefore, backtrack
            underFireList.removeAll(newlyAttackedList) ;
            solution.remove(pos) ;
            
        }
    }
    return false;

    
    
  
}

private static ArrayList<Square> createCopyList(List<Square> solution) {
    ArrayList<Square> copy  = new ArrayList<Square> () ;
    for(Square s : solution) 
        copy.add(s) ;
    return copy;
}

private static boolean alreadyVisitedConfig(List<Square> solution, List<ArrayList<Square>> configList) {
    Collections.sort(solution, new SquareComparatorX());
    Collections.sort(solution, new SquareComparatorY());
    
    
    boolean alreadyVisited = false ;
    for(int l=0 ; l < configList.size() ; l++) {
        int count = 0 ;
        ArrayList<Square> listOfSquares = configList.get(l) ;
        Collections.sort(listOfSquares, new SquareComparatorX());
        Collections.sort(listOfSquares, new SquareComparatorY());
        //compare listOfSquares with solution
        for(int m=0;m<solution.size() ; m++) {
            int configX = listOfSquares.get(m).i ;
            int configY = listOfSquares.get(m).j ;
            int currentX = solution.get(m).i ;
            int currentY = solution.get(m).j ;
            if(configX == currentX && configY == currentY) 
                count++ ;
            
            
        }
        
        if(count == solution.size()) 
            alreadyVisited = true ;
    }
    
 
    return alreadyVisited;
}


private static List<Square> newlyAttacked(List<Square> availablePositions,Square pos,List<Square> underFireList) {
    List<Square> newlyAttackedList = new ArrayList<Square> () ;
    
    
    for(Square s: availablePositions) {
        boolean canAdd = false ;
        if(s.i==pos.i || s.j== pos.j ) {
            canAdd = true ;
        }
        
      
        
        int diffHorizontal = s.i-pos.i;
        int diffVertical = s.j-pos.j ;
        
        int hor = Math.abs(diffHorizontal) ;
        int ver = Math.abs(diffVertical) ;
        if(hor == ver) {
            canAdd = true ;
        }
            
        boolean isAlreadyUnderFire = underFireList.contains(s) ;
        if(canAdd && !isAlreadyUnderFire)
            newlyAttackedList.add(s);
        
            
    }
    return newlyAttackedList;
}


public static void printlist(List<Square> list) {
    
    list.forEach(n-> System.out.println("square : " + n.i+ "," + n.j));
    System.out.println("-----------");
        
}

private static boolean isSafe(Square pos, List<Square> underFireList, List<Square> solution) {
   
    for(Square s :underFireList) {
        if(s.i == pos.i && s.j== pos.j)
            return false ;
    }
    
    for(Square s :solution) {
        if(s.i == pos.i && s.j== pos.j)
            return false ;
    }
    
    
    return true ;
}






}


