package Stack2;


import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcode394 {
    public static void main(String[] args) {
        leetcode394 leetcode394 = new leetcode394();
        String res = leetcode394.decodeString("3[a]2[bc]");
        System.out.println(res);
    }

    int i;
    public String decodeString(String s) {
        int len = s.length();
        i = 0;
        ArrayDeque<String> s1 = new ArrayDeque<>();
        ArrayDeque<Integer> s2 = new ArrayDeque<>();
        while (i < len){
            char cur = s.charAt(i);
            if (Character.isDigit(cur)){
                 int num = getDigits(s);
                 s2.offerFirst(num);
            }else if (Character.isLetter(cur) || cur == '['){
                s1.offerFirst(String.valueOf(cur));
                i++;
            }else {
                i++;
                Deque<String> tmp = new ArrayDeque<>();
                while (!"[".equals(s1.peekFirst())){
                    tmp.offerFirst(s1.pollFirst());
                }
                s1.pollFirst();
                String str = getString(tmp);
                int t = s2.pollFirst();
                StringBuilder stringBuilder = new StringBuilder();
                while (t-- > 0){
                    stringBuilder.append(str);
                }
                s1.offerFirst(stringBuilder.toString());
            }
        }
        StringBuilder ans = new StringBuilder();
        while (!s1.isEmpty()){
            ans.append(s1.pollLast());
        }
        return ans.toString();
    }

    private String getString(Deque<String> tmp) {
        StringBuilder stringBuilder = new StringBuilder();
        while (!tmp.isEmpty()){
            stringBuilder.append(tmp.pollFirst());
        }
        return stringBuilder.toString();
    }

    private int getDigits(String s) {
        int ans = 0;
        while (Character.isDigit(s.charAt(i))){
            char c = s.charAt(i);
            ans = ans * 10 + Integer.parseInt(String.valueOf(c));
            i++;
        }
        return ans;
    }
}
