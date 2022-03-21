package Stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcode224 {
    public static void main(String[] args) {
        int res = new leetcode224().calculate("(1+(4+5+2)-3)+(6+8)");
        System.out.println(res);
    }

    /*
    思路：使用栈
        1. 栈记录当前元素的符号是 + 还是 -
     */
    public int calculate(String s) {
        int len = s.length();
        int i = 0;
        int sign = 1;
        Deque<Integer> stack = new ArrayDeque<>();  //维护当前元素的符号位：+ or -
        //***先将sign加入stack，因为默认是正数
        stack.offerFirst(sign);
        char c;
        int ans = 0;

        while (i < len){
            c = s.charAt(i);

            if(c == '('){
                stack.offerFirst(sign);
                i++;
            }else if (c == ')'){
                stack.pollFirst();
                i++;
            }else if (c == '+'){
                sign = stack.peekFirst();
                i++;
            } else if (c == '-') {
                sign = -1 * stack.peekFirst();
                i++;
            }else if (c == ' '){
                i++;
            }
            else{  //处理数字
                int temp = 0;
                while (i < len && Character.isDigit((c = s.charAt(i)))){
                    temp = temp * 10 + c - '0';
                    i++;
                }
                ans += sign * temp;
            }
        }

        return ans;
    }
}
