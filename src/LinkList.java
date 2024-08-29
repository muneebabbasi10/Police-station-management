import java.io.*;

public class LinkList {
    private Node head;
    private int size;

    public LinkList() {
        head = null;
        size = 0;
    }

    public void add(Complaint c) {
        Node n = new Node(c);
        n.next = head;
        head = n;
        size++;
    }

    public Complaint search(String name) {
        Node n = head;
        while (n != null) {
            if (n.data.getName().equals(name)) {
                return n.data;
            }
            n = n.next;
        }
        return null;
    }

    public void delete(String name) {
        if (head == null) {
            return;
        }
        if (head.data.getName().equals(name)) {
            head = head.next;
            size--;
            return;
        }
        Node n = head;
        while (n.next != null) {
            if (n.next.data.getName().equals(name)) {
                n.next = n.next.next;
                size--;
                return;
            }
            n = n.next;
        }
    }

    public Complaint get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        Node n = head;
        for (int i = 0; i < index; i++) {
            n = n.next;
        }
        return n.data;
    }

    public int size() {
        return size;
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