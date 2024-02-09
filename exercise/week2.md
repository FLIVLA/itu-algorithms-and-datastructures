# Week 2 Exercises (Strings & Arrays)

### G1. Aliasing

```java
int[] a = {0, 0, 0, 0};
a[2] = 1234;
int[] b = a;
b[2] = 5678 ;
System.out.print(a[2]);
```

when we assign $b$ to $a$, a new array is not created, but instead both $a$ and $b$ point to the same array, which makes any changes made to the $b$ will also affect $a$, making the final print statement $5678$.

#

### G2. Negative indices

Consider

```java
int[] a = {10, 20, 30};
```

```python
a: list[int] = [10, 20, 30]
```
In either languages, what is `a[1]`? What is `a[-1]`?

`a[1]` in both languages is the second element in the array (20). For `a[-1]`, in python is the last element in the array. In java `a[-1]` returns error.

#

### G3. Index into space

#

### Y1. Reversal

Write a code fragment to revert an array a using a for-loop (or better yet: a while-loop.) Don’t just use a library or inbuilt function like reverse(a).

#### Solution

This can be done super simple with a left and right pointer looping while $l < r$ swapping $a_l$ and $a_r$ in each iteration.

```java
public static <T> T[] reverse(T[] arr) {
    int l = 0, r = arr.length - 1;
    while (l < r) {
        T t = arr[l];           // store temporary left element
        arr[l] = arr[r];        // assign right to left
        arr[r] = t;             // assign temp to right
        l++;                    // increment left pointer
        r--;                    // decrement right pointer
    }
    return arr;
}
```

```python
def reverse(arr: []) -> []:
    l,r = 0, len(arr) - 1
    while l < r:
        arr[l], arr[r] = arr[r], arr[l]     # sneaky element swap
        l += 1                              # increment left pointer
        r -= 1                              # decrement right pointer
    return arr

def main():
    ln = input()
    print(" ".join(reverse(ln.split())))

if __name__ == "__main__":
    main()
```

- [Source code - Java](../python/exercises/week2/Reverse.py)
- [Source code - Python](../python/exercises/week2/Reverse.py)

#

### Y2. String Manipulation

How would you solve the following task: The string $S$ consists of a's and b's, like this: `abbbaabababa`.

1. I want to change the b's to 1's, so I want a new string $T$ that looks like this: `a111aa1a1a1a`.
2. I want to change the b's alternatingly to 0 and 1. In my example, the resulting string should be `a101aa0a1a0a`.

(This is not an exercise about knowing just the right library function. Try to do it with a for- or while-loop.)

#### Solution

Straight forward solution, most interesting for 2, tracking the count of b's encoutered enables us to use modulo to alternate 0 and 1, simplifying the problem a bit. 

```java
public class StringManipulation {

    static String bToOnes(String s) {
        char[] S = s.toCharArray();
        int n = S.length;
        for (int i = 0; i < n; i++) {
            if (S[i] == 'b') { S[i] = '1'; }
        }
        return new String(S);
    }

    static String bToAltZerosAndOnes(String s) {
        char[] S = s.toCharArray();
        int n = S.length, b = 0;                // track the b's
        for (int i = 0; i < n; i++) {
            if (S[i] == 'b') {
                S[i] = (char) (b % 2);          // use modulo to alternate 0 and 1
                b++;                            // increment b
            }
        }
        return new String(S);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        scanner.close();
        System.out.println(StringManipulation.bToOnes(s));
        System.out.println(StringManipulation.bToAltZerosAndOnes(s));
    }
}
```

```python
def b_to_ones(s: str) -> str:
    S = list(s)
    n = len(S)
    for i in range(n):
        if S[i] == 'b':
            S[i] = '1'
    return "".join(S)

def b_to_alt_zeros_ones(s: str) -> str:
    S = list(s)
    n = len(S)
    b = 0                           # track the b's
    for i in range(n):
        if S[i] == 'b':
            S[i] = str(b % 2)       # use modulo to alternate 0 and 1
            b += 1                  # increment b
    return "".join(S)

def main():
    s = input()
    print(b_to_ones(s))
    print(b_to_alt_zeros_ones(s))

if __name__ == "__main__":
    main()
```

#

### R2. Sieve

Describe how to find all primes from $2$ to $N$ for given $N$.