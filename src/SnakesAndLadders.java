import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class SnakesAndLadders {
	private static Map<Integer,Integer> ladders = new HashMap<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    int[][] board1 = {{-1,-1,19,10,-1},{2,-1,-1,6,-1},{-1,17,-1,19,-1},{25,-1,20,-1,-1},{-1,-1,-1,-1,15}};
    int n = board1.length ;
    int[] board = simplifyBoard(board1);
    int count = findSmallest(board) ;
    System.out.println("No. of steps is : " + count);
    
	}

	private static int findSmallest(int[] board) {
		
		Queue<Integer> queue = new LinkedList<>();
		queue.add(1);
		Map<Integer,Integer> map = new HashMap<>();
		map.put(1,0);
		int target = board.length-1;
		boolean[] visited = new boolean[board.length];
		visited[1] = true;
		while(!queue.isEmpty()) {
		   Integer curr = queue.poll() ;
		   int currDistance = map.get(curr);
		   for(int i=1 ; i<=6 ;i++) {
			   int next = curr+i;
			   if(next <= target && board[next] != next) {
				   next = board[next];
			   }
			   
			   if(next == target) {
				   return currDistance + 1 ;
			   }
			   
			   if(next<target && !visited[next]) {
			   visited[next] = true;
			   queue.add(next);
			   map.put(next,currDistance+1);
			   
			   }
		   }
			
		}
			
		return -1;
	}
	

	private static int[] simplifyBoard(int[][] board1) {
		int n = board1.length ;
		int size = n*n;
		int[] board = new int[n*n + 1];
		int k = size  ;
		if(n % 2 == 0 ) {
		
			for(int i=0;i<n;i++) {
			if(i % 2 == 0) {
			for(int j=0;j<n;j++) {
				board[k--] = board1[i][j];
			}
			}
			else {
			 for(int j=n-1 ; j>=0 ; j--) {
				 board[k--] = board1[i][j];
			 }
			}
		}
		}
		else {
			for(int i=0;i<n;i++) {
				if(i % 2 == 1) {
				for(int j=0;j<n;j++) {
					board[k--] = board1[i][j];
				}
				}
				else {
				 for(int j=n-1 ; j>=0 ; j--) {
					 board[k--] = board1[i][j];
				 }
				}
			
		}
		
		
	}
		for(int i=1;i <= size ; i++) {
			if(board[i] == -1) {
			board[i] = i;
			
			}
			else {
				ladders.put(i,board[i]);
			}
		}
		
		
		return board;
	}}

