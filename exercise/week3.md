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