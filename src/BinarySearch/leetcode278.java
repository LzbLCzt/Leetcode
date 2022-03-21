package BinarySearch;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcode278 {
    public static void main(String[] args) {
        
    }

    //注意:由于n的范围偏大，计算mid时可能会溢出问题；
    public int firstBadVersion(int n) {
        int left = 1, right = n;
        while (left < right) { // *****循环直至区间左右端点相同
            int mid = left + (right - left) / 2; // 防止计算时溢出
            if (isBadVersion(mid)) {
                right = mid; // 答案在区间 [left, mid] 中
            } else {
                left = mid + 1; // 答案在区间 [mid+1, right] 中
            }
        }
        // 此时有 left == right，区间缩为一个点，即为答案
        return left;
    }

    public boolean isBadVersion(int i){
        return true;
    }
}
