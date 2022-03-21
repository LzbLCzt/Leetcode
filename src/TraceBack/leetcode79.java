package TraceBack;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcode79 {
    public static void main(String[] args) {
        
    }

    boolean[][] isVisited;
    public boolean exist(char[][] board, String word) {
        int n = board.length, m = board[0].length;
        isVisited = new boolean[n][m];
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                flag = dfs(board, i, j, word, 0);
                if (flag){
                    return true;
                }
            }
        }
        return false;
    }

    /*
    index:word的下标
     */
    private boolean dfs(char[][] board, int i, int j, String word, int index) {
        if (i < 0 || j < 0 || i > board.length - 1 || j > board[0].length -1 || isVisited[i][j] || board[i][j] != word.charAt(index)){
            return false;
        }
        if (index == word.length() - 1) {
            return true;
        }

        //递归向上下左右走
        boolean flag = false;
        isVisited[i][j] = true;
        int[][] directions = new int[][]{{0,1}, {0,-1},{1,0}, {-1,0}};
        for (int[] direction : directions) {
            int newI = i + direction[0], newJ = j + direction[1];
            flag = dfs(board, newI, newJ, word, index + 1);
            if (flag) {
                break;
            }
        }
        isVisited[i][j] =false;
        return flag;
    }
}
