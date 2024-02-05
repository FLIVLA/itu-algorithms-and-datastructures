# Problem A - Atlögur

Guðmundur is a Ph.D. student at an Icelandic university, where he studies history. He has a burning interest in duels and the ways of knights of past times. In the middle ages, and the ages before them, battles between knights were common. His research revolves around these knights and, in particular, he is interested in writing about the most victorious knight.

Guðmundur has found a manuscript describing

knights. In the manuscript, the knights had been ordered by their tendency towards violence. The first knight would therefore challenge the second knight to a battle. The winner of the battle would then challenge the third knight, and so forth. At all moments, there was only one active battle and only two knights participated in each battle.

The knight that made the challenge struck first. When knight
struck another knight , he reduced the health of the other knight, , by the value of his strength . If the health of the other knight, , was no longer a positive number, then knight had lost and knight

stood victorious. Otherwise, the battle continued and the other knight struck next. The battle continued until one of the knights was victorious, and that knight would continue on to the next battle. All the damage that was done to the knights was permanent, they did not recover between battles.

There can be only one that stands victorious after all the battles. Which knight will win?

### Input

The first line of the input contains one integer $n$, the number of knights, where $1 \leq n \leq 1000$. Then $n$ lines follow, the $i$th of which consists of two integers $h_i$, the health of knight $i$, and $s_i$, the strength of knight $i$, where $1 \leq h_i,s_i \leq 10000$.

### Output

Output one integer, the index of the knight that stands victorious after all the battles.


# Problem B - Coffee Cup Combo

Jonna is a university student who attends

lectures every day. Since most lectures are way too simple for an algorithmic expert such as Jonna, she can only stay awake during a lecture if she is drinking coffee. During a single lecture she needs to drink exactly one cup of coffee to stay awake.

Some of the lecture halls have coffee machines, so Jonna can always make sure to get coffee there. Furthermore, when Jonna leaves a lecture hall, she can bring at most two coffee cups with her to the following lectures (one cup in each hand). But note that she cannot bring more than two coffee cups with her at any given time.

Given which of Jonna’s lectures have coffee machines, compute the maximum number of lectures during which Jonna can stay awake.

### Input

The second line contains a string $s$ of length $n$. The $i$’th letter is 1 if there is a coffee machine in the $i$’th lecture hall, and otherwise it is 0.

### Output

Print one integer, the maximum number of lectures during which Jonna can stay awake.


# Problem C - Zoom

To determine whether your company is successful, your boss has to look at a long list of numbers! So many numbers, in fact, that they need some way to simplify the data. You came up with the idea to summarize the list by “zooming out”. How do you zoom out? Just discard everything except every $k^{th}$ number in the list, for some $k \geq 1$. Now, you just have to implement the idea, and your company will surely be very successful!

### Input

The first line contains integers $n$ and $k$, with $1 \leq k \leq n \leq 10^5$. The second line contains $n$ integers $x_1,x_2 \dots ,x_n$ describing the list of numbers. It is guaranteed that $0 \leq x_i \leq 2^{30}$ for $i=1, \dots ,n$.

### Output

Display the sequence $x_k,x_2, \dots ,x_{qk}$ where $q=\lfloor \frac nk\rfloor$.


# Problem D - Howl

Returning to the Beautiful Gloomy Outback (BGO) after a strenuous trip to the city, you hear a faint howl in the distance. Instantly you realize it is your friend Fenrir inviting you to a howling contest.

In order to make an impressive howl that wins the contest, you know that your howl must fulfill the following criteria in order to be valid:

* It must consist of a combination of the letters A, H, O and W. Each letter must occur at least once.
* The howl can not contain two consecutive W’s, or two consecutive H’s.
* The howl can not contain an H followed immediately by a W or an A.
* There can never be an A after the first occurrence of an O.

Can you produce a longer howl than Fenrir and win the contest?

### Input

The first and only line of input contains a single word, the howl of Fenrir. Since Fenrir is a proper wolf, his howls are always valid. Writing down Fenrir’s howl will require at most 1MB of computer memory.

### Output

A valid howl which will win the howling contest.

# Problem E - Bit by Bit

A brand new Ultra-CISC microprocessor has a collection of instructions for manipulating individual bits of one of its 32-bit registers. The instructions work as described in the following table. In all cases, bit zero is the low-order bit and bit 31 is the high-order bit. The representation of the instruction set makes it impossible to try to manipulate bits outside this range.

CLEAR
Put a zero into bit

* SET - Put a one into bit
* OR - Store in bit the logical OR of the contents of bits and
* AND - Store in bit the logical AND of the contents of bits and .

Your job is to determine the contents of the register after a sequence of these operations. Unfortunately, you don’t know anything about what was in the register before the instructions.

### Input

Input consists of multiple instruction sequences, each beginning with a positive integer $n \leq 100$. This is followed by lines, each giving a legal bit manipulation instruction. All bits referenced are in the range 0 – 31 (inclusive). The end of input is marked with a value of 0 for $n$.

Each instruction sequence in the input is to be interpreted independently. You should assume nothing about the contents of the register before each instruction sequence.

### Output

For each instruction sequence, print out a line giving the final contents of the register. Print your result in binary, with the most significant bit on the left. Since you don’t know anything about what was in the register before the sequence, you may not be able to determine the values of some bits. Just print a question mark for these bits.