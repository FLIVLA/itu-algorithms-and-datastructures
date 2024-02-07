# Balance

Decide if a given string of parentheses of two different types is balanced, meaning that the opening and corresponding closing parentheses are properly nested. For instance, `“([])()[]”` is balanced, but `“((”` and `“)(”` and `“(]”` are not.

To be precise, (i) the empty string is balanced; (ii) if $w$
is balanced then both $(w)$ and $[w]$ are balanced; and (iii) if $w$ and $x$ are balanced then $wx$ is balanced.

### Input

The input consists of a single line containing a nonempty sequence $w$ of symbols from the alphabet `{[,],(,)}`.

### Output

Print “1” if $w$ is balanced, “0” if not.

### Test groups

Let $|w|$ denote the length of $w$. In all test groups, we have $1 \leq |w| \leq 200\, 000$.


$$
\begin{array}{c c c}
  \text{Group} & \text{Points} & \text{Additional constraints} \\
  \hline
  \text{1} & \text{9} & \text{There are no “[” or “]”} \\
  \text{2} & \text{10} & |w| \leq 100 \\
  \text{3} & \text{81} & \text{None} \\
\end{array}
$$

<br/>

## Solution

This problem is quite easily solved by using a stack type data structure for keeping track of the balance in the input character sequence. 

```java
class Balance {

    private boolean isCorrespondingElm(char c1, char c2) {
        switch (c1) {
            case '(': return c2 == ')';
            case '[': return c2 == ']';
            case '{': return c2 == '}';
            default: return false;
        }
    }
    
    private boolean isBalanced(String s) {
        if (s.length() == 0) { return true; }                     // empty strings are considered balanced
        if (s.length() % 2 != 0) { return false; }                // if uneven length, s can't be balanced

        Stack<Character> w = new Stack<Character>(s.length());
        for (int i = 0; i < s.length(); i++) { 
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {               // if c is opening parenthesis, push!
                w.push(c);
            } else {
                if (w.isEmpty()) { return false; }                // if empty here, there is imbalance in s
                else {
                    w.pop();                                      // decrement top pointer 
                    char t = w.peek();                            // get top element in stack
                    if (!((t == '(' || t == '[' || t == '{')    
                        && isCorrespondingElm(t, c))) {
                            return false;                         // imbalance if t is not corresponding elm to c
                    }
                }
            }
        } return w.isEmpty();                                     // if empty, s is balanced
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        scanner.close();
        Balance b = new Balance();
        System.out.println(b.isBalanced(s) ? 1 : 0);
    }

    class Stack<Item> {                         // stack implementation (see p. 135)
        private Item[] w;
        private int t;                          // pointer to top element position

        public Stack(int N) {
            w = (Item[]) new Object[N];
            t = 0;
        } 

        private void push(Item i) { w[t++] = i; }
        
        private Item pop() { return w[t--]; }

        private Item peek() { return w[t]; }

        private boolean isEmpty() { return t == 0; }
    }
}
```

[See Java Solution](../java-solutions/handins/balance/Balance.java)

Python solution

```python
class Balance:
    def is_corresponding_elm(self, c1: str, c2: str) -> bool:
        if c1 == '(': return c2 == ')'
        elif c1 == '[': return c2 == ']'
        elif c1 == '{': return c2 == '}'
        else: return False
    
    def is_balanced(self, s: str) -> bool:
        N: int = len(s)
        if N == 0: return True             # empty strings are considered balanced
        if N % 2 != 0: return False        # if uneven length, s can't be balanced
        
        w = Stack(N)
        for i in range(N):
            c: str = s[i]
            if c == '(' or c == '[' or c == '{':    # if c is opening parenthesis, push!
                w.push(c)
            else:
                if w.is_empty(): return False       # if empty here, there is imbalance in s
                else:
                    w.pop()                                         # decrement top pointer 
                    t: str = w.peek()                               # get top element in stack    
                    if not (t == '(' or t == '[' or t == '{') \
                        and self.is_corresponding_elm(t, c):
                        return False                           # imbalance if t is not corresponding elm to c
        return w.is_empty()                                    # if empty, s is balanced
    
class Stack(object):                                # stack implementation (see p. 135)
    def __init__(self, N: int):
        self.w = [None] * N
        self.t = 0
    
    def push(self, i: object):
        self.w[self.t] = i
        self.t += 1
    
    def pop(self) -> object:
        self.t -= 1
        return self.w[self.t]
    
    def peek(self) -> object:
        return self.w[self.t - 1] 
    
    def is_empty(self) -> bool:
        return self.t == 0

def main():
    s: str = input()
    b = Balance()
    print(1 if b.is_balanced(s) else 0)
    
if __name__ == "__main__":
    main()
```

[See Python solution](../python/handins/balance/Balance.py)

