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

    public void remove(T data) {
        
    }

    public boolean search(T data) {
        Node<T> current = head;
        while (current != null) {
            if (current.data.equals(data)) { 
                return true; 
            } current = current.next;
        } return false;
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
