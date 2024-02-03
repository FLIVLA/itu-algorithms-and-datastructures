# Problem A - Disjoint Sets

Maintain a family of disjoint sets, initially the singletons $`\{0\}`, `\{1\}`, \dots, `\{n-1\}`$ under the following operations:

#### 0("query")

The query operation takes two elements $s$ and $t$ and determines if $s$ and $t$ belong to the same set. More Precisely, if $s\in S$ and $t\in T$ then print "1" if $S=T$ and print "0" if $S\not = T$

#### 1("union")

The union operation takes two elements $s$ and $t$ and creates the union of the two sets containing $s$ and $t$. More precisely, if $s \in S$ and $t \in T$ with $S \not = T$ then $S$ and $T$ are removed from the family and replaced by the set $S \cup T$. (if $S=T$ then nothing happens)

#### 2("move")

The move operation takes two elements $s$ and $t$ and moves the element $s$ into the set containing the element $t$. More precisely, if $s \in S$ and $t \in T$ with $S \not = T$ then $S$ is changed to $S-`\{s\}`$ and $T$ is changed to $T \cup `\{s\}`$. (if $S=T$ then nothing happens)

Note that these operations maintain invariantly that the sets in the family are disjoint.

### Test groups

$$
\begin{array}{c c c c }
  \text{Test group} & \text{Points} & \text{Problem size bounds} & \text{Operations} \\
  \hline
  \text{1} & \text{10} & n,m \leq 1000 & \text{0 and 1} \\
  \text{2} & \text{10} & n,m \leq 1000 & \text{0, 1 and 2} \\
  \text{3} & \text{40} & n,m \leq 100000 & \text{0 and 1} \\
  \text{4} & \text{40} & n,m \leq 100000 & \text{0, 1 and 2} \\
\end{array}
$$

### Input

The input starts with two positive integers $n, m$ on the first line. The integer $n$ is the initial number of singletons. The following $m$ lines are of the form `0 s t` or `1 s t` or `2 s t`, representing query, union and move. In test groups 1 and 3, move never occurs. You can assume $0 \leq s \leq n,0 \leq t < n$ and $m \geq 1$

### Output

For each query, write a single line containing 1 or 0 as described above.