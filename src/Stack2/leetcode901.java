package Stack2;

import java.util.*;

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
/*
思路：维护一个index记录当前元素时第几个元素，维护一个栈记录每个元素对应其index（第几个位置），维护map记录每个index及相应元素
 */
class StockSpanner {

    Deque<Integer> stack;
    Map<Integer, Integer> map;  //k,v: 第i个元素的下标i，第i个元素
    int index;

    public StockSpanner() {
        stack = new ArrayDeque<>();
        map = new HashMap<>();
        index = 0;
    }

    public int next(int price) {
        int res = 0;
        if (index == 0){
            res = 1;
        }else {
            while (!stack.isEmpty() && price > map.get(stack.peekFirst())){
                stack.pollFirst();
            }
            res = stack.isEmpty()? index + 1: index - stack.peekFirst();
        }
        stack.offerFirst(index);
        map.put(index++, price);

        return res;
    }
}