package myCode;

/**
 * @author shkstart
 * @create 2021-03-05 16:09
 */
public class leetcode1689 {
    public static void main(String[] args) {
        int a = 'a';
        System.out.println(a);

    }

//    public int minPartitions(String n) {
//        if(n.length() == 0) return 0;
//        char ans = '0';
//        for(int i = 0; i < n.length(); i++){
//            if(n.charAt(i) > ans) ans = n.charAt(i);
//        }
//
//        return ans - '0';
//    }

    public int minPartitions(String n) {
        if(n.length() < 1) return 0;

        int ans = n.charAt(0);
        for (int i = 1; i < n.length(); i++) {
            ans = Math.max(n.charAt(i),ans);
        }

        return ans - '0';
    }
}
