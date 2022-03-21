package Stack2;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcode316 {
    public static void main(String[] args) {
        String s = "cbacdcbc";
        String ans = new leetcode316().removeDuplicateLetters(s);
        System.out.println(ans);

    }

    /*
    方法：单调栈 + 贪心算法
    思路：
        1. 使用栈维护题目要求的不重复字符、字典序最小的元素
        2. ****当添加一个元素i时，若栈顶元素a比i大，且元素a在后续还会出现，则弹出a，这是一个循环过程，使用while
            2.2 如何判断元素a是否在后续会再出现：维护数组lastIndex记录每个字符最后一次出现的下标
        3. 根据贪心算法，如果一个元素在stack已经存在了，即使后续此元素又来了一个，也不 再做处理,用数组isVisited维护栈中已经确定的元素
        4. 最后栈中保留的元素就是题目要求的，且栈底元素时返回的字符串的头部；
     */
    public String removeDuplicateLetters(String s) {
        int n = s.length();
        if (n < 2) return s;

        char[] chars = s.toCharArray();
        int[] lastIndexOfElement = new int[26];
        boolean[] isVisited = new boolean[26];
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            lastIndexOfElement[chars[i] - 'a'] = i;
        }

        for (int i = 0; i < n; i++) {
            if (isVisited[chars[i] - 'a']){
                continue;
            }
            while (!stack.isEmpty() && stack.peekFirst() > chars[i] && i < lastIndexOfElement[stack.peekFirst() - 'a']){
                char top = stack.pollFirst();
                isVisited[top - 'a'] = false;
            }
            stack.offerFirst(chars[i]);
            isVisited[chars[i] - 'a'] = true;
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()){
            stringBuilder.append(stack.pollLast());
        }

        return stringBuilder.toString();
    }
}
