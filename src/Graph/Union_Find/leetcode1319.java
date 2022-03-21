package Graph.Union_Find;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcode1319 {
    public static void main(String[] args) {
    }

    /*
    方法一：并查集
        1. 如何确定能够全部计算机连通：节点数n，至少有n-1根线才能连通
        2. 并查集计算连通分量数x，则最少操作数 = x - 1；
     */
    public int makeConnected(int n, int[][] connections) {
        if(connections.length < n - 1) return -1;

        UnionFind5 unionFind = new UnionFind5(n);
        for (int i = 0; i < connections.length; i++) {
            int var1 = connections[i][0];
            int var2 = connections[i][1];
            unionFind.union(var1, var2);
        }

        return unionFind.getCount() - 1;
    }
}

class UnionFind5{
    int[] parent;
    int count;

    public UnionFind5(int n){
        parent = new int[n];
        count = n;
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int getCount(){
        return count;
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
}
