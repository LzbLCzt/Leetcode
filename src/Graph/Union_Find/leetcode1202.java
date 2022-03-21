package Graph.Union_Find;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcode1202 {
    public static void main(String[] args) {
        String s = "dcab";
        ArrayList<List<Integer>> pairs = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(0);
        list1.add(3);
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(2);
        pairs.add(list1);
        pairs.add(list2);
        leetcode1202 leetcode1202 = new leetcode1202();
        System.out.println(leetcode1202.smallestStringWithSwaps(s, pairs));
    }
    /*
    方法：并查集
    核心思路：
        1. 维护一个映射关系
            维护一个HashMap<Integer, PriorityQueue<Character>>, key:记录每个连通分量的root，value：记录所有连通分量的元素

    具体步骤：
        1. 使用并查集划分连通分量
        2. 维护一个HashMap<Integer, PriorityQueue<Character>>, key:记录每个连通分量的root，value：记录所有连通分量的元素
        3. PriorityQueue<Character>字典序排序
        4. 维护一个StringBuilder，遍历s的每个字符，通过并查集找到root，再通过hashmap找到所属集合，pop出队列第一个元素假如StringBuilder
     */
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        if(pairs.size() == 0) return s;

        // 第 1 步：将任意交换的结点对输入并查集
        int len = s.length();
        UnionFind6 unionFind = new UnionFind6(len);
        for (List<Integer> pair : pairs) {
            Integer index1 = pair.get(0);
            Integer index2 = pair.get(1);
            unionFind.union(index1, index2);
        }

        //第 2 步：构建映射关系
        char[] charArray = s.toCharArray();
        //key：连通分量的root节点，value：同一个连通分量的字符集合（保存在一个优先队列中）
        HashMap<Integer, PriorityQueue<Character>> hashMap = new HashMap<>(len);
        for (int i = 0; i < len; i++) {
            int root = unionFind.find(i);
//            if(hashMap.containsKey(root)){
//                hashMap.get(root).offer(charArray[i]);
//            }else{
//                PriorityQueue<Character> queue = new PriorityQueue<>();
//                queue.offer(charArray[i]);
//                hashMap.put(root,queue);
//            }
            //以上刘行代码等价于下面这一行
            hashMap.computeIfAbsent(root,key -> new PriorityQueue<>()).offer(charArray[i]);
        }

        // 第 3 步：重组字符串
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            int root = unionFind.find(i);
            stringBuilder.append(hashMap.get(root).poll());
        }

        return stringBuilder.toString();
    }

    private class UnionFind6 {
        int[] parent;
        int[] rank;

        public UnionFind6(int len) {
            parent = new int[len];
            rank = new int[len];
            for (int i = 0; i < len; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        public void union(Integer x, Integer y) {
            int rootX = find(x);
            int rootY = find(y);
            if(rootX == rootY) return;

            if(rank[rootX] < rank[rootY]){
                parent[rootX] = rootY;
            }else if(rank[rootX] > rank[rootY]){
                parent[rootY] = rootX;
            }else{
                parent[rootX] = rootY;
                rank[rootY]++;
            }
        }

        private int find(Integer x) {
            if (x != parent[x]){
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
    }
}
