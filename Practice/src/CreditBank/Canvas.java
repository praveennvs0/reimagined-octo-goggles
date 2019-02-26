package CreditBank;

public class Canvas {

    char[][] charArray ;
    int height,width ;
    
    Canvas(int height,int width) {
        this.height = height ;
        this.width = width ;
        
        charArray = new char[height][width] ;
        drawLine(0,0,width,0,'-') ;
    }
    
    public char[][] getCharArray() {
        return charArray;
    }

    public void setCharArray(char[][] charArray) {
        this.charArray = charArray;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void drawLine(int x1,int y1,int x2,int y2,char character) {
        verifyCanvasCreated() ;
      
        if(y1==y2) { //horizontal line
        for(int i=x1;i<x2;i++) {
            charArray[i][y1] = character ;
        }
        
    }
        
        
        if(x1==x2) { //vertical line
            for(int i=x1;i<x2;i++) {
                charArray[x1][i] = character ;
            }
        }
       
        System.out.println("hello");
        
    }
    
    
    

    public void prepareCanvas(int width,int height) {
       
        
    }
    
    
    private void verifyCanvasCreated() {

        if(charArray == null) {
            //throw exception later
            System.out.println("You have not created canvas");
            System.exit(0);
        }
        
    }
       
}
