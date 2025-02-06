import java.util.*;
public class Main{
    private static void print(char[][] board, int n){
        for(int i = 0 ; i < n ; i++, System.out.println())
            for(int j = 0 ; j < n ; j++)
                System.out.print(board[i][j] + " ");
        System.out.println();
    }
    private static boolean isSafe(char[][] board, int row, int col, int n){
        for(int i = row ; i >= 0 ; i--)
            if(board[i][col] == 'Q')
                return false;
    
        for(int i = row, j = col ; i >= 0 && j >= 0 ; i--, j--)
            if(board[i][j] == 'Q')
                return false;
        
        for(int i = row, j = col ; i >= 0 && j < n ; i--, j++)
            if(board[i][j] == 'Q')
                return false;
                
        return true;
    }
    private static boolean dfs(char[][] board, int row, int n) {
        if(row == n)
            return true;
        for(int col = 0 ; col < n ; col++){
            if(isSafe(board, row, col, n)){
                board[row][col] = 'Q';
                if(dfs(board, row + 1, n))
                    return true;
                board[row][col] = '.';
            }
        }
        return false;
    }
	public static void main(String[] args) {
	    Scanner s = new Scanner(System.in);
	    int n = s.nextInt();
	    char[][] board = new char[n][n];
	    for(char[] row : board)
	        Arrays.fill(row, '.');
	    if(dfs(board, 0, n))
	        print(board, n);
	    else
	        System.out.print("No Solution :( ");
	}
}
