package doublePointer2;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcode11 {
    public static void main(String[] args) {
        leetcode11 leetcode11 = new leetcode11();
        int ans = leetcode11.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
        System.out.println(ans);
    }

    public int maxArea(int[] height) {
        int n = height.length;
        int l = 0, r = n - 1;
        int area = 0;
        while (l < r){
            int high = Math.min(height[l], height[r]);
            int width = r - l;
            area = Math.max(area, high * width);
            if (height[l] < height[r]){
                l++;
            }else {
                r--;
            }
        }
        return area;
    }
}
