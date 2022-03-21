package Graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author shkstart
 * @create 2021-04-03 19:37
 */
public class leetcode1631 {
    public static void main(String[] args) {
    }

   /*
   方法一：并查集
        1. 将给定的二维数组heights中每个heights[i][j]看做一个节点
            1.2 n * m个节点构成一个图，边的权值 = 节点间的高度差值的绝对值
            1.3 但是并不需要用一个（n*m） * （n*m）的二维数组维护这个图，只需要用一个一维的arraylist即可；
            1.4 edges中的一个元素记录的是 i，j两个节点以及之间的高度差绝对值
        2. 由于我们需要找到从左上角到右下角的最短路径，因此我们可以将edges中的所有元素按照权值从小到大进行排序，
            并依次加入并查集中。当我们加入一个元素之后，如果左上角和右下角从非连通状态变为连通状态，那么 xx 即为答案
        3.
    */
    int ans;
    public int minimumEffortPath(int[][] heights) {
        if(heights == null || heights.length == 0) return 0;

        ans = 0;
        int n = heights.length;
        int m = heights[0].length;
        List<int[]> edges = new ArrayList<>();  //使用一个集合储存两个节点之间的距离

        //1. 计算节点距离放入edges
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int id = i * m + j;
                if(i > 0) edges.add(new int[]{id - m, id, Math.abs(heights[i][j] - heights[i - 1][j])});
                if(j > 0) edges.add(new int[]{id - 1, id, Math.abs(heights[i][j] - heights[i][j - 1])});
            }
        }

        //2. 按照节点距离给edges升序排序
        Collections.sort(edges, (o1, o2) -> {
            return o1[2] - o2[2];
        });

        //3. 初始化并查集
        UnionFind4 unionFind = new UnionFind4(n * m);
        for (int[] edge : edges) {
            int v = edge[2];
            int x = edge[0];
            int y = edge[1];
            unionFind.union(x,y);
            if(unionFind.isConnected(0,n * m - 1)){
                ans = v;
                break;
            }
        }

        return ans;
    }
}

class UnionFind4{
    int[] parent;

    public UnionFind4(int n){
        this.parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }


    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if(rootX == rootY) return;

        parent[rootX] = rootY;
    }

    private int find(int x) {
        if(x != parent[x]){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }
}
