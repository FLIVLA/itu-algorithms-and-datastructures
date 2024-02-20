# Problem A - Seat Allocation

Consider an election where $n$ parties run for seats in parliament. Let $v_i$ be the number of votes cast for party $`i\in \{1,\dots , n\}`$. To allocate the $m$ seats to the parties, roughly proportional to their share of votes, one can use a system called D’Hondt’s method. It works like this: A quotient is calculated for each party, initially $v_i/1$, the number of votes. The party with the largest quotient wins one seat, and its quotient is recalculated. This is repeated until all $m$ seats is filled. The formula for the quotient is

$$\frac{v_i}{s_i + 1}$$

where $s_i$ is the number of seats alocated to party $i$ so far, initially $0$ for all parties

## Input

On the first line of input: the number $n$ of parties and $m$ of seats, with $`n,m \in \{1,\dots ,20000\}`$, separated by a single space. On each of the following $n$ lines, the integer $v_i$, satisfying and . We also promise that the inputs are constructed so that the final seat can be uniquely determined—no tie breaking will be necessary.

## Output