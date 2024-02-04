# Week 1 Exercises

### 1.1.14

Design an algorithm that takes an integer value $N$ as argument and returns the largest integer not larger than the base-2 logarithm of $N$. Do not use a math library.

#### Note: 
the base-2 logarithm of a number is the exponent to which 2 must be raised to obtain that number. Denoted as $log_2(x)$, where $x$ is the number for which you want to find the logarithm. in mathematical notation:

$$
log_2(x)=y \Longleftrightarrow 2^y=x
$$

First, calculating the power of a number without using a math library can be done as follows:

```java
private static double pow(double x, int power) {
    if (power == 0) return 1;
    double result = 1;

    if (power > 0) {
        while (power != 0) {
            result *= x;
            power--;
        }
    } else {
        while (power < 0) {
            result /= x;
            power++;
        }
    }
    return result;
}
```

The approach above can be applied for calculating the base-2 logarithm of a number. Here `base2Log` is initialized to 0. The while-loop will continue as long as $n > 1$, and for each iteration $n$ is divided by 2, and `base2Log` is incremented by 1, keeping track of how many times $n$ is divided. When $n \leq 1$, the loop teminates.

```java
private static int base2Log(int n) {
    if (n <= 0) {
        throw new IllegalArgumentException("N must be a positive integer");
    } 
    int base2Log = 0;
    while (n > 1) {
        n /= 2;
        base2Log++;
    }
    return base2Log;
}
```

```python
```

### 1.5.1

### 1.5.2

### 1.5.3

### 1.5.8

### 1.5.9