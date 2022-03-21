package TraceBack2;
import java.util.*;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcode52 {
    public static void main(String[] args) {
        leetcode52 leetcode52 = new leetcode52();
        int res = leetcode52.totalNQueens(1);
        System.out.println(res);
    }

    int ans;
    Set con1;
    Set con2;
    Set con3;
    public int totalNQueens(int n) {
        con1 = new HashSet<>();
        con2 = new HashSet<>();
        con3 = new HashSet<>();
        ans = 0;
        int[] queue = new int[n];
        Arrays.fill(queue, -1);
        backTrach(n, 0, queue);
        return ans;
    }

    private void backTrach(int total, int index, int[] queue) {
        if (index == total){
            ans++;
            return;
        }

        for (int i = 0; i < total; i++) {
            if (con1.contains(i) || con2.contains(index + i) || con3.contains(index - i)) continue;
            con1.add(i);
            con2.add(index + i);
            con3.add(index - i);
            queue[index] = i;
            backTrach(total, index + 1, queue);
            queue[index] = -1;
            con1.remove(i);
            con2.remove(index + i);
            con3.remove(index - i);
        }
    }

}
