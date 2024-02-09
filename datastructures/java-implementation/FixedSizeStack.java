public class FixedSizeStack<T> {
    private T[] arr;
    private int t;                      // pointer to top element position
    private int sz;

    @SuppressWarnings("unchecked")
    public FixedSizeStack(int sz) {
        this.sz = sz;
        arr = (T[]) new Object[sz];
        t = 0;
    }

    public void push(T item) throws Exception {  // adds element to the stack at position t
        if (t < sz) {
            arr[t++] = item;
        } else {
            throw new Exception("stack capacity is at its limit");
        }
    }

    public T pop() throws Exception {           // removes top element (decrements t)
        if (t > 0) {
            return arr[--t];
        } else {
            throw new Exception("Stack is empty");
        }
    }

    public T peek() {                       // returns top element of the stack
        return arr[t-1];
    }

    public int size() {                     // returns current size of the stack
        return t;
    }

    public boolean isEmpty() {              // checks if the stack is empty
        return t == 0;
    }
}
