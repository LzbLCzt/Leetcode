package Graph2.Union_Find;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcode399 {
    public static void main(String[] args) {
        
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int len = equations.size();
        //map维护映射
        Map<String, Integer> map = new HashMap<>(len * 2);
        int i = 0;
        UnionFind unionFind = new UnionFind(len * 2);

        for (List<String> equation : equations) {
            String k1 = equation.get(0);
            String k2 = equation.get(1);
            if (!map.containsKey(k1)){
                map.put(k1, i++);
            }
            if (!map.containsKey(k2)){
                map.put(k2, i++);
            }
            unionFind.union(map.get(k1), map.get(k2), values[i]);
        }

        int size = queries.size();
        double[] res = new double[size];
        for (int j = 0; j < size; j++) {
            String var1 = queries.get(j).get(0);
            String var2 = queries.get(j).get(1);

            Integer id1 = map.getOrDefault(var1,0);
            Integer id2 = map.getOrDefault(var2,0);

            if (id1 == null || id2 == null){
                res[i] = -1.0d;
            }else {
                res[i] = unionFind.isConnected(id1,id2);
            }
        }

        return res;
    }

    private class UnionFind{

        int[] parent;
        double[] weight;
        int count;

        public UnionFind(int n){
            parent = new int[n];
            weight = new double[n];
            count = n;
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                weight[i] = 1.0;
            }
        }

        private int find(int x){
            while (x != parent[x]){
                int b = parent[x];
                parent[x] = parent[parent[x]];
                weight[x] *= weight[b];
                x = parent[x];
            }
            return parent[x];
        }

        private void union(int x, int y, double value){
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY){
                return;
            }

            parent[rootX] = rootY;
            weight[rootX] = weight[y] / weight[x] * value;
            count--;
        }

        private double isConnected(int x, int y){
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY){
                return weight[x] / weight[y];
            }else {
                return -1.0d;
            }
        }
    }
}
