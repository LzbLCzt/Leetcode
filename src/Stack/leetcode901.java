package Stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcode901 {
    public static void main(String[] args) {
        StockSpanner stockSpanner = new StockSpanner();
        System.out.println(stockSpanner.next(100));
        System.out.println(stockSpanner.next(80));
        System.out.println(stockSpanner.next(60));
        System.out.println(stockSpanner.next(70));
        System.out.println(stockSpanner.next(60));
        System.out.println(stockSpanner.next(75));
        System.out.println(stockSpanner.next(85));
    }
}

class StockSpanner {
    Map<Integer, Integer> map;  //维护下标和股价的映射
    int index;
    Deque<Integer> stack;
    public StockSpanner() {
        map = new HashMap<>();
        stack = new ArrayDeque<>();
        index = 0;
    }

    public int next(int price) {

        while (!stack.isEmpty() && price >= map.get(stack.peekFirst())){
            stack.pollFirst();
        }
        int ans = stack.isEmpty()? index + 1: index - stack.peekFirst();

        map.put(index, price);
        stack.offerFirst(index);
        ++index;

        return ans;
    }
}