package TraceBack2;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcode79 {
    public static void main(String[] args) {
        leetcode79 leetcode79 = new leetcode79();
        boolean res = leetcode79.exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCCED");
//        boolean res = leetcode79.exist(new char[][]{{'A', 'B', 'C'}, {'S', 'F', 'C'}, {'A', 'D', 'E'}}, "ABC");
        System.out.println(res);
    }

    boolean[][] isVisited;
    public boolean exist(char[][] board, String word) {
        int n = board.length, m = board[0].length;
        if (word.length() > n * m) return false;
        isVisited = new boolean[n][m];

        boolean res = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res = backTrack(board, word.toCharArray(), i, j, 0);
                if (res){
                    return true;
                }
            }
        }
        return res;
    }

    private boolean backTrack(char[][] board, char[] strs, int i, int j, int index) {
        if (index >= strs.length){
            return true;
        }
        if (i < 0 || j < 0 || i > board.length - 1 || j > board[0].length - 1 || isVisited[i][j]){
            return false;
        }

        if (board[i][j] != strs[index]) return false;
        isVisited[i][j] = true;
        boolean flag = false;
        int[][] directions = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};
        for (int[] direction : directions) {
            int newI = i + direction[0];
            int newJ = j + direction[1];
            flag = backTrack(board, strs, newI, newJ, index + 1);
            if (flag) break;
        }
        isVisited[i][j] = false;
        return flag;
    }
}
