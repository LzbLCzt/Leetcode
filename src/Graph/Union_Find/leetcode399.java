package Graph.Union_Find;

import java.util.HashMap;
import java.util.List;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcode399 {
    public static void main(String[] args) {
        
    }

    /*
    思路：使用并查集
        1  并查集维护一个weight[]，权值weight[i] = 当前节点i与父节点的比值；
        2. 并查集union时，需要：（1）连接两个根节点（2）重新结算两个根节点之间的weight
        3. 并查集find时，需要做“路径压缩”，使得每个节点的父节点就是该节点的根节点
        4. 每个节点是字母，不方便在并查集使用，维护一个hashmap映射字母和下标：'a' -> 0   'b' -> 1

     */
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int equationsSize = equations.size();

        // 第 1 步：预处理，将变量的值与 id 进行映射，使得并查集的底层使用数组实现，方便编码
        UnionFind2 unionFind = new UnionFind2(equationsSize * 2);
        HashMap<String, Integer> hashMap = new HashMap<>(2 * equationsSize);
        int id = 0;
        for (int i = 0; i < equationsSize; i++) {
            List<String> equation = equations.get(i);
            String var1 = equation.get(0);
            String var2 = equation.get(1);
            if(!hashMap.containsKey(var1)){
                hashMap.put(var1,id++);
            }
            if(!hashMap.containsKey(var2)){
                hashMap.put(var2,id++);
            }
            unionFind.union(hashMap.get(var1), hashMap.get(var2), values[i]);
        }


        //第 2 步：做查询
        int queriesSize = queries.size();
        double[] res = new double[queriesSize];
        for (int i = 0; i < queriesSize; i++) {
            String var1 = queries.get(i).get(0);
            String var2 = queries.get(i).get(1);

            Integer id1 = hashMap.get(var1);
            Integer id2 = hashMap.get(var2);

            if(id1 == null || id2 == null){
                res[i] = -1.0d;
            }else{
                res[i] = unionFind.isConnected(id1,id2);
            }
        }

        return res;
    }

    private class UnionFind2 {
        int[] parent;
        /**
         * 指向的父结点的权值
         */
        private double[] weight;
        public UnionFind2(int i) {
            this.parent = new int[i];
            this.weight = new double[i];
            for (int j = 0; j < i; j++) {
                parent[j] = j;
                weight[j] = 1.0d;
            }
        }

        /*
        并操作:
            1. 连接两个根节点
            2. 计算两个根节点之间的权值
         */
        public void union(Integer x, Integer y, double value) {
            int rootX = find(x);
            int rootY = find(y);
            if(rootX == rootY) return;

            parent[rootX] = rootY;
            weight[rootX] = weight[y] * value / weight[x];  //不懂的话去leetcode官方解答看图
        }
        /**
         * 路径压缩
         *
         * @param x
         * @return 根结点的 id
         */
        private int find(Integer x) {
            if(x != parent[x]){
                int origin = parent[x];
                parent[x] = find(parent[x]);    //路径压缩:利用了系统自带的递归栈
                weight[x] *= weight[origin];
            }
            return parent[x];
        }

        public double isConnected(Integer x, Integer y) {
            int rootX = find(x);
            int rootY = find(y);
            if(rootX == rootY){
                return weight[x] / weight[y];
            }else{
                return -1.0d;
            }
        }
    }
}
