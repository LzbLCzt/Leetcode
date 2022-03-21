package Stack2;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcode227_3 {
    public static void main(String[] args) {
        
    }

    public int calculate(String s) {
        int n = s.length();
        Deque<Integer> stack = new ArrayDeque<>();
        char c;
        int i = 0;
        int flag = 1;   //标记位记录每个数字前面的符号：1 -> 正号， 2 -> 负号, 3 -> 乘号， 4 -> 除号

        while (i < n){
            c = s.charAt(i);
            if(c == '+'){
                flag = 1;
                i++;
            }else if(c == '-'){
                flag = 2;
                i++;
            }else if(c == '*'){
                flag = 3;
                i++;
            }else if (c == '/'){
                flag = 4;
                i++;
            }else if (c == ' '){
                i++;
            }else{  //处理数字
                int num = 0;
                while (i < n && Character.isDigit((c = s.charAt(i)))){
                    num = num * 10 + c - '0';
                    i++;
                }

                if(flag == 3){
                    stack.offerFirst(stack.pollFirst() * num);
                }else if (flag == 4){
                    stack.offerFirst(stack.pollFirst() / num);
                }else if (flag == 2){
                    stack.offerFirst(- num);
                }else{
                    stack.offerFirst(num);
                }
            }
        }

        int ans = 0;
        while (!stack.isEmpty()){
            ans += stack.pollFirst();
        }

        return ans;
    }
}
