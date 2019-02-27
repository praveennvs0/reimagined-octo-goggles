package DataStructures;

public class SquareSubMatrix {

    public static void main(String args[]) {
        int rows = 4, columns = 5 ;
        int m[][] = new int[rows][columns] ;
        for(int i=0;i<rows;i++) {
            for(int j=0;j<columns;j++){
                m[i][j]=0;
            }
            
        }
        
        m[0][0] = 1;
        m[0][2] = 1;
        
        m[1][0] = 1;
        m[1][2] = 1;
        m[1][3] = 1;
        m[1][4] = 1;
        
        m[2][0]= 1;
        m[2][1]=1;
        m[2][2]=1;
        m[2][3]=1;
        m[2][4]=1;
        
        m[3][0]=1;
        m[3][3] = 1;
        m[3][2]=1;
        m[3][4]=0;
        
        
        int size = maximalSquare(m,rows,columns) ; 
        System.out.println("size is : " + size);
         
    }

    private static int maximalSquare(int[][] m,int rows,int columns) {
        int size = Integer.MIN_VALUE ;
        
        for(int i=0;i<rows;i++) 
            for(int j=0 ; j <columns ; j++) {
                if(m[i][j] == 1) {
                    if(i==1 && j==2){
                        System.out.println("break point");
                    }
                        
                    int max=Math.max(rows, columns) ;
                    for(int k=0;k<max;k++) {
                        int subSize = checkValidMatrix(i,j,i+k,j+k,rows,columns,m);
                       size=Math.max(size, subSize) ; 
                       
                            
                        
                    }
                    
                }
                
            }
                
        
        return size;
    }

    private static int checkValidMatrix(int i, int j, int k, int l, int rows, int columns, int[][] m) {
        
        if(!(i>=0 && i < rows && j>=0 && j< columns && k >=0 && k<rows && l>=0 && l < columns)) {
            return 0 ;
        }
        if(i==k && j==l)
            return 0;
        
        for(int p=i;p<=k;p++)
            for(int q=j;q<=l;q++)  {
                if(m[p][q] ==0)
                    return 0 ;
            }
                
        int size = k-i+1 ;
        return size;
    }
}
