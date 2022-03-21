package Graph;

/**
 * @author shkstart
 * @create 2021-04-03 9:17
 */
public class leetcode785 {
    public static void main(String[] args) {
        int[][] graph = {{1,3}, {0,2}, {1,3}, {0,2}};
        leetcode785 leetcode785 = new leetcode785();
        System.out.println(leetcode785.isBipartite(graph));
    }

    /*
    思路：
        将判断二分图问题 转换为 图着色问题
        方法一：dfs
     */
    private static final int UNCOLORED = 0;
    private static final int RED = 1;
    private static final int GREEN = 2;
    int[] color;
    private boolean valid;

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        valid = true;
        color = new int[n];

        for (int i = 0; i < n; i++) {
            if(color[i] == UNCOLORED) dfs(i, RED, graph);
        }

        return valid;
    }

    private void dfs(int i, int c, int[][] graph) {
        color[i] = c;
        int nextColor = c == RED? GREEN: RED;
        for (int neighbor : graph[i]) {
            if(color[neighbor] == UNCOLORED){
                dfs(neighbor, nextColor, graph);
                if(!valid){
                    return;
                }
            }else if(color[neighbor] == c){
                valid = false;
                return;
            }
        }
    }

    //方法二bfs
//    private static final int UNCOLORED = 0;
//    private static final int RED = 1;
//    private static final int GREEN = 2;
//    int[] color;
//    private boolean valid;
//    Queue<Integer> queue;
//    public boolean isBipartite(int[][] graph) {
//        int n = graph.length;
//        color = new int[n];
//        valid = true;
//
//        //bfs
//        for (int i = 0; i < color.length && valid; i++) {
//            if(color[i] == UNCOLORED){
//                queue = new LinkedList<>();
//                queue.offer(i);
//                color[i] = RED;
//                bfs(graph, queue);
//            }
//        }
//
//        return valid;
//    }
//
//    private void bfs(int[][] graph, Queue<Integer> queue) {
//        while (!queue.isEmpty()){
//            int u = queue.poll();
//            int nextC = color[u] == RED? GREEN: RED;
//
//            for (int neighbor : graph[u]) {
//                if(color[neighbor] == UNCOLORED){
//                    color[neighbor] = nextC;
//                    queue.offer(neighbor);
//                }else if(color[neighbor] != nextC){
//                    valid = false;
//                    return;
//                }
//            }
//        }
//    }
}
