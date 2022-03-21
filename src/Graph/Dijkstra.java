package Graph;
import java.util.Arrays;

/**
使用Dijkstra算法：
    思想：通过bfs，通过一个辅助类，每次访问一个新的节点，更新三个数组，最终找到起始节点G到各个节点的最短距离;
 */
public class Dijkstra {
    public static void main(String[] args) {
        char[] vertex = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int[][] matrix = new int[vertex.length][vertex.length];
        final int N = 65535;    //表示两节点不连通
        matrix[0] = new int[]{N,5,7,N,N,N,2};
        matrix[1] = new int[]{5,N,N,9,N,N,3};
        matrix[2] = new int[]{7,N,N,N,8,N,N};
        matrix[3] = new int[]{N,9,N,N,N,4,N};
        matrix[4] = new int[]{N,N,8,N,N,5,4};
        matrix[5] = new int[]{N,N,N,4,5,N,6};
        matrix[6] = new int[]{2,3,N,N,4,6,N};
        Graph graph = new Graph(vertex, matrix);

        graph.showGraph();
        graph.dij(6);   //从节点G作为出发节点
        graph.showDijkstra();
    }

}

class Graph{
    private char[] vertex;  //顶点数组
    private int[][] matrix; //邻接矩阵
    private VisitedVertex vv;

    public Graph(char[] vertex, int[][] matrix){
        this.vertex = vertex;
        this.matrix = matrix;
    }

    public void dij(int index){
        vv = new VisitedVertex(vertex.length, index);

        update(index);  //更新节点index:表示访问过节点index后，pre_visited,dis数组的最新更新情况；

        for (int j = 1; j < vertex.length; j++) {
            index = vv.updateArr();  //选择新的访问节点
            update(index);
        }

    }

    //更新 起始节点G到各个周围顶点j的距离，以及更新周围顶点j的前驱节点
    private void update(int i){
        int dis = 0;
        for (int j = 0; j < matrix[i].length; j++) {
            dis = vv.getDis(i) + matrix[i][j];  //dis表示从出发节点G -> 到i -> 再到j 的距离
            //*********核心思想
            //      对比之前从G到j的距离， 和当前经过节点i后G到j的距离，取更小的一个；
            //       dis：指当前经过节点i后G到j的距离， vv.getDis(j)：指之前从G到j的距离；
            if(!vv.in(j) && dis < vv.getDis(j)) //!vv.in(j)可以不加（是一种优化）
            {
                vv.updatePre(j,i);
                vv.updateDis(j,dis);
            }
        }
    }

    public void showGraph(){
        for (int[] link : matrix) {
            System.out.println(Arrays.toString(link));
        }
    }

    public void showDijkstra(){
        vv.show();
    }
}

/*
用于dijkstra的辅助类
 */
class VisitedVertex{
    public int[] isVisited;   //1：记录访问过的节点， 0：未访问过
    public int[] pre_visited;   //记录前驱节点
    public int[] dis;       //记录出发节点(这里以G节点作为出发节点)到各个节点的最短距离（动态更新）

    public VisitedVertex(int length, int index){
        this.isVisited = new int[length];
        this.pre_visited = new int[length];
        this.dis = new int[length];
        //初始化dis数组
        Arrays.fill(dis, 65545);    //65545这个值可随意
        this.dis[index] = 0;
        this.isVisited[index] = 1;
    }

    //判断节点i是否被访问过；
    public boolean in(int i){
        return isVisited[i] == 1;
    }

    //更新出发节点到i节点的距离
    public void updateDis(int i, int len){
        dis[i] = len;
    }

    //更新顶点的前驱节点
    public void updatePre(int pre, int i){
        pre_visited[pre] = i;
    }

    //返回出发顶点到顶点i的距离；
    public int getDis(int i){
        return dis[i];
    }

    //继续选择一个新的访问节点index，例如之前访问过G节点后，选择节点A作为新的访问节点
        //如何选择访问节点：
            //1. 该节点未被访问过， 2. 该节点离G距离最近
    public int updateArr(){
        int min = 65535, index = 0;
        for (int i = 0; i < isVisited.length; i++) {
            if(isVisited[i] == 0 && dis[i] < min){
                min = dis[i];
                index = i;
            }
        }
        isVisited[index] = 1;
        return index;
    }

    //展示结果
    public void show(){
        System.out.println("==============");
        for (int i : isVisited) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i : pre_visited) {
            System.out.print(i + " ");
        }
        System.out.println("G到每个节点的距离是");
        System.out.println();
        char[] vertex = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int count = 0;
        for (int i : dis) {
            if(i != 65535){
                System.out.print(vertex[count] + "(" + i + ")");
            }else {
                System.out.println("N ");
            }
            ++count;
        }
        System.out.println();
    }
}