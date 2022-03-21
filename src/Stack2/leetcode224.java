package Stack2;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcode224 {
    public static void main(String[] args) {
        leetcode224 leetcode224 = new leetcode224();
        int ans = leetcode224.calculate("(1+(4+5+2)-3)+(6+8)");
        System.out.println(ans);
    }

    public int calculate(String s) {
        int n = s.length();
        char c;
        int ans = 0;
        char flag = '+';
        int i = 0;
        Deque<Character> stack = new ArrayDeque<>();
        stack.offerFirst(flag);

        while (i < n){
            if(s.charAt(i) == '+'){
                flag = stack.peekFirst();
                i++;
            }else if (s.charAt(i) == ' '){
                i++;
            } else if(s.charAt(i) == '-'){
                flag = stack.peekFirst() == '+'? '-': '+';
                i++;
            }else if(s.charAt(i) == '('){
                stack.offerFirst(flag);
                i++;
            }else if(s.charAt(i) == ')'){
                stack.pollFirst();
                i++;
            }else{  //处理数字
                int num = 0;
                while (i < n && Character.isDigit((c = s.charAt(i)))){
                    num = num * 10 + c - '0';
                    i++;
                }

                int sign = (flag == '+')? 1: -1;
                ans += sign * num;
            }
        }

        return ans;
    }
}
