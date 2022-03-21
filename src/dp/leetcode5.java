package dp;

/**
 * @author shkstart
 * @create 2021-03-05 16:09
 */
public class leetcode5 {
    public static void main(String[] args) {
        leetcode5 leetcode5 = new leetcode5();
        String ans = leetcode5.longestPalindrome("babad");
        System.out.println(ans);
    }

    public String longestPalindrome(String s) {
        int start = 0, len = Integer.MIN_VALUE;
        int n = s.length();
        char[] charArray = s.toCharArray();
        for (int i = 0; i < n * 2 - 1; i++) {
            int left = i / 2;
            int right = i / 2 + i % 2;
            while (left >= 0 && right < n && charArray[left] == charArray[right]){
                left--;
                right++;
            }
            if (right - left - 1 > len){
                start = left + 1;
                len = right - left - 1;
            }
        }

        return s.substring(start, start + len);
    }

}
