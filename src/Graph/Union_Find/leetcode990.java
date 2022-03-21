package Graph.Union_Find;//package Graph.Union_Find;
//
///**
// * @author shkstart
// * @create 2021-04-01 22:41
// */
//public class leetcode990 {
//    public static void main(String[] args) {
//
//    }
//
//    public boolean equationsPossible(String[] equations) {
//        int n = equations.length;
//        UnionFind2 unionFind = new UnionFind2(26);  //对应26个英文字符 'a' -> 0  'z' -> 26
//
//        for (int i = 0; i < n; i++) {
//            if(equations[i].charAt(1) == '='){
//                int x = equations[i].charAt(0) - 'a';
//                int y = equations[i].charAt(3) - 'a';
//
//                unionFind.union(x,y);
//            }
//        }
//
//        for (int i = 0; i < n; i++) {
//            if(equations[i].charAt(1) == '!'){
//                int x = equations[i].charAt(0) - 'a';
//                int y = equations[i].charAt(3) - 'a';
//                if(!unionFind.judge(x,y)){
//                    return false;
//                }
//            }
//        }
//        return true;
//    }
//}
//
//class UnionFind2{
//    int[] parent;
//
//    public UnionFind2(int n){
//        parent = new int[n];
//        for (int i = 0; i < n; i++) {
//            parent[i] = i;
//        }
//    }
//
//    public int find(int x){
//        if(x != parent[x]){
//            parent[x] = find(parent[x]);
//        }
//        return parent[x];
//    }
//
//    public void union(int x, int y){
//        int rootX = find(x);
//        int rootY = find(y);
//
//        parent[rootX] = rootY;
//    }
//}