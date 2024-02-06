# Problem A - Atlögur ⚔️

Guðmundur is a Ph.D. student at an Icelandic university, where he studies history. He has a burning interest in duels and the ways of knights of past times. In the middle ages, and the ages before them, battles between knights were common. His research revolves around these knights and, in particular, he is interested in writing about the most victorious knight.

Guðmundur has found a manuscript describing

knights. In the manuscript, the knights had been ordered by their tendency towards violence. The first knight would therefore challenge the second knight to a battle. The winner of the battle would then challenge the third knight, and so forth. At all moments, there was only one active battle and only two knights participated in each battle.

The knight that made the challenge struck first. When knight $i$ struck another knight $j$, he reduced the health of the other knight, $h_j$, by the value of his strength $s_i$. If the health of the other knight, $h_j$, was no longer a positive number, then knight $j$ had lost and knight $i$ stood victorious. Otherwise, the battle continued and the other knight struck next. The battle continued until one of the knights was victorious, and that knight would continue on to the next battle. All the damage that was done to the knights was permanent, they did not recover between battles.

There can be only one that stands victorious after all the battles. Which knight will win?

### Input

The first line of the input contains one integer $n$, the number of knights, where $1 \leq n \leq 1000$. Then $n$ lines follow, the $i$th of which consists of two integers $h_i$, the health of knight $i$, and $s_i$, the strength of knight $i$, where $1 \leq h_i,s_i \leq 10000$.

### Output

Output one integer, the index of the knight that stands victorious after all the battles.

<br/>

## Solution

Using recursion to simulate the battles, switching index order passed to `battle(i, j)` based on health of $j$ after first strike.

```java
class Atlogur {
    
    private int n;
    private int[] h;
    private int[] s;

    public Atlogur(int n, int[] h, int[] s) {
        this.n = n;
        this.h = h;
        this.s = s;
    }

    private void beginBattles() {
        int i = 0, j = 1;
        while (j < n) {
            battle(i, j);
            if (h[j] > h[i]) {
                i = j;
                j++;
            } else j++;
        }
        int w;
        if (h[i] > 0) {
            w = i + 1;
        } else {
            w = j + 1;
        }
        System.out.println(w);
    }

    private void battle(int i, int j) {
        h[j] -= s[i];
        if (h[j] > 0) {
            battle(j, i);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        int[] h = new int[n], s = new int[n];
        for (int i = 0; i < n; i++) {
            String[] k = scanner.nextLine().split(" ");
            h[i] = Integer.parseInt(k[0]); 
            s[i] = Integer.parseInt(k[1]);
        }

        scanner.close();
        Atlogur atl = new Atlogur(n, h, s);
        atl.beginBattles();
    }
}
```

[See Java Solution](../java-solutions/handins/fixedLengthSequences/Atlogur/Atlogur.java)

Python solution equivalent to the java code above

```python
class Atlogur(object):
    def __init__(self, n: int, h: [], s: []):
        self.n = n
        self.h = h
        self.s = s
    
    def begin_battles(self):
        i, j = 0, 1
        while j < self.n:
            self.battle(i, j)
            if self.h[j] > self.h[i]:
                i = j
                j += 1
            else:
                j += 1
        print(i + 1 if self.h[i] > 0 else j + 1) 
    
    def battle(self, i: int, j: int):
        self.h[j] -= self.s[i]
        if self.h[j] > 0:
            self.battle(j, i)
        
def main():
    n: int = int(input())
    H, S = [0] * n, [0] * n 
    for i in range(n):
        h, s = map(int, input().split())
        H[i] = h
        S[i] = s
    atl = Atlogur(n, H, S)
    atl.begin_battles()
    
if __name__ == "__main__":
    main()
```

[See Python Solution](../python/handins/fixedLengthSequences/Atlogur/Atlogur.py)

Bonus F# solution 

```fsharp
type Atlogur(n: int, h: int[], s: int[]) =
    member this.beginBattles() =
        let mutable i: int = 0
        let mutable j: int = 1
        while j < n do
            this.battle(i, j)
            if h.[j] > h.[i] then
                i <- j
                j <- j + 1
            else j <- j + 1
        let w =
            if h.[i] > 0 then
                i + 1
            else
                j + 1
        printfn "%d" w

    member this.battle(i: int, j: int) =
        h.[j] <- h.[j] - s.[i]
        if h[j] > 0 then
            this.battle(j, i)
        
let n: int = Console.ReadLine() |> int
let h: int[] = Array.zeroCreate(n)
let s: int[] = Array.zeroCreate(n)

for i in 0..n-1 do
    let ln = Console.ReadLine().Split() |> Array.map int
    h.[i] <- ln.[0]
    s.[i] <- ln.[1]

let atl: Atlogur = Atlogur(n, h, s)
atl.beginBattles()
```

<br/>

# Problem B - Coffee Cup Combo ☕

Jonna is a university student who attends $n$ lectures every day. Since most lectures are way too simple for an algorithmic expert such as Jonna, she can only stay awake during a lecture if she is drinking coffee. During a single lecture she needs to drink exactly one cup of coffee to stay awake.

Some of the lecture halls have coffee machines, so Jonna can always make sure to get coffee there. Furthermore, when Jonna leaves a lecture hall, she can bring at most two coffee cups with her to the following lectures (one cup in each hand). But note that she cannot bring more than two coffee cups with her at any given time.

Given which of Jonna’s lectures have coffee machines, compute the maximum number of lectures during which Jonna can stay awake.

### Input

The first line contains the integers $n(1 \leq n \leq 10^5)$, the number of lectures Jonna attends.
The second line contains a string $s$ of length $n$. The $i$’th letter is 1 if there is a coffee machine in the $i$’th lecture hall, and otherwise it is 0.

### Output

Print one integer, the maximum number of lectures during which Jonna can stay awake.

<br/>

## Solution

This approach will result in a time complexity of $O(n)$ where $n$ is the length of the char array `arr` (number of lectures joanna attends).

```java
class CoffeeCupCombo {

    private int n;
    private char[] arr;
    
    public CoffeeCupCombo(int n, char[] arr) {
        this.n = n;
        this.arr = arr;
    }

    private int maxLectures() {
        int m = 0, c = 0;               // keep track of the max and coffee count
        for (int i = 0; i < n; i++) {
            if (arr[i] == '0') {
                if (c > 0) {
                    m++;                // increment maxCount
                    c--;                // consume 1 cup of coffee
                }
            } else {            
                m++;                    // increment maxCount
                c = 2;                  // bring lots of coffee
            }
        } return m;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        String s = scanner.nextLine();
        scanner.close();

        CoffeeCupCombo ccbo = new CoffeeCupCombo(n, s.toCharArray());
        System.out.println(ccbo.maxLectures());
    }
}
```
[See Java Solution](../java-solutions/handins/fixedLengthSequences/CoffeeCupCombo/CoffeeCupCombo.java)

Python solution

```python
class CoffeCupCombo(object):
    def __init__(self, n: int, arr: []):
        self.n = n
        self.arr = arr
    
    def max_lectures(self) -> int:
        m,c = 0,0                       # keep track of the max and coffee count
        for i in range(self.n):
            if self.arr[i] == '0':
                if c > 0:
                    m += 1              # increment maxCount
                    c -= 1              # consume 1 cup of coffee
            else:
                m += 1                  # increment maxCount
                c = 2                   # bring lots of coffee
        return m 
    
def main():
    n: int = int(input())
    s: str = input()
    ccbo = CoffeCupCombo(n, list(s))
    print(ccbo.max_lectures())

if __name__ == "__main__":
    main()
```
[See Python Solution](../python/handins/fixedLengthSequences/CoffeeCupCombo/CoffeeCupCombo.py)

<br/>

# Problem C - Zoom 🔢

To determine whether your company is successful, your boss has to look at a long list of numbers! So many numbers, in fact, that they need some way to simplify the data. You came up with the idea to summarize the list by “zooming out”. How do you zoom out? Just discard everything except every $k^{th}$ number in the list, for some $k \geq 1$. Now, you just have to implement the idea, and your company will surely be very successful!

### Input

The first line contains integers $n$ and $k$, with $1 \leq k \leq n \leq 10^5$. The second line contains $n$ integers $x_1,x_2 \dots ,x_n$ describing the list of numbers. It is guaranteed that $0 \leq x_i \leq 2^{30}$ for $i=1, \dots ,n$.

### Output

Display the sequence $x_k,x_2, \dots ,x_{qk}$ where $q=\lfloor \frac nk\rfloor$.

<br/>

## Solution

```java
class Zoom {

    private int n;
    private int k;
    private int[] x;    
    
    public Zoom(int n, int k, int[] x) {
        this.n = n;
        this.k = k;
        this.x = x;
    }

    private void display() {
        StringBuilder sb = new StringBuilder();
        for (int i = k - 1; i < n; i += k) {
            sb.append(x[i]).append(" ");
        }
        System.out.println(sb.toString().trim());
    } 

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] fln = scanner.nextLine().split(" ");
        String[] s = scanner.nextLine().split(" ");
        scanner.close();

        int n = Integer.parseInt(fln[0]), k = Integer.parseInt(fln[1]);
        int[] x = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = Integer.parseInt(s[i]); 
        }

        Zoom z = new Zoom(n, k, x);
        z.display();
    }
}
```

[See Java Solution](../java-solutions/handins/fixedLengthSequences/Zoom/Zoom.java)


```python
class Zoom(object):
    def __init__(self, n: int, k: int, x: []):
        self.n = n
        self.k = k
        self.x = x
    
    def display(self):
        res = []
        for i in range(self.k - 1, self.n, self.k):
            res.append(str(self.x[i]))
        print(" ".join(res))
          
def main():
    n,k = map(int, input().split())
    s = input().split(' ')
    x = [0] * n
    for i in range(n):
        x[i] = int(s[i])
    z = Zoom(n, k, x)
    z.display()

if __name__ == "__main__":
    main()
```

[See Python Solution](../python/handins/fixedLengthSequences/Zoom/Zoom.py)

<br/>

# Problem D - Howl 🐺

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

<br/>

## Solution

```java
class Howl {

    private int n;
    private StringBuilder H;

    public Howl(String f) {
        n = f.length() + 1;
        H = new StringBuilder();
    }

    private String superAwesomeHowl() {
        int lim = n - 3;
        char next = 'A';
        for (int i = 0; i < lim; i++) {
            H.append(next);
            if (next == 'A') next = 'W';
            else next = 'A';
        }
        H.append('H');
        for (int i = lim + 1; i < n; i++) {
            H.append('O');
        }
        return H.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String f = scanner.next();
        scanner.close();
        Howl howl = new Howl(f);
        System.out.println(howl.superAwesomeHowl());
    }
}
```

[See Java Solution](../java-solutions/handins/fixedLengthSequences/Howl/Howl.java)

Python solution

```python
class Howl(object):
    def __init__(self, h: str):
        self.n = len(h) + 1
        self.H = [''] * self.n
    
    def super_awesome_howl(self) -> str:
        lim: int = self.n - 3
        next = 'A'
        for i in range(lim):
            self.H[i] = next
            if next == 'A':
                next = 'W'
            else: next = 'A'
        self.H[lim] = 'H'
        for i in range(lim + 1, len(self.H)):
            self.H[i] = 'O'
        return "".join(self.H)

def main():
    h: str = input()
    howl = Howl(h)
    print(howl.super_awesome_howl())
    
if __name__ == "__main__":
    main()
```

[See Python Solution](../python/handins/fixedLengthSequences/Howl/Howl.py)

<br/>

# Problem E - Bit by Bit 🖳

A brand new Ultra-CISC microprocessor has a collection of instructions for manipulating individual bits of one of its 32-bit registers. The instructions work as described in the following table. In all cases, bit zero is the low-order bit and bit 31 is the high-order bit. The representation of the instruction set makes it impossible to try to manipulate bits outside this range.

CLEAR
Put a zero into bit

* CLEAR $i$ - Put a zero into bit $i$.
* SET $i$ - Put a one into bit $i$ 
* OR $i$ $j$ - Store in bit $i$ the logical OR of the contents of bits $i$ and $j$.
* AND $i$ $j$ - Store in bit $i$ the logical AND of the contents of bits $i$ and $j$.

Your job is to determine the contents of the register after a sequence of these operations. Unfortunately, you don’t know anything about what was in the register before the instructions.

### Input

Input consists of multiple instruction sequences, each beginning with a positive integer $n \leq 100$. This is followed by lines, each giving a legal bit manipulation instruction. All bits referenced are in the range 0 – 31 (inclusive). The end of input is marked with a value of 0 for $n$.

Each instruction sequence in the input is to be interpreted independently. You should assume nothing about the contents of the register before each instruction sequence.

### Output

For each instruction sequence, print out a line giving the final contents of the register. Print your result in binary, with the most significant bit on the left. Since you don’t know anything about what was in the register before the sequence, you may not be able to determine the values of some bits. Just print a question mark for these bits.