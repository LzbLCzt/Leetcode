package Other;
/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcode461 {
    public static void main(String[] args) {
        leetcode461 leetcode461 = new leetcode461();
        int i = leetcode461.hammingDistance(1, 4);
        System.out.println(i);
    }

//    public int hammingDistance(int x, int y) {
//        int count = 0;
//        for (int i = 0; i < 32; i++) {
//            count += (((x >> i) & 1) != ((y >> i) & 1))? 1:0;
//        }
//
//        return count;
//    }

    public int hammingDistance(int x, int y) {
        int s = x ^ y, ret = 0;
        while (s != 0) {
            ret += s & 1;
            s >>= 1;
        }
        return ret;
    }
}
