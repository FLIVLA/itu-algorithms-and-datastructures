# Preparation

## Problem A - Echo Echo Echo

### Input

Input is a single line, containing exactly one word. The only characters used are upper and/or lowercase letters (a–z). The word contains at least one and at most 15 characters.

### Output

Output the given word three times, separated by spaces.

#### java

```java
public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String w = scanner.next(), s = "";

    for (int i = 0; i < 3; i++) {
        s += w + " ";
    }
    scanner.close();
    System.out.println(s);
}
```

#### python

```python
def echo_echo_echo() -> None:
    word: str = input()
    for _ in range(3):
        print(word + " ")
```

#
## Problem B - Odd Echo

### Input

The first line of the input contains an integer $N(1 \leq N \leq 10)$
The next $N$ lines each contains a word. Each word is at most 100 letters long, and contains only letters ‘a-z‘.

### Output

Output the odd-indexed (i.e. first, third, fifth, and so on) words in the input.

#### java

```java
public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in); 
    List<String> input = new ArrayList<String>();
    while (scanner.hasNextLine()) {
        input.add(scanner.nextLine());
    }

    scanner.close();

    int N = Integer.parseInt(input.get(0));
    for (int i = 1; i <= N; i++) {
        if (i % 2 != 0) {
            System.out.println(input.get(i));
        } 
    }
}
```

#### python

```python
def odd_echo() -> None:
    lines: List[str] = []
    while True:
        try:
            line = input()
            lines.append(line)
        except EOFError:
            break 
    N: int = int(lines[0])
    for i in range(1, N + 1):
        if i % 2 != 0:
            print(lines[i])
```
#
## Problem C - Add Two Numbers

### Input

The input contains one line, which has two integers $a$ and $b$, separated by a single space. The bounds on these values are $0 \leq a,b \leq 1000000$.

### Output

Output the sum of the two integers, $a+b$.

#### java

```java
public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt(), b = scanner.nextInt();
    scanner.close();
    System.out.println(a + b);
} 
```

#### python

```python
def add_two_numbers() -> None:
    chars: List[str] = input().split(' ')
    a, b = int(chars[0]), int(chars[1])
    print(a + b)
```
#
## Problem D - N-sum

### Input

The first line of the input contains an integer $N(2 \leq N \leq 10)$, the number of integers your program should add. The next line contains $N$ the
integers to add, each between $0$ and $1000$.

### Output

Output a single integer – the sum of the $N$ integers from the input.

#### java

```java
public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int N = scanner.nextInt();
    scanner.nextLine();
    String[] ints = scanner.nextLine().split(" ");
    scanner.close();

    int sum = 0;
    for (int i = 0; i < N; i++) {
        sum += Integer.parseInt(ints[i]);
    }
    System.out.println(sum);
}
```

#### python

```python
def n_sum() -> None:
    N: int = int(input())
    ints: List[str] = input().split(' ')
    sum: int = 0
    for i in range(N):
        sum += int(ints[i])
    print(sum)
```

#
## Problem E - Baby Bites

### Input

The first line of input contains an integer $n(1 \leq n \leq 1000)$, the number of bites Arild receives. Then second line contains $n$ space-separated words spoken by Arild, the $i$’th of which is either a non-negative integer $a_i(0 \leq a_i \leq 10000)$ or the string “mumble”.

### Output

If Arild’s counting might make sense, print the string “makes sense”. Otherwise, print the string “something is fishy”.

#### java

```java
public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    scanner.nextLine();
    String[] words = scanner.nextLine().split(" ");
    scanner.close();

    String res = "makes sense";
    for (int i = 0; i < n; i++) {
        if (!words[i].equals("mumble") && Integer.parseInt(words[i]) != i + 1) {
            res = "something is fishy";
            break;
        }
    }
    System.out.println(res);
}
```

#### python

```python
class Nsum:
    def sum() -> None:
        N: int = int(input())
        ints: List[str] = input().split(' ')
        sum: int = 0
        for i in range(N):
            sum += int(ints[i])
        print(sum)
```