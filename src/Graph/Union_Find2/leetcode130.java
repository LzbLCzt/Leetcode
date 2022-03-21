package Graph.Union_Find2;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcode130 {
    public static void main(String[] args) {
        
    }

    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        for (int i = 0; i < n; i++) {
            if (board[i][0] == 'O'){
                dfs(board, i, 0);
            }
            if (board[i][m-1] == 'O'){
                dfs(board,i,m-1);
            }
        }
        for (int i = 1; i < m; i++) {
            if (board[0][i] == 'O'){
                dfs(board,0,i);
            }
            if (board[n-1][i] == 'O'){
                dfs(board,n-1,i);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'A'){
                    board[i][j] = 'O';
                }else if (board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i > board.length - 1 || j > board[0].length - 1 || board[i][j] != 'O'){
            return;
        }

        board[i][j] = 'A';
        dfs(board, i+1, j);
        dfs(board, i-1, j);
        dfs(board, i, j+1);
        dfs(board, i, j-1);
    }

}
