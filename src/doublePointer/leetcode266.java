package doublePointer;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcode266 {
    public static void main(String[] args) {
        leetcode266 leetcode266 = new leetcode266();
        boolean ans = leetcode266.canPermutePalindrome("carerac");
        System.out.println(ans);
    }
    //O(n),O(1)
    public boolean canPermutePalindrome(String s) {
        int n = s.length();
        int[] arr = new int[26];    //字母出现奇数次 记作1，偶数次记作0
        for (int i = 0; i < n; i++) {
            int index = s.charAt(i) - 'a';
            arr[index] = arr[index] == 0? 1: 0;
        }
        int numOfOdd = 0;   //统计奇数次数字母的个数
        for (int x : arr) {
            numOfOdd += x;
        }
        return numOfOdd <= 1;
    }
}
