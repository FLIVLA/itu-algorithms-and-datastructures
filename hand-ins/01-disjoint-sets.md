# Problem A - Disjoint Sets

Maintain a family of disjoint sets, initially the singletons $`\{0\}`, `\{1\}`, \dots, `\{n-1\}`$ under the following operations:

#### 0("query")

The query operation takes two elements $s$ and $t$ and determines if $s$ and $t$ belong to the same set. More Precisely, if $s\in S$ and $t\in T$ then print "1" if $S=T$ and print "0" if $S\not = T$

#### 1("union")

The union operation takes two elements $s$ and $t$ and creates the union of the two sets containing $s$ and $t$. More precisely, if $s \in S$ and $t \in T$ with $S \not = T$ then $S$ and $T$ are removed from the family and replaced by the set $S \cup T$. (if $S=T$ then nothing happens)

#### 2("move")

The move operation takes two elements $s$ and $t$ and moves the element $s$ into the set containing the element $t$. More precisely, if $s \in S$ and $t \in T$ with $S \not = T$ then $S$ is changed to 
$`S - \{s\}`$ and $T$ is changed to $`T \cup \{s\}`$. (if $S=T$ then nothing happens)

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

## Solution

This solution does not use path compression, hence the union operation will have a time complexity of $O(n)$, and will only score 20 points, as time limit exeeds for the larger test groups.

```java
public class UnionFind {
    
    private int[] arr;

    public UnionFind(int n) {
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
    }

    private int find(int x) {
        return arr[x];
    }

    private void query(int s, int t) {
        int res;
        if (arr[s] == arr[t]) {
            res = 1;
        } else res = 0;
        System.out.println(res);
    }

    private void union(int s, int t) {
        int sID = find(s), tID = find(t);
        if (sID == tID) { return; }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == sID) arr[i] = tID;
        }
    }

    private void move(int s, int t) {
        if (arr[s] == arr[t]) { return; } 
        arr[s] = arr[t];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] fln = scanner.nextLine().split(" ");
        int n = Integer.parseInt(fln[0]), m = Integer.parseInt(fln[1]);

        UnionFind uf =  new UnionFind(n);

        // add instructions
        int[][] ins = new int[m][3];
        for (int i = 0; i < m; i++) {
            String[] str = scanner.nextLine().split(" ");
            int[] nums = new int[] { 
                Integer.parseInt(str[0]),
                Integer.parseInt(str[1]),
                Integer.parseInt(str[2]),
            };
            ins[i] = nums;
        }

        scanner.close();

        for (int i = 0; i < ins.length; i++) {
            int o = ins[i][0], s = ins[i][1], t = ins[i][2]; 
            switch (o) {
                case 0: uf.query(s, t); break;
                case 1: uf.union(s, t); break;
                case 2: uf.move(s, t);  break;
            }   
        }
    }
}
```

Equivalent python solution for the above java code:

```python
class UnionFind(object):
    def __init__(self, n: int) -> None:
        arr = []
        for i in range(n):
            arr.append(i)
        self.arr = arr
    
    def find(self, x: int) -> int:
        return self.arr[x]
    
    def query(self, s: int, t: int) -> None:
        print(1 if self.arr[s] == self.arr[t] else 0)
        
    def union(self, s: int, t: int) -> None:
        sID, tID = self.find(s), self.find(t)
        if sID == tID: 
            return
        for i in range(len(self.arr)):
            if self.arr[i] == sID:
                self.arr[i] = tID
    
    def move(self, s: int, t: int) -> None:
        if self.arr[s] == self.arr[t]:
            return
        self.arr[s] = self.arr[t]

def main():
    fln = input().split(' ')
    n,m = int(fln[0]), int(fln[1])
    uf = UnionFind(n)
    
    ins = []
    for i in range(m):
        str = input().split(' ')
        ins.append([
            int(str[0]), 
            int(str[1]), 
            int(str[2])
        ])
    
    for i in range(len(ins)):
        o,s,t = ins[i][0], ins[i][1], ins[i][2]
        if o == 0: 
            uf.query(s, t)
        elif o == 1: 
            uf.union(s, t)
        else:
            uf.move(s, t)
    
if __name__ == "__main__":
    main()
```

To implement path compression we make each node point directly of its representative element during the find operation. This reduces the depth of the trees in the data structure. The find operation checks if the element is not pointing to itself (which means it is not root), and updates its own pointer to the root. 

