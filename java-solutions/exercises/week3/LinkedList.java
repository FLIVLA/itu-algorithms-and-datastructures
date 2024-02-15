public class LinkedList<T> {
    Node<T> head;

    public LinkedList() {
        this.head = null;
    }

    public void insert(T data) {
        Node<T> n = new Node<T>(data);
        if (head == null) {
            head = n;
            return;
        }
        Node<T> last = head;
        while (last.next != null) {
            last = last.next;
        }
        last = n;
    }

    public void delete(int k) {
        int i = 0;
        for (Node<T> n = head; n != null; n = n.next) {
            if (i == k - 1 && n.next != null) {
                n.next = null;
                return;
            }
            i++;
        }
    }

    public void removeLast() {
        if (head.next == null) { 
            head = null;
            return;
        }
        Node<T> prev = head;
        for (Node<T> n = head; n != null; n = n.next) {
            if (n.next == null) {
                prev.next = null;
                return;
            }
            prev = n;
        }
    }

    @SuppressWarnings("hiding")
    private class Node<T> {
        @SuppressWarnings("unused")
        T data;
        Node<T> next;

        Node(T t) {
            data = t;
            next = null;
        }
    }
}
