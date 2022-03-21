package Stack;


import java.util.*;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcode20 {
    public static void main(String[] args) {
        leetcode20 leetcode20 = new leetcode20();
        boolean res = leetcode20.isValid("{[]}");
        System.out.println(res);
    }

    public boolean isValid(String s) {
        if (s.length() < 2){
            return false;
        }
        int n = s.length();
        LinkedList<Character> stack = new LinkedList<>();
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)){
                stack.offerFirst(c);
            }else {
                if (map.get(c) == stack.peekFirst()){
                    stack.pollFirst();
                }else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
