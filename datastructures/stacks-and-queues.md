# Stacks and Queues

1. [Array-based stack]()

#

Stacks are collections based on last-in-first-out policy (LIFO).

### Array-based Stack

Uses array to store stack element. Elements are inserted and removed from one end (top) of the stack. When memory is not a really a concern, this is a suitable choice. 

### Linked List Stack

Uses linked list to represent the stack



### Fixed-Size Stack

Has predefined size, and once stack reach maximum capacity, it cannot contain more elements.

```java
public class FixedSizeStack<T> {
    private T[] arr;
    private int t;                      // pointer to top element position
    private int sz;

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
```

### Dynamic Stack



### Two-Stack Queue

#
