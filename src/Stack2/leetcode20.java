package Stack2;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcode20 {
    public static void main(String[] args) {
        leetcode20 leetcode20 = new leetcode20();
        boolean res = leetcode20.isValid(")");
        System.out.println(res);
    }

    public boolean isValid(String s) {
        int n = s.length();
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) {
                stack.offerFirst(c);
            }else {
                if (stack.isEmpty() || map.get(c) != stack.peekFirst()){
                    return false;
                }
                stack.pollFirst();
            }
        }
        return stack.isEmpty();
    }
}
