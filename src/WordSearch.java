import java.util.ArrayList;
import java.util.List;
public class WordSearch {
	
	private static boolean isPathFound = false;
	public static void main(String[] args) {
		char[][] board = {{'A','B','C','E'},
						  {'S','F','C','S'},
						  {'A','D','E','E'}
		};
		String word = "ABCCED";
		boolean isFound = exist(board,word);
		if(isPathFound)
			System.out.println("path found");
		else
			System.out.println("no path found");
		
	}
	
	
    public static boolean exist(char[][] board, String word) {
     for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if((word.charAt(0) == board[i][j]) && search(board, word,i,j)){
                    return true;
                }
            }
        }
        
        return false;
    }
    
    private static boolean search(char[][] board, String word,int x,int y) {
			 findPath(board,word,x,y);
              return isPathFound;
	}
    
    public static void findPath(char[][] board, String word, int x, int y) {
			 List<int[]> path = new ArrayList<>() ;
			 findPath(board,word,path,x,y,0);
			 
	}
		private static void findPath(char[][] board, String word, List<int[]> path, int i, int j,int index) {
			if(path.size() == word.length()) {
				isPathFound = true;
				return;
			}
			
			int[] position = {i,j};
			if(positionAlreadyCovered(path,i,j)) {
				path.add(position);
				return ;
			}
			
			
			path.add(position);
			
			if(!isSafeSquare(board,word,i,j,index)) {
				return ;
			}
			
			if(!isPathFound) {
			findPath(board,word,path,i-1,j,index+1) ;
			}
			if(path.size() >= 1) {
			path.remove(path.size()-1);
			}
			
			if(!isPathFound) {
			findPath(board,word,path,i+1,j,index+1);
			}
			if(path.size() >= 1) {
				path.remove(path.size()-1);
			}
			
			if(!isPathFound) {
			findPath(board,word,path,i,j-1,index+1);
			}
			if(path.size() >= 1) {
				path.remove(path.size()-1);
			}
			
			if(!isPathFound) {
			findPath(board,word,path,i,j+1,index+1);
			}
			if(path.size() >= 1) {
				path.remove(path.size()-1);
			}
			
		}
		
		private static boolean positionAlreadyCovered(List<int[]> path, int x, int y) {
			for(int i=0 ;i < path.size() ; i++) {
				int[] position = path.get(i);
				if(position[0] == x && position[1] == y)
					return true;
			}
			return false;
		}
		private static boolean isSafeSquare(char[][] board, String word, int i, int j, int index) {
			if(i < 0 || i >=board.length || j < 0 || j >=board[0].length )
				return false;
			
			if(index >= word.length()) {
				return false;
			}
			
			if(board[i][j] != word.charAt(index))
				return false;
		
			return true;
		}

    
    
}