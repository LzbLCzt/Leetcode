package List;

import java.util.HashMap;

/**
 * @author shkstart
 * @create 2021-03-05 16:09
 */
public class leetcode138 {
    public static void main(String[] args) {

    }

    public Node copyRandomList(Node head) {
        if(head == null) return null;

        HashMap<Node, Node> map = new HashMap<>();
        Node temp = head;
        while (temp != null){
            Node newNode = new Node(temp.val);
            map.put(temp, newNode);
            temp = temp.next;
        }

        Node key = head;
        while (key != null){
            Node value = map.get(key);
            value.next = map.get(key.next);
            value.random = map.get(key.random);

            key = key.next;
        }

        return map.getOrDefault(head, null);
    }

}
