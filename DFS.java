import java.util.*;
public class Main{
    private static void dfs(int[][] grid, int i, int j, int n, int m){
        if(i < 0 || j < 0 || i == n || j == m || grid[i][j] == 0)
            return;
        grid[i][j] = 0;
        dfs(grid, i - 1, j, n, m);
        dfs(grid, i + 1, j, n, m);
        dfs(grid, i, j - 1, n, m);
        dfs(grid, i, j + 1, n, m);
    }
	public static void main(String[] args) {
	    Scanner s = new Scanner(System.in);
	    int[][] grid = {
          {1,1,0,0,0},
          {1,1,0,0,0},
          {0,0,1,0,0},
          {0,0,0,1,1}
	    };
	    int n = grid.length;
	    int m = grid[0].length;
	    int ans = 0;
	    for(int i = 0 ; i < n ; i++){
	        for(int j = 0 ; j < m ; j++){
	            if(grid[i][j] == 1){
	                ans++;
	                dfs(grid, i, j, n, m);
	            }
	        }
	    }
	   System.out.print(ans);
	}
}

