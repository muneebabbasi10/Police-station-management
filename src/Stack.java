
public class Stack {
    private Node head;
    private Node tail;
    private int size;

    public Stack() {
        head = null;
        tail = null;
        size = 0;
    }

    public void push(Complaint c) {
        Node n = new Node(c);
        if (head == null) {
            head = n;
            tail = n;
        } else {
            tail.next = n;
            tail = n;
        }
        size++;
    }
        public Complaint pop(String name) {
        if (head == null) {
            return null;
        }
        if (head.data.getName().equals(name)) {
            Complaint c = head.data;
            head = head.next;
            size--;
            return c;
        }
        Node n = head;
        while (n.next != null) {
            if (n.next.data.getName().equals(name)) {
                Complaint c = n.next.data;
                n.next = n.next.next;
                size--;
                return c;
            }
            n = n.next;
        }
        return null;
    }

    private class Node {
        Complaint data;
        Node next;

        public Node(Complaint c) {
            data = c;
            next = null;
        }
    }
}


