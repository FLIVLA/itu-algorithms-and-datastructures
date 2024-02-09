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

    private class Node<T> {
        T data;
        Node<T> next;

        Node(T t) {
            data = t;
            next = null;
        }
    }
}
