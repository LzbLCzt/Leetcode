package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
给一个二维数组{{1,2}, {1,3}, {4,5}, {3,6}, {6,10}, {7,8}};
    表示：1和2是朋友，1和3是朋友，那么1,2,3是一个圈子的人
要求：找出有多少个独立的圈子
算法：图的深度优先遍历
 */
public class GraphDemo {
    public static void main(String[] args) {
        int[][] arr =  {{1,2}, {1,3}, {4,5}, {3,6}, {6,10}, {7,8}, {9,7}};
        int n = 10;
        Graph2 graph = new Graph2(n);

        for(int[] x: arr){
            graph.insertVertex(x[0]-1, x[1]-1, 1);
        }

        graph.dfs();

        System.out.println(graph.ans);
    }
}

class Graph2 {
    List<Integer> vertex;
    int numOfVertex = 0;
    int[][] edges;
    boolean[] isVisited;
    Map<Integer, Integer> map;   //key：下标， value：vertex
    int ans = 0;

    public Graph2(int n){
        vertex = new ArrayList<>();
        edges = new int[n][n];
        map = new HashMap<>();
    }

    public void insertVertex(int x, int y, int weight){
        if(!vertex.contains(x)){
            map.put(numOfVertex++, x);
            vertex.add(x);
        }
        if(!vertex.contains(y)){
            map.put(numOfVertex++, y);
            vertex.add(y);
        }

        edges[x][y] = weight;
        edges[x][y] = weight;
    }

    public void dfs(){
        isVisited = new boolean[numOfVertex];
        for (int i = 0; i < numOfVertex; i++) {
            if(!isVisited[i]){
                ++ans;
                dfs(i);
            }
        }
    }

    private void dfs(int i) {
        System.out.println("节点" + (i+1) + "被访问");
        isVisited[i] = true;

        int w = getFirstNei(i);
        while (w != -1){
            if(!isVisited[w]){
                dfs(w);
            }
            w = getNextNei(i,w);
        }
    }

    private int getNextNei(int i, int w) {
        for (int j = w+1; j < edges[i].length; j++) {
            if(edges[i][j] != 0){
                return j;
            }
        }
        return -1;
    }

    private int getFirstNei(int i) {
        for (int j = 0; j < edges[i].length; j++) {
            if(edges[i][j] != 0){
                return j;
            }
        }
        return -1;
    }
}