# Week 3 - Stacks and Queues

1. `s` is an empty stack of strings. Consider the following operations:

```java
s.push("person")
s.push("woman")
s.push("man")
s.push("camera")
s.push("tv")
s.pop()
```

What element is popped?

* person
* woman
* man
* camera
* tv ✔️

<br/>

The answer is options 5, "tv". As the stack data structure follows a last-in-first-out (LIFO) policy, the last added element is also the element being removed on a `pop()` operation.

#

2. `q` is an empty queue of strings. Consider the following operations on it:

```java
q.enqueue("person");
q.enqueue("woman");
q.enqueue("man");
q.enqueue("camera");
q.enqueue("tv");
q.dequeue();
```

What element is dequeued?

* person ✔️
* woman
* man
* camera
* tv

<br/>

The answer is option 1, "person". The queue data structure follows a first-in-first-out (FIFO) policy, the first element queued is also the element next in line for dequeue. 

#

3. How many elements are left on the stack after the following operations?

```java
Stack<Integer> stack = new Stack<Integer>();
stack.push(1);
stack.pop();
stack.push(2);
stack.push(3);
stack.push(4);
stack.pop();
stack.pop();
stack.push(5);
```

* 4
* 5
* 3
* 2 ✔️
* 1

<br/>

The answer is 2 elements. First one element is pushed, followed by a pop, making the count 0. Then 3 elements are pushed, followed by two pop's, making the count 1. Lastly, one element is pushed, leaving the stack at a count of 2 elements.

#

4. Consider the following operations:

```java
Stack<Integer> stack = new Stack<Integer>();
stack.push(4);
stack.pop;
stack.push(1);
stack.push(2);
stack.push(5);
stack.pop;
stack.pop;
stack.push(3);
```

What element would be returned by another pop() operation?

* 3 ✔️
* 2
* 1
* 4
* 5

<br/>

The answer is 3. First 4 is pushed, followed by a pop, and no elements are in the stack. Then 1, 2 and 5 is pushed, followed by two pop's, and only 1 is left in the stack. Lastly 3 is pushed to the stack, and the result of another pop would return 3.

#

5. What is the result of the sequence of stack operations below, where each word means `push(word)` and each dash means `pop()`?

`it was - the best - of times - - - it was - the - -`

* it was the best of times it was
* it the best of times it was the
* was best times of the was the it ✔️
* was best times of the was the
* the was it times of best the was

<br/>

The answer is option 3. below is a java translation of the above sequence of operations.

```java
stack.push("it");
stack.push("was");
stack.pop();            // returns "was"
stack.push("the");
stack.push("best");
stack.pop();            // returns "best"
stack.push("of");
stack.push("times");
stack.pop();            // returns "times"
stack.pop();            // returns "of"
stack.pop();            // returns "the"
stack.push("it");
stack.push("was");
stack.pop();            // returns "was"
stack.push("the");
stack.pop();            // returns "the"
stack.pop();            // returns "it"
```

#

6. Using a `ResizingArrayStackOfStrings` (Algorithm 1.1, p. 141) where each word means `push(word)` and each dash means `pop()`, what is the size of the array after the following operations:

`it was - the best - of times - - - it was - the - -`

* a. 2
* b. 8 
* c. 1 ✔️
* d. 4

The element count would be 1 after the shown sequence

```
{ it }
{ it, was }
{ it }
{ it, the }
{ it, the, best }
{ it, the }
{ it, the, of }
{ it, the, of, times }
// perform 3 pops
{ it }
{ it, it }
{ it, it, was }
{ it, it }
{ it, it, the }
{ it, it }
{ it }              // leaving the count at 1
```

#

7. Suppose that a client performs an interleaved sequence of (stack) `push()` and `pop()` operations. The push operations are `push(0)` to `push(9)` in that order; interleaved with pop operations. Which of the following sequence(s) of popped elements cannot occur?

* 0 4 6 5 3 8 1 7 2 9 
* 2 1 4 3 6 5 8 7 9 0 
* 2 5 6 7 4 8 9 3 1 0 
* 1 2 3 4 5 6 9 8 7 0 
* 1 4 7 9 8 6 5 3 0 2
* 4 3 2 1 0 5 6 7 8 9
* 4 6 8 7 5 3 2 9 0 1 
* 4 3 2 1 0 9 8 7 6 5 

<br/>

ask TA how the hell to interpret this...

#

8. same as above

#

9. What does the following code fragment do to the queue q?

```java
Stack<String> stack = new Stack<String>();
while(!q.isEmpty())
   stack.push(q.dequeue());
while(!stack.isEmpty())
   q.enqueue(stack.pop());
```

```python
stack = Stack()
while !q.isEmpty():
   stack.push(q.dequeue())
while !stack.isEmpty():
   q.enqueue(stack.pop())
```

* Reverses order of q ✔️
* Nothing - the queue is identical after the code fragment
* Removes the last element of the queue
* Shuffles q

<br/>

It reverses the order of q. Let $`q=\{a,b,c\}`$, in the first while-loop the stack is filled with elements $a,b,c$, in the second while loop, elements $c,b,a$ are added to $q$ in that order, resulting in $q=\{c,b,a\}$ (reversed order).

#

10. Suppose that `t` and `x` are linked list nodes. What does the following code fragment do?

```python
t.next = x.next;
x.next = t;
```

* Removes node x from the list
* Removes node t from the list
* Inserts node x immediately after node t
* Inserts node t immediately after node x

<br/>

The answer is option 4, it inserts node `t` immediately after node `x`. first it sets `t.next` to the next element of node `x`, followed by replacing next of `x` with `t`, making `t` the next node after `x` in the linked list.

#

