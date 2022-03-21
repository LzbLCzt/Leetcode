import utils.BuildTreeNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

/**
 * @author shkstart
 * @create 2021-08-19 10:53
 */
public class Test2 {
    public static void main(String[] args) throws IOException {
        Map<Integer, Integer> map = new LinkedHashMap<>(2);
        map.put(1,4);
        map.put(2,1);
        map.put(3,1);
        map.put(4,1);
        System.out.println(map.get(4));
        System.out.println(map.get(5));
    }

}
