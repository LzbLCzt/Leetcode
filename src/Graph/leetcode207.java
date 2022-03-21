package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author shkstart
 * @create 2021-03-31 22:58
 */
public class leetcode207 {
    public static void main(String[] args) {
        int[][] pre = {{1,0},{0,1}};
        int numCourses = 2;
        leetcode207 leetcode207 = new leetcode207();
        System.out.println(leetcode207.canFinish(numCourses, pre));
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(0);
        queue.add(2);
        queue.add(3);
        System.out.println(queue.pollLast());
    }

    //方法二: 广度优先搜索
    /*
    核心思想：
        记录每门课程需要的先修课程数量，如果 = 0了，说明该课程是“可修课程”
        维护一个队列去存放这些“可修课程”
     */
    //时间、空间复杂度: O(n+m),其中 n 为课程数，m 为先修课程的要求数。这其实就是对图进行广度优先搜索的时间复杂度。
    //n 和m 分别是有向图G 的节点数和边数
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //图
        List<List<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<Integer>());
        }
        //记录每门课需要的先修课数量
        int[] nums = new int[numCourses];
        //维护一个数值，记录有多少课程可以被选修
        int ans = 0;

        //1. 计算每个课程需要的先修课程数量,同时构建图
        for (int[] x : prerequisites) {
            edges.get(x[1]).add(x[0]);
            ++nums[x[0]];
        }

        //2. 维护一个队列，存放安全节点（当前可以修的课程）
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) queue.offer(i);
        }

        //3. 广度优先遍历
        int visited;    //记录当前被选修的课程
        while (!queue.isEmpty()){
            ans++;
            visited = queue.poll();
            for (Integer x : edges.get(visited)) {
                nums[x]--;
                if(nums[x] == 0) queue.offer(x);
            }
        }

        return ans == numCourses;
    }

    //方法一：dfs（深度优先遍历）
    /*
    1. 核心思想：判断是否是有环图，若有环 -> 返回false
        如何判断有无环？？？*****：
            记录每个节点（课程）的状态：0 -> 未访问  1 -> 访问中  2 -> 已访问
            如果一个节点深搜的过程中访问到了状态 = 1的节点 -> 说明从自己深搜又回到了自己，从而可以判定存在环，则不符合题目要求，返回false；
    2. 优化点：
            正常情况下，需要将可以选修的节点（课程）放入栈中（栈顶到顶底的顺序就会是拓扑排序），本题不需要拓扑排序，只需要判断是否存在环，因此
            不使用栈，用一个指针flag确定是否形成了环;
            如果要返回拓扑排序，就必须使用栈储存了
    3. 时间、空间复杂度: O(n+m),其中 n 为课程数，m 为先修课程的要求数。这其实就是对图进行广度优先搜索的时间复杂度。
            n 和m 分别是有向图G 的节点数和边数
     */

    List<List<Integer>> edges;  //图
    int[] visited;  //记录节点状态
    boolean valid = true;   //记录是否形成了环，为false表示形成了环
    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<>();
        //初始化图
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        visited = new int[numCourses];

        //构造图: 先行课程 指向 高级课程
        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]);
        }

        //dfs
        for (int i = 0; i < numCourses && valid; i++) {
            if(visited[i] == 0){
                dfs(i);
            }
        }

        return valid;
    }

    private void dfs(int i) {
        visited[i] = 1;

        for (int u : edges.get(i)) {
            if(visited[u] == 0){
                dfs(u);
                //必须加，否则存在闭环时，会陷入死循环
                if(!valid) return;

            }else if(visited[u] == 1){  //***说明形成了环
                valid = false;
                return;
            }
        }

        visited[i] = 2;
    }
}
