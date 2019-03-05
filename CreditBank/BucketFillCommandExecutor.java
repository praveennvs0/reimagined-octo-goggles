package CreditBank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BucketFillCommandExecutor extends CommandExecutor {

    private int noOfParamsAllowedInCommand = 4 ;
    
    
    @Override
    public Canvas executeCommand(Canvas canvas, String[] cmds) {
        verifyCanvasCreated(canvas) ;
        validate(cmds) ;
        int x=Integer.parseInt(cmds[1]);
        int y=Integer.parseInt(cmds[2]);
        char color = cmds[3].charAt(0);
        floodFill(canvas,y,x,color) ;
        return canvas;
    }

    private void floodFill(Canvas canvas, int x, int y,char color) {
        
        floodFillUtil(canvas.getCharArray(),x,y,canvas.getHeight(),canvas.getWidth(),color) ;
    }
    
    //Uses the standard Flood-fill algorithm.. Depth First Search
    public void floodFillUtil(char[][] charArray,int x,int y,int height,int width,char color) {
        
        if(x<0 || y < 0 || x > height || y > width) {
            return ;
        }
        
        //means we are entering a different island
        if(charArray[x][y] != ' ') {
            return ;
        }
        charArray[x][y] = color ;
        
        floodFillUtil(charArray,x+1,y,height,width,color) ;
        floodFillUtil(charArray,x-1,y,height,width,color) ;
        floodFillUtil(charArray,x,y+1,height,width,color) ;
        floodFillUtil(charArray,x,y-1,height,width,color) ;
    }

    @Override
    public void validate(String[] cmds)  {
        String commandName = cmds[0] ;
        if(!commandName.equals(CommandName.BUCKETFILL.getCommandName())) {
            throw new InvalidCommandException("Invalid Command name entered") ;
        }
        
        if(cmds.length != noOfParamsAllowedInCommand){
            throw new TooManyOrTooFewArgumentsInCommandException("You have entered too many or too less fields in the Line command");
        }
        
        List<String> commandList = new ArrayList<String>(Arrays.asList(cmds));

        //first element in the command will be character. the remaining except the last command must be numbers
        numericValidate(commandList.subList(1, commandList.size()-2)) ;
        
     
    
}


}
