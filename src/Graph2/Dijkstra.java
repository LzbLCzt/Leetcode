package Graph2;

import java.util.Arrays;

/**
 * @author shkstart
 * @create 2021-04-04 9:08
 */
public class Dijkstra {
    public static void main(String[] args) {

    }
}
class Graph{
    int[][] edges;
    char[] vertex;
    int len;
    VisitedVertex vv;

    public Graph(int[][] edges, char[] vertex){
        this.edges = edges;
        this.vertex = vertex;
        len = vertex.length;
    }

    public void dijkstra(int index){    //传入出发顶点
        vv = new VisitedVertex(index, len);
        update(index);

        for (int i = 1; i < len; i++) {
            index = updateArr();
            update(index);
        }
    }

    private int updateArr() {
        int minDis = Integer.MAX_VALUE;
        int index = 0;
        for (int i = 0; i < len; i++) {
            if(!vv.isVisited[i] && minDis > vv.getDis(i)){
                minDis = vv.getDis(i);
                index = i;
            }
        }
        return index;
    }

    private void update(int index) {
        int dis = 0;
        for (int j = 0; j < edges[index].length; j++) {
            dis = vv.getDis(index) + edges[index][j];

            if(dis < vv.getDis(j)){
                vv.setDis(j, dis);
                vv.setPre(j, index);
            }
        }
    }
}

class VisitedVertex{
    int[] dis;
    int[] pre_vertex;
    boolean[] isVisited;

    public VisitedVertex(int i, int n){
        dis = new int[n];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[i] = 0;

        pre_vertex = new int[n];
        pre_vertex[i] = i;
        isVisited[i] = true;
    }

    public int getDis(int index) {
        return dis[index];
    }

    public void setDis(int j, int distance) {
        dis[j] = distance;
    }

    public void setPre(int j, int index) {
        pre_vertex[j] = index;
    }
}