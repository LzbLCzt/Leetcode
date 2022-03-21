package Graph.Union_Find;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcode547 {
    public static void main(String[] args) {
        
    }

    public int findCircleNum(int[][] isConnected) {
        if(isConnected == null || isConnected.length == 0) return 0;

        int n = isConnected.length;
        int m = isConnected[0].length;
        UnionFind3 unionFind = new UnionFind3(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(isConnected[i][j] == 1){
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
        if(x != parent[x]){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public int getCount(){
        return count;
    }
}