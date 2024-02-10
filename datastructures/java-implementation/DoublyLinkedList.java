public class DoublyLinkedList<T> {
    Node<T> head;

    public DoublyLinkedList() {
        
    }

    private class Node<T> {
        T data;
        Node<T> prev;
        Node<T> next;

        Node(T t) {
            data = t;
            next = null;
        }
    }
}
