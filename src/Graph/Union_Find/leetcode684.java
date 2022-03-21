package Graph.Union_Find;

import java.util.Arrays;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcode684 {
    public static void main(String[] args) {
        leetcode684 leetcode684 = new leetcode684();
        int[][] edges = {{1,2}, {1,3}, {2,3}};
        int[] res = leetcode684.findRedundantConnection(edges);
        System.out.println(Arrays.toString(res));
    }

    /*
    方法：并查集
    核心思路：
        每次union两个节点时，判断两个节点是否已经属于同一个连通分量了，如果是，说明构成了环，返回两个节点即可；
     */
    public int[] findRedundantConnection(int[][] edges) {
        if(edges == null || edges.length == 0) return null;

        int n = edges.length;
        int[] ans = null;
        UnionFind6 unionFind = new UnionFind6(n);
        for (int i = 0; i < n; i++) {
            int var1 = edges[i][0];
            int var2 = edges[i][1];

            boolean isCircle = unionFind.union(var1 - 1, var2 - 1);
            if(isCircle) ans = edges[i];
        }

        return ans;
    }

    private class UnionFind6 {
        int[] parent;
        int[] rank;

        public UnionFind6(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if(rootX == rootY) return true;

            //优化：按秩合并
            if(rank[rootX] == rank[rootY]){
                parent[rootX] = rootY;
                rank[rootY]++;
            }else if(rank[rootX] < rank[rootY]) parent[rootX] = rootY;
            else parent[rootY] = rootX;

            return false;
        }

        private int find(int x) {
            //优化：路径压缩
            if(x != parent[x]){
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
    }
}
