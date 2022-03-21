package Window;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

//荣耀第二题
public class Solution2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = bf.readLine();
        String[] temp = str.substring(1, str.length() - 1).split(" ");
        int[] arr = new int[temp.length];
        boolean[] flag = new boolean[temp.length];  //符号变了就true
        for (int i = 0; i < temp.length; i++) {
            arr[i] = Integer.parseInt(temp[i]);
        }

        //大碓顶，谁的绝对值最大，就放在堆顶
        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int a = Math.abs(o1);
                int b = Math.abs(o2);
                return b - a;
            }
        });
        for (int num : arr) {
            heap.add(num);
        }
        System.out.println(heap.poll() * heap.poll());
    }
}