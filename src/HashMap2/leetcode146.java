package HashMap2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shkstart
 * @create 2021-07-15 9:51
 */
public class leetcode146 {
    public static void main(String[] args) {
        LRUCache l = new LRUCache(2);
        l.put(2,1);
        l.put(2,2);
        l.get(2);
        l.put(1,1);
        l.put(4,1);
        System.out.println(l.get(2));
    }

}

class Node{
    int key;
    int value;
    Node pre;
    Node next;
    public Node(int key, int value){
        this.key = key;
        this.value = value;
        pre = null;
        next = null;
    }
}

class LRUCache {

    int capacity;
    int size;
    Node dummyHead;
    Node dummyTail;
    Map<Integer, Node> cache;

    public LRUCache(int capacity) {
        this.cache = new HashMap<>();
        this.size = 0;
        this.capacity = capacity;
        dummyHead = new Node(0,0);
        dummyTail = new Node(0,0);
        dummyTail.pre = dummyHead;
        dummyHead.next = dummyTail;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) return -1;
        Node node = cache.get(key);
        removeNode(node);
        insertToHead(node);
        return node.value;
    }

    private void insertToHead(Node node) {
        Node next = dummyHead.next;
        dummyHead.next = node;
        node.pre = dummyHead;
        node.next = next;
        next.pre = node;
    }

    private void removeNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }


    public void put(int key, int value) {
        if (cache.containsKey(key)){
            Node node = cache.get(key);
            node.value = value; //这样就已经更新了cache中的元素
            //更新链表
            removeNode(node);
            insertToHead(node);
        }else {
            if (size >= capacity){
                Node deleted = dummyTail.pre;
                removeNode(deleted);
                cache.remove(deleted.key);
            }else {
                size++;
            }
            Node node = new Node(key, value);
            cache.put(key, node);
            insertToHead(node);
        }
    }
}
