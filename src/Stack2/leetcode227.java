package Stack2;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcode227 {
    public static void main(String[] args) {
        
    }
    /*
    preSign 标记当前数字前面的符号位：+ or -
    使用栈存储数据，减法当做 + （-num）， 乘除法昨晚运算再入栈
     */
    public int calculate(String s) {
        int len = s.length();
        long num = 0;
        char preSign = '+';
        Deque<Long> stack = new ArrayDeque<>();

        for (int i = 0; i < len; i++) {
            if(Character.isDigit(s.charAt(i))){
                num = num * 10 + s.charAt(i) - '0';
            }
            //当i == len - 1时，表示已经访问到了最后一个元素，直接处理即可
            if(!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == len - 1){
                switch (preSign){
                    case '+':
                        stack.offerFirst(num);
                        break;
                    case '-':
                        stack.offerFirst(-num);
                    case '*':
                        long temp = stack.pollFirst() * num;
                        stack.offerFirst(temp);
                        break;
                    default:
                        temp = stack.pollFirst() / num;
                        stack.offerFirst(temp);
                }

                preSign = s.charAt(i);
                num = 0;
            }
        }

        int ans = 0;
        while (!stack.isEmpty()){
            ans += stack.pollFirst();
        }

        return ans;
    }
}
