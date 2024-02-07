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

```java
```

