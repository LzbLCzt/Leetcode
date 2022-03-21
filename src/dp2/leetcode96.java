package dp2;

/**
 * @author shkstart
 * @create 2021-03-05 16:09
 */
public class leetcode96 {
    public static void main(String[] args) {

    }

//    public int numTrees(int n) {
//       if(n < 1) return 0;
//
//        int[] G = new int[n + 1];
//        G[0] = 1;
//        G[1] = 1;
//
//        for(int i = 2; i <= n; i++){
//            for(int j = 1; j <= i; j++){
//                G[i] += G[j-1] * G[i-j];
//            }
//        }
//
//        return G[n];
//    }

    public int numTrees(int n) {
        if (n == 1) return 1;
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }
}
