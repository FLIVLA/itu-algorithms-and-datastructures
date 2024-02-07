# Grades

The grading scheme of the European Credit Transfer and Accumulation System (ECTS) uses 7 grades given as letters: A, B, C, D, E, FX, and F in that order, with A being the highest grade.

Lektor Blomme needs your help in sorting his students by grade. Students with a higher grade should appear before students with a lower grade.

In some courses, lektor Blomme was dissatisfied with the coarseness of the ECTS grading scheme. In those courses he used + and - modifiers to get more fine-grained grades as such as “A+” or “B-” with the obvious interpretation. For intance, grade C+++ is better than C++, and B+ is better than B, and B is better than B-.

### Test groups

There are 4 different test groups, each worth 25 points.

$$
\begin{array}{c c c}
  \text{Group} & \text{Points} & \text{Additional constraints} \\
  \hline
  \text{1} & \text{25} & \text{A, B, C, D, E, F} \\
  \text{2} & \text{25} & \text{A, B, C, D, E, FX, F}\\
  \text{3} & \text{25} & \text{A, B, C, D, E, FX, F, followed by at most one + or -} \\
  \text{4} & \text{25} & \text{No further restrictions} \\
\end{array}
$$

### Input

The input starts with the the number $n$ of students, an integer in the range $1 \leq n \leq 1000$. The following $n$ lines each contain the name of a student followed by a grade, separated by a single space. The name of a student is a nonempty sequence of lower-case English letters from a to z of length at most 20. A grade starts with one of the upper-case letters A, B, C, D, E, F. The letter F may be followed by an upper-case X. Then follows a (possibly empty) sequence of either `+` or `-` of length at most 10.

### Output

The students, one per line, ordered by grade, best students first. Students with the same grade must be ordered alphabetically.

<br/>

## Solution

```java
```

```python
```