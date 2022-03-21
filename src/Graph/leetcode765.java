package Graph;

/**
 * @author shkstart
 * @create 2021-04-03 11:40
 */
public class leetcode765 {
    public static void main(String[] args) {
        leetcode765 leetcode765 = new leetcode765();
        int[] arr = {0,2,1,3};
        System.out.println(leetcode765.minSwapsCouples(arr));
    }

    /*
    思路：
        1.使用并查集
        2.***交换之后连通分量个数 - 交换之前连通分量个数 = 最少交换次数
     */
    public int minSwapsCouples(int[] row) {
        int len = row.length;
        int N = len / 2;    //交换之后连通分量个数:每一对情侣应该作为一个独立的集合（分量）
        UnionFind unionFind = new UnionFind(N);
        for (int i = 0; i < len; i += 2) {
            unionFind.union(row[i] / 2, row[i+1] / 2);  //***这里应该将一对情侣作为一个节点来处理
        }

        return N - unionFind.getCount();
    }
}

//并查集
class UnionFind{
    int[] parent;
    int count;  //****用于计算交换之前连通分量个数

    public UnionFind(int n){
        this.count = n;
        this.parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;  //自己的父节点就是自己
        }
    }

    //查找当前节点的根节点，并做压缩路径的优化操作
    public int findRoot(int x){
        while (x != parent[x]){
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    //合并两个节点所在集合
    public void union(int x, int y){
        int rootX = findRoot(x);
        int rootY = findRoot(y);

        if(rootX == rootY) return;  //以为着节点x，y在一个集合

        parent[rootX] = rootY;
        --count;
    }

    public int getCount(){
        return count;
    }
}


