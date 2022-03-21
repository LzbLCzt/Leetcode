package myCode;

import java.util.HashMap;

/**
 * @author shkstart
 * @create 2021-03-22 15:30
 */
public class LRUCache {
    public int size;
    public HashMap<String, String> map;
    public LRUCache(int size) {
        this.size = size;
        map = new HashMap<>(size);
    }


}
