# Week 1: Union-Find

1. Which of the following is different from the set $\{2,3\}$?

* $ \{2\}\cap\{3\} $

* $ \{2\}\cup\{3\} $

* $ \{2,2,3\} $

* $ \{3,2\} $


#### Review

* $ \{2\} \cap \{3\} = \varnothing$ ✔️

* $ \{2\} \cup \{3\} = \{2,3\} $

* $ \{2,2,3\} = \{2,3\} $

* $ \{3,2\} = \{2,3\} $

<br/>

The correct anwer is option 1. $\varnothing \not = \{2,3\}$. In mathematical sets duplicate elements are not allowed, hence $\{2,2,3\}$ is considered being equal to $\{2,3\}$, also the order of elements does not matter, as a set is defined by the distinct elements in the set, and not by the order of which the elements are written.

#

2. Which of the following is an element of ($\in$) $ \{9, 2, 7\} $ ?

* $9$

* $1$

* $ \{9,2\} $

* $ \{9,2,7\} $

#### Review

* $9\in \{9,2,7\}$ ✔️

* $1\notin \{9,2,7\}$

* $\{9,2\}\notin \{9,2,7\}$

* $\{9,2,7\}\notin \{9,2,7\}$

<br/>

The correct answer is option 1, $9\in \{9,2,7\}$. $1$ does simply not appear in the set. For option 2 and 3, even though the elements of both sets appear in $\{9,2,7\}$, the sets themselves are not part of the set. The correct way to describe sets of 2 and 3 would be

$$
\begin{align*}
\{9,2\} &\sub \{9,2,7\} && \text{or}\\
\{9,2\} &\subseteq \{9,2,7\} \\ \\

\{9,2,7\} &\subseteq \{9,2,7\} \\
\end{align*}
$$

#

3. Which of the following is a proper subset ($\sub$) of $\{9, 2, 7\}$ ?

* $9$ 

* $1$

* $\{9,2\}$

* $\{9,2,7\}$

#### Review

* $9 \not\sub \{9,2,7\}$

* $1 \not\sub \{9,2,7\}$

* $\{9,2\} \sub \{9,2,7\}$ ✔️

* $\{9,2,7\} \not\sub \{9,2,7\}$

<br/>

The correct answer is option 3, $ \{ 9,2 \} \sub \{ 9,2,7 \} $, as every element of $ \{ 9,2 \} $ appear in $ \{ 9,2,7 \}$ and $ \{ 9,2 \} \not = \{ 9,2,7 \} $, making it a proper subset. For option 4, as every element is in both sets violating the criteria for being a proper subset

#

4. Which of the following is a subset ( $ \subseteq $ ) of of $ \{ 9,2,7 \}$, but not a proper subset ( $ \sub $ ) ?