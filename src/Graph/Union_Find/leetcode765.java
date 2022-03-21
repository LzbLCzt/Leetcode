package Graph.Union_Find;

/**
 * @author shkstart
 * @create 2021-04-03 11:40
 */
public class leetcode765 {
    public static void main(String[] args) {

    }

    public int minSwapsCouples(int[] row) {
       if(row.length < 3) return 0;

       int len = row.length;
       int N = len / 2;
        UnionFind7 unionFind = new UnionFind7(N);

        for (int i = 0; i < len; i++) {
            unionFind.union(row[i] / 2, row[i+1] / 2);
        }

        return N - unionFind.getCount();
    }

    private class UnionFind7 {
        int[] parent;
        int count;

        public UnionFind7(int n) {
            parent = new int[n];
            count = n;
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if(rootX == rootY) return;

            parent[rootX] = rootY;
            count--;
        }

        private int find(int x) {
            if(x != parent[x]){
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public int getCount(){return count;}
    }
}


