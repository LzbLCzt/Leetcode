package Array;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcode74 {
    public static void main(String[] args) {
        int[][] arr = {{1, 3}};
        leetcode74 leetcode74 = new leetcode74();
        boolean ans = leetcode74.searchMatrix(arr,3);
        System.out.println(ans);
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int low = 0, high = m * n - 1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            int x = matrix[mid / n][mid % n];   //*****
            if (x < target) {
                low = mid + 1;
            } else if (x > target) {
                high = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }

}
