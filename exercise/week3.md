# Week 3 - Stacks and Queues

### 1.2.6 

A string $s$ is a circular rotation of a string $t$ if it matches when the characters
are circularly shifted by any number of positions; e.g., ACTGACG is a circular shift of TGACGAC, and vice versa. Detecting this condition is important in the study of genomic sequences. Design an algorithm that checks whether two given strings $s$ and $t$ are circular shifts of one another.

<br/>

Initial approach: start a while loop with the condition `S!=T`, then do a for-loop rotating `S` by 1 for each iteration, followed by a equality check `S==T`, if they are not equal it does another rotation...

```python
def is_rotation_of(s: str, t: str) -> bool:
    S = list(s)
    T = list(t)
    if S == T: return True
    c = 0                                   # for tracking iteration count in while loop
    while S != T:
        last = S[-1]                        # store te last element of S
        for i in range(len(S) - 1, 0, -1):  
            S[i] = S[i-1]
        S[0] = last                         # place last in first position
        if S == T: return True
        c += 1
        if c == len(S): break               # all possibilities have been checked
    return False
```

The quick and dirty, selfconcatenation of `t`, and check if `tt` contains `s`. For larger strings, this would not be very wise to do. 

```python
def is_rotation_of_concat(s: str, t: str) -> bool:
    tt = t+t
    if s in tt: return True
    return False
```

#

### 1.3.7

Describe how you could create a method/function peek() to Stack that returns
the most recently inserted item on the stack (without popping it).

```java
public T peek() {                       // returns top element of the stack
    return arr[t-1];
}
```

where `t` is the integer representing the length of the array, `t-1` then points to the position of the top element.

#

### 1.3.19

Explain how you would create a method/function `removeLast()`, that removes
the last node in a linked list whose first node is stored in the variable first. Making a drawing of what is going on is encouraged

```java
public void removeLast() {
    if (head.next == null) {                            // if first node is also the last node
        head = null;
        return;
    }
    Node<T> prev = head;                                // keep track of previous from current
    for (Node<T> n = head; n != null; n = n.next) {   
        if (n.next == null) {
            prev.next = null;                           // delete current from prev.next
            return;
        }
        prev = n;                                       // set prev to current 
    }
}
```

# 

### 1.3.20

Explain and draw how one could design a method/function `delete()` that
takes an int argument k and deletes the kth element in a linked list, if it exists.

This solution could of course return some meaningful result.. but this is plenty for demonstrating the technique.

```java
public void delete(int k) {
    int i = 0;                                          // assuming list is 0-indexed?
    for (Node<T> n = head; n != null; n = n.next) {
        if (i == k - 1 && n.next != null) {             // check if node is to the left of k, and has a next
            n.next = null;
            return;
        } i++;                                      
    }
}
```

#

### 1.3.21

#

### 1.3.22

Suppose that x is a linked list Node. What does the following code fragment do? (This question is also in the quiz, but necessary for the question below)

```java
t.next = x.next;
x.next = t;
```

First next of `t` is set to `x.next`, then `x.next` is set to `t`, which results in node `t` being placed right after node `x` in the linked list.

# 

### 1.3.23

Why does the following code fragment not do the same thing as in the previous question?

```java
x.next = t;
t.next = x.next;
```

Because `x.next` is set to `t` first, resulting `t` having a curcular next reference to itself.

#

### 1.3.27

Suppose that you get a reference for the first node in a linked list. Describe
how you can find and output the maximum key in the list. Assume that all keys are positive
integers, and return 0 if the list is empty
