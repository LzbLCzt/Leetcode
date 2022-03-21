package wangyihuyu;

public class Main {
    public static void main(String[] args) {
        Node head = new Node(10);
        List list = new List();
        list.add(5);
        list.add(4);
        list.add(3);
        list.add(3);
        list.add(2);
        list.forSearch();
        list.del(3);
        list.forSearch();

    }

}

class List{
    Node head;
    int size;

    public List(){
        head = new Node(0);
        size = 0;
    }

    public void add(int value) {
        if (head == null) {
            return;
        }
        boolean flag = false;
        Node temp = head;
        while (true){
            if (temp.next == null) {
                break;
            }
            if (temp.next.value > value){
                break;
            } else if (temp.next.value == value) {
                break;
            }
            temp = temp.next;
        }
        if (!flag) {
            Node newNode = new Node(value);
            newNode.next = temp.next;
            temp.next = newNode;
        }
    }

    public void del(int value){
        if (head == null) {
            return;
        }
        Node temp = head;
        boolean flag = false;
        while (true){
            if (temp.next == null) {
                break;
            }
            if (temp.next.value == value) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            Node end = temp.next;
            while (end != null && end.value == value) {
                end = end.next;
            }
            temp.next = end;
        }
    }

    public void forSearch(){
        if (head == null) {
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            System.out.println(temp.next);
            temp = temp.next;
        }
    }
}

class Node{
    int value;
    Node next;

    public Node(int v){
        this.value = v;
    }

    public void setNext(Node next){
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}