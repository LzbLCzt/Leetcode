package doublePointer;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcode11 {
    public static void main(String[] args) {
        
    }

    public int maxArea(int[] height) {
        int n = height.length;
        if(n < 2) return 0;

        int l = 0;
        int r = n - 1;
        int ans = 0;
        while (l < r){
            int area = Math.min(height[l], height[r]) * (r - l);
            ans = Math.max(ans, area);
            if(height[l] < height[r]) ++l;
            else --r;
        }
        return ans;
    }
}
