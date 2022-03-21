package Graph.Union_Find;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcode200 {
    public static void main(String[] args) {
        char[][] grid = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        leetcode200 leetcode200 = new leetcode200();
        System.out.println(leetcode200.numIslands(grid));
    }
    //方法一：深度优先遍历
    public int numIslands2(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;

        int n = grid.length;
        int m = grid[0].length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(grid[i][j] == '1') {
                    dfs(grid, i, j);
                    ++ans;
                }
            }
        }
        return ans;
    }
    private void dfs(char[][] grid, int i, int j) {
        if(i < 0 || i > grid.length - 1 || j < 0 || j > grid[0].length - 1 || grid[i][j] == '0'){
            return;
        }

        //******搜索过了，标记为0，防止死循环
        grid[i][j] = '0';
        dfs(grid, i+1, j);
        dfs(grid, i-1, j);
        dfs(grid, i, j+1);
        dfs(grid, i, j-1);
    }

    //方法二：广度优先遍历

    //方法三：并查集
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int nr = grid.length;
        int nc = grid[0].length;
        MyUnionFind uf = new MyUnionFind(grid);
        for (int r = 0; r < nr; r++) {
            for (int c = 0; c < nc; c++) {
                if(grid[r][c] == '1'){
                    grid[r][c] = '0';
                    if (r - 1 >= 0 && grid[r-1][c] == '1') {
                        uf.union(r * nc + c, (r-1) * nc + c);
                    }
                    if (r + 1 < nr && grid[r+1][c] == '1') {
                        uf.union(r * nc + c, (r+1) * nc + c);
                    }
                    if (c - 1 >= 0 && grid[r][c-1] == '1') {
                        uf.union(r * nc + c, r * nc + c - 1);
                    }
                    if (c + 1 < nc && grid[r][c+1] == '1') {
                        uf.union(r * nc + c, r * nc + c + 1);
                    }

                }
            }
        }

        return uf.getCount();
    }
}
class MyUnionFind{
    int count;  //集合数量
    int[] parent;
    int[] rank; //计算每个节点作为根节点，对应的树的高度

    public MyUnionFind(char[][] edges){
        int n = edges.length;
        int m = edges[0].length;
        parent = new int[n * m];
        rank = new int[n * m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(edges[i][j] == '1'){
                    parent[i * m + j] = i * m + j;  //这里将二维数组的下标，转化为一维数组的下标
                    count++;    //初始化集合的个数 = 1的数量
                }
                rank[i * n + j] = 0;
            }
        }
    }

    public int find(int i){
        while (i != parent[i]){
            parent[i] = parent[parent[i]];
            i = parent[i];
        }
        return i;
    }

    public void union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);
        if(rootX == rootY) return;

        if (rank[rootX] < rank[rootY]){
            parent[rootX] = rootY;
        }else if(rank[rootY] < rank[rootX]){
            parent[rootY] = rootX;
        }else {
            parent[rootX] = rootY;
            rank[rootY]++;
        }
        --count;
    }

    public int getCount(){
        return count;
    }
}
