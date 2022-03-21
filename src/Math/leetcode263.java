package Math;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcode263 {
    public static void main(String[] args) {
        leetcode263 leetcode263 = new leetcode263();
        System.out.println(leetcode263.isUgly(1332185066));
    }

    public boolean isUgly(int n) {
       if(n <= 0) return false;

       int[] factors = {2,3,5};
        for (int factor : factors) {
            while (n % factor == 0){
                n /= factor;
            }
        }

        return n == 1;
    }
}
