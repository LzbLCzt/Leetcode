package Graph;

import java.util.*;

/**
 * @author shkstart
 * @create 2021-04-01 14:17
 */
public class leetcode210 {
    public static void main(String[] args) {
        leetcode210 leetcode210 = new leetcode210();
        int numCourses = 5;
        int[][] arr = {{2,1},{3,1},{1,4}};
        System.out.println(Arrays.toString(leetcode210.findOrder(numCourses, arr)));
    }

//    List<List<Integer>> edges;
//    int[] vertexs;
//    //bfs（广度优先遍历）
//    public int[] findOrder(int numCourses, int[][] prerequisites) {
//        //图、记录顶点需要的先修课程数、记录符合顶点个数、记录符合节点集合、存放符合顶点的一个队列
//        edges = new ArrayList<>();
//        vertexs = new int[numCourses];
//        int index = 0;
//        int[] ans = new int[numCourses];
//        LinkedList<Integer> queue = new LinkedList<>();
//
//        for (int i = 0; i < numCourses; i++) {
//            edges.add(new ArrayList<>());
//        }
//
//        //构造图，求每个课程需要的先修课数量
//        for(int[] x: prerequisites){
//            edges.get(x[1]).add(x[0]);
//            vertexs[x[0]]++;
//        }
//
//        for (int i = 0; i < vertexs.length; i++) {
//            if(vertexs[i] == 0) queue.offer(i);
//        }
//
//        while (!queue.isEmpty()){
//            Integer vertex = queue.poll();
//            ans[index++] = vertex;
//            for (Integer x : edges.get(vertex)) {
//                vertexs[x]--;
//                if(vertexs[x] == 0){
//                    queue.offer(x);
//                }
//            }
//        }
//
//        if(index < numCourses) return new int[0];
//        return ans;
//    }

    //dfs
    /*
    1.核心思想：
        同样采用记录节点状态：0,1,2分别表示节点未访问，访问中，未访问
         当一个节点深搜时，搜索到了状态 = 1的节点说明形成了环
    2. 题目要求返回一个拓扑排序，以数组的形式，这里需要用数组模拟栈：
            [0,1,2,3,4,5,......,n-1]
            数组末尾n-1表示栈底，栈底存放高级课程
            数组首部0表示栈顶，栈顶存在先修课程;
     */
    List<List<Integer>> edges;
    int[] visited;
    boolean flag;
    int index;
    int[] result;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<>();
        visited = new int[numCourses];
        flag = true;    //为false表示形成了环
        index = numCourses - 1;  //result的下标指针
        result = new int[numCourses];

        //1. 初始化图
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }

        //2. 构造图
        for (int[] x : prerequisites) {
            edges.get(x[1]).add(x[0]);
        }

        //3. dfs
        for (int i = 0; i < numCourses; i++) {
            if(visited[i] == 0){
                dfs(i);
            }
        }

        if(flag){
            return result;
        }else{
            return new int[0];
        }
    }

    private void dfs(int i) {
        visited[i] = 1;

        for (Integer u : edges.get(i)) {
            if(visited[u] == 0){
                dfs(u);

                if(!flag) return;
            }else if(visited[u] == 1){
                flag = false;
                return;
            }
        }

        visited[i] = 2;
        //*****注意顺序
        result[index--] = i;
    }
}


