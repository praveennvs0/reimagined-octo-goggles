package newPackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class NQueensInOneClass {
    public class Square implements Comparator<Square> {
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


        @Override
        public int compare(Square o1, Square o2) {
            int result = o1.i-o2.i ;
            return result;
        }
        }

public static List<List<String>> solveNQueens(int n) {
    List<Square> board = new ArrayList<Square> () ;
    
    for(int i=0;i < n ; i++) 
        for(int j=0; j<n ; j++) {
            
        NQueensInOneClass nqueensInOneClass = new NQueensInOneClass() ;
        NQueensInOneClass.Square s = nqueensInOneClass.new Square(i,j) ;
        board.add(s) ;
        
    }
    
    ArrayList<Square> solution = new ArrayList<Square>() ;
    List<Square> underFire = new ArrayList<Square>() ;
    List<ArrayList<Square>> resultList = new ArrayList<ArrayList<Square>> () ;
    
    
 findAllConfigurations(board,solution,underFire,n,resultList);
    
  
    resultList.forEach(element->printlist(element));
    
    
    List<List<String>> allSolutionsList = resultList.stream().map(result-> {
        List<String> stringList = convert(result,n) ;
        return stringList ;
        
    }).collect(Collectors.toList());
    
    System.out.println("no. of solutions is : " + resultList.size());
    return allSolutionsList;
        
    }

public static void main(String args[]) {
    
    solveNQueens(4) ;
  
}
    
private static List<String> convert(ArrayList<Square> result, int n) {
    List<String> listOfStrings = new ArrayList<String>() ;
    char stringMatrix[][] = new char[n][n] ;
    for(int i=0;i<n;i++)
        for(int j=0;j<n;j++)
            stringMatrix[i][j] = '.';
        
    result.forEach(s->{
        stringMatrix[s.i][s.j] = 'Q' ;
    });
    
    for(int i=0;i<n;i++){
        char[] charArray = new char[n] ;    
        for(int j=0;j<n;j++) {
            charArray[j] = stringMatrix[i][j] ;
        }
       String s = new String(charArray) ;
       listOfStrings.add(s) ;
    }    
    return listOfStrings;
}

public static boolean findAllConfigurations(List<Square> availablePositions,List<Square> solution,List<Square> underFireList,int num, List<ArrayList<Square>> resultList) {
    if(solution.size() == num && !alreadyVisitedConfig(solution,resultList)){
        ArrayList<Square> oneSolution = (ArrayList<Square>) solution ;
        ArrayList<Square> copy = createCopyList(oneSolution) ;
        resultList.add(copy) ;
        
        return false ;
    }
    for(int i=0; i < availablePositions.size() ; i++) {
        
        Square pos = availablePositions.get(i) ;
        if(isSafe(pos,underFireList,solution)) {
            solution.add(pos) ;
            List<Square> newlyAttackedList = newlyAttacked(availablePositions,pos,underFireList) ;
            underFireList.addAll(newlyAttackedList) ;
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


private static ArrayList<Square> createCopyList(List<Square> solution) {
    ArrayList<Square> copy  = new ArrayList<Square> () ;
    for(Square s : solution) 
        copy.add(s) ;
    return copy;
}

private static boolean alreadyVisitedConfig(List<Square> solution, List<ArrayList<Square>> configList) {
    Collections.sort(solution, new Comparator<Square>(){
        public int compare(Square o1, Square o2) {
            int result = o1.i-o2.i ;
            return result;
        }
    });
    
    Collections.sort(solution, new Comparator<Square>(){
        public int compare(Square o1, Square o2) {
            int result = o1.j-o2.j ;
            return result;
        }
    });
    
    
    boolean alreadyVisited = false ;
    for(int l=0 ; l < configList.size() ; l++) {
        int count = 0 ;
        ArrayList<Square> listOfSquares = configList.get(l) ;
        Collections.sort(listOfSquares,  new Comparator<Square>(){
            public int compare(Square o1, Square o2) {
                int result = o1.i-o2.i ;
                return result;
            }
        });
        Collections.sort(listOfSquares, new Comparator<Square>(){
            public int compare(Square o1, Square o2) {
                int result = o1.j-o2.j ;
                return result;
            }
        });
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


