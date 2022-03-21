package Graph.Union_Find2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author shkstart
 * @create 2021-07-20 22:33
 */
public class UnionFind {
    public static void main(String[] args) {
        List<char[]> data = new ArrayList<>();
        data.add(new char[]{'a','b'});
        data.add(new char[]{'b','c'});
        data.add(new char[]{'e','n'});
        data.add(new char[]{'e','n'});
        data.add(new char[]{'a','h'});
        data.add(new char[]{'r','n'});
        data.add(new char[]{'o','b'});
        data.add(new char[]{'o', 'x'});

        int i = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (char[] arr : data) {
            char x = arr[0];
            char y = arr[1];
            if (!map.containsKey(x)){
                map.put(x, i++);
            }
            if (!map.containsKey(y)) {
                map.put(y,i++);
            }
        }
        for(Map.Entry<Character, Integer> entry: map.entrySet()){
            System.out.println(entry.getKey() + "   " + entry.getValue());
        }

        UnionFind unionFind = new UnionFind(map.size());
        for (char[] x : data) {
            unionFind.union(map.get(x[0]), map.get(x[1]));
        }
        System.out.println(unionFind.count);
    }

    int[] parent;
    int count;

    public UnionFind(int n){
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        count = n;
    }

    public int find(int x){
        while (x != parent[x]){
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return parent[x];
    }

    public void union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            parent[rootX] = rootY;
            count--;
        }
    }
}
