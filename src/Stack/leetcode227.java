package Stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcode227 {
    public static void main(String[] args) {
        int res = new leetcode227().calculate("42");
        System.out.println(res);
    }

    /*
    思路：使用栈
        1. 栈中只存放数字，减法的数字用 -num表示
        2. 使用标记位preSign，记录当前数字前面是+还是-
        3. 遇到乘法、除法，直接将计算乘除后的值入栈
     */
    public int calculate(String s) {
        int len = s.length();
        int num = 0;
        char preSign = '+';
        Deque<Integer> stack = new LinkedList<>();

        for (int i = 0; i < len; i++) {
            if(Character.isDigit(s.charAt(i))){
                num = num * 10 + s.charAt(i) - '0';
            }

            if(!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == len - 1){
                switch (preSign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    default:
                        stack.push(stack.pop() / num);
                }
                preSign = s.charAt(i);
                num = 0;
            }
        }

        int ans = 0;
        while (!stack.isEmpty()){
            ans += stack.pop();
        }
        return ans;
    }
}
