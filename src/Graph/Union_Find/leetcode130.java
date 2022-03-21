package Graph.Union_Find;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcode130 {
    public static void main(String[] args) {
        
    }

    public void solve(char[][] board) {
        if(board == null || board.length == 0) return;

        int n = board.length;
        int m = board[0].length;
        boolean[][] isVisited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
           dfs(board, i, 0);
           dfs(board, i, m - 1);
        }

        for (int j = 1; j < m - 1; j++) {
            dfs(board, 0, j);
            dfs(board, n - 1, j);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(board[i][j] == 'A'){
                    board[i][j] = 'O';
                }else if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j) {
        if(i < 0 || j < 0 || i > board.length - 1 || j > board[0].length - 1 || board[i][j] != 'O') return;

        board[i][j] = 'A';  //将当前标记为A，避免死循环递归，后面再转换回'O'
        dfs(board, i+1, j);
        dfs(board, i-1, j);
        dfs(board, i , j+1);
        dfs(board, i , j-1);
    }

}