```java
public class UnionFind_wPathCompression {
        
    private int[] arr;

    public UnionFind_wPathCompression(int n) {
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
    }

    private int find(int x) {       // path compression applied here!
        if (arr[x] != x) {
            arr[x] = find(arr[x]);
        }
        return arr[x];
    }

    private void query(int s, int t) {
        int res;
        if (arr[s] == arr[t]) {
            res = 1;
        } else res = 0;
        System.out.println(res);
    }

    private void union(int s, int t) {
        int sID = find(s), tID = find(t);
        if (sID == tID) { return; }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == sID) arr[i] = tID;
        }
    }

    private void move(int s, int t) {
        if (arr[s] == arr[t]) { return; } 
        arr[s] = arr[t];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] fln = scanner.nextLine().split(" ");
        int n = Integer.parseInt(fln[0]), m = Integer.parseInt(fln[1]);

        UnionFind_wPathCompression uf =  new UnionFind_wPathCompression(n);

        // add instructions
        int[][] ins = new int[m][3];
        for (int i = 0; i < m; i++) {
            String[] str = scanner.nextLine().split(" ");
            int[] nums = new int[] { 
                Integer.parseInt(str[0]),
                Integer.parseInt(str[1]),
                Integer.parseInt(str[2]),
            };
            ins[i] = nums;
        }

        scanner.close();

        for (int i = 0; i < ins.length; i++) {
            int o = ins[i][0], s = ins[i][1], t = ins[i][2]; 
            switch (o) {
                case 0: uf.query(s, t); break;
                case 1: uf.union(s, t); break;
                case 2: uf.move(s, t);  break;
            }   
        }
    }
}
```

Python implementation with path compression equivalent to the java code above:

```python
class UnionFind_wPathCompression(object):
    def __init__(self, n: int) -> None:
        arr = []
        for i in range(n):
            arr.append(i)
        self.arr = arr
    
    def find(self, x: int) -> int:
        if self.arr[x] != x:
            self.arr[x] = self.find(self.arr[x])
        return self.arr[x]
    
    def query(self, s: int, t: int) -> None:
        print(1 if self.arr[s] == self.arr[t] else 0)
        
    def union(self, s: int, t: int) -> None:
        sID, tID = self.find(s), self.find(t)
        if sID == tID: 
            return
        for i in range(len(self.arr)):
            if self.arr[i] == sID:
                self.arr[i] = tID
    
    def move(self, s: int, t: int) -> None:
        if self.arr[s] == self.arr[t]:
            return
        self.arr[s] = self.arr[t]

def main():
    fln = input().split(' ')
    n,m = int(fln[0]), int(fln[1])
    uf = UnionFind_wPathCompression(n)
    
    ins = []
    for i in range(m):
        str = input().split(' ')
        ins.append([
            int(str[0]), 
            int(str[1]), 
            int(str[2])
        ])
    
    for i in range(len(ins)):
        o,s,t = ins[i][0], ins[i][1], ins[i][2]
        if o == 0: 
            uf.query(s, t)
        elif o == 1: 
            uf.union(s, t)
        else:
            uf.move(s, t)
    
if __name__ == "__main__":
    main()
```


### Bonus F# verison 

```fsharp
open System

type UnionFind(n: int) =
    let arr: array<int> = [|0..n-1|]

    member uf.find(x: int) =
        if arr.[x] = x then x
        else
            arr.[x] <- uf.find(arr.[x])
            arr.[x]
    
    member uf.query(s: int, t: int) =
        let mutable res: int = 0
        if uf.find(s) = uf.find(t) then
            res <- 1
        printfn "%d" res

    member uf.union(s: int, t: int) =
        let sID: int = uf.find(s)
        let tID: int = uf.find(t)
        if sID <> tID then
            arr.[sID] <- tID 

    member uf.move(s: int, t: int) =
        let sID: int = uf.find(s)
        let tID: int = uf.find(t)
        if sID <> tID then
            arr.[s] <- tID

let n, m = 
    let fln = Console.ReadLine().Split() |> Array.map int
    fln.[0], fln.[1]

let uf: UnionFind = UnionFind(n)

let ins = 
    [ for _ in 1..m do
        let ln = Console.ReadLine().Split() |> Array.map int
        ln.[0], ln.[1], ln.[2] ]

for i in ins do
    match i with
    | 0, s, t -> uf.query(s, t)
    | 1, s, t -> uf.union(s, t)
    | 2, s, t -> uf.move(s, t)
    | _ -> failwith "invalid instruction"
```
