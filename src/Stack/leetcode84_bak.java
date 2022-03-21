package Stack;

/**
单调栈
 */
public class leetcode84_bak {
    public static void main(String[] args) {
        leetcode84_bak leetcode84 = new leetcode84_bak();
        int[] heights = {2,1,2};
        System.out.println(leetcode84.largestRectangleArea(heights));
    }

    /*
    暴力解法：遍历每个柱子，对当前柱子i，分别向左右扩散寻找柱子（此柱子必须包含当前柱子i）
        当前柱子高度 = heights[i],向左右扩散时，遇到heights[j] < heights[i]则停止，长度 = i - j;
     */
    public int largestRectangleArea(int[] heights) {
        int ans = 0;
        int n = heights.length;
        for (int i = 0; i < n; i++) {
            int sLeft = left(heights,i);
            int sRight = right(heights,i);
            int sLAndR = sLeft + sRight - heights[i];
            ans = Math.max(ans, sLAndR);
        }

        return ans;
    }

    private int right(int[] heights, int i) {
        int height = heights[i];
        int len = heights.length - i;   //先假设当前柱子i的高度就是最小的
        //确定长度len
//        boolean flag = false;    //为false表示始终未找到符合heights[j] < height的
        for (int j = i; j < heights.length; j++) {
            if(heights[j] < height){
                len = j - i;
                break;
            }
        }
       return height * len;
    }

    private int left(int[] heights, int i) {
        int height = heights[i];
        int len = i + 1;
        //确定长度len
        for (int j = i; j >= 0; j--) {
            if(heights[j] < height){
                len = i - j;
                break;
            }
        }

        return height * len;
    }
}
