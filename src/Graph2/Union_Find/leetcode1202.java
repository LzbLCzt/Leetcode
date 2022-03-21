package Graph2.Union_Find;


import java.util.*;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcode1202 {
    public static void main(String[] args) {
        
    }

    Map<Integer, Queue<Character>> map;
    UnionFind8 unionFind;
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int len = s.length();
        //构建并查集
        unionFind = new UnionFind8(len);
        for (List<Integer> pair : pairs) {
            unionFind.union(pair.get(0), pair.get(1));
        }

        //构建hashmap，维护每个子集的root和该子集的全部元素
        map = new HashMap<>();
        char[] charArray = s.toCharArray();
        for (int i = 0; i < len; i++) {
            int root = unionFind.find(i);
            if(map.containsKey(root)){
                map.get(root).offer(charArray[i]);
            }else{
                Queue<Character> queue = new PriorityQueue<>();
                queue.offer(charArray[i]);
                map.put(root, queue);
            }
        }

        //用StringBuilder组合元素
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            int root = unionFind.find(i);
            Character var = map.get(root).remove();
            stringBuilder.append(var);
        }

        return stringBuilder.toString();
    }

    private class UnionFind8 {
        int[] parent;

        public UnionFind8(int n){
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public void union(Integer x, Integer y) {
            int rootX = find(x);
            int rootY = find(y);
            if(rootX == rootY) return;

            parent[rootX] = rootY;
        }

        private int find(Integer x) {
            if(x != parent[x]){
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
    }
}
