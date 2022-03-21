package greedy_algorithm;

/**
 * @author shkstart
 * @create 2021-03-29 20:02
 */
public class leetcode1111 {
    public static void main(String[] args) {

    }

    //方法一：用栈进行括号匹配
    // 时间复杂度：O(n)O(n)，其中 nn 为字符串的长度。我们只需要遍历括号字符串一次。
    //空间复杂度：O(1)O(1)。除答案数组外，我们只需要常数个变量。
    public int[] maxDepthAfterSplit(String seq) {
        int n = seq.length();
        int[] ans = new int[n];
        int size = 0;   //用于记录栈中"("的个数

        for (int i = 0; i < n; i++) {
            if(seq.charAt(i) == '('){
                size++;
                ans[i] = size % 2 == 0? 1: 0;   //奇数分给A，偶数分给B
            }else{
                ans[i] = size % 2 == 0? 1: 0;
                size--;
            }
        }

        return ans;
    }
}
