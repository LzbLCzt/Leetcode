package greedy_algorithm;

/**
 * @author shkstart
 * @create 2021-03-29 20:02
 */
public class leetcode1725 {
    public static void main(String[] args) {

    }

    public int countGoodRectangles(int[][] rectangles) {
        int maxLen = 0;
        int ans = 0;

        for (int i = 0; i < rectangles.length; i++) {
            int[] temp = rectangles[i];

            int max = Math.min(temp[0], temp[1]);
            if(maxLen < max){
                maxLen = max;
                ans = 1;
            }else if(maxLen == max) ans++;
        }

        return ans;
    }
}
