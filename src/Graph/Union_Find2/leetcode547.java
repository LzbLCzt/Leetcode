package Graph.Union_Find2;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcode547 {
    public static void main(String[] args) {
        int[][] isConnected = new int[][]{{1,1,0},{1,1,0},{0,0,1}};
        leetcode547 leetcode547 = new leetcode547();
        int ans = leetcode547.findCircleNum(isConnected);
        System.out.println(ans);
    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        UnionFind3 unionFind = new UnionFind3(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1){
                    unionFind.union(i,j);
                }
            }
        }

        return unionFind.getCount();
    }
}

class UnionFind3{
    int[] parent;
    int count;

    public UnionFind3(int n){
        count = n;
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if(rootX == rootY) return;

        count--;
        parent[rootX] = rootY;
    }

    private int find(int x) {
        while (x != parent[x]){
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return parent[x];
    }

    public int getCount(){
        return count;
    }
}