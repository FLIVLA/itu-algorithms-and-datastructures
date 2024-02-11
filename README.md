# ITU - Algorithms and Datastructures

## Exercises

* [Week 1 - Union Find](./exercise/week1.md)
* [Week 2 - The Basic Data Structure](./exercise/week2.md)
* [Week 3 - Stacks and Queues]()
* [Week 4 - Analysis of Algorithms]()
* [Week 5 - Sorting, Mergesort]()
* [Week 6 - Priority Queues]()
* [Week 7 - Graphs, DFS, and BFS]()
* [Week 8 - Shortest Paths]()
* [Week 9 - Symbol Tables]()
* [Week 10 - Search Trees and Tries]()
* [Week 11 - Amortized Analysis]()
* [Week 12 - Strings, Radix Sort, and Quicksort]()
* [Week 13 - MST]()

## Course Quizzes

* [Week 1 - Union Find](./course-quizzes/week1-union-find.md)
* [Week 3 - Stacks and Queues](./course-quizzes/week3-stacks-and-queues.md)

## Hand-ins

Test script templates for testing hand-in solutions with provided test cases. Replace <*> with actual values.

### Powershell

```ps1
cd <solutiondir>
Get-Content <inputFile> | <lang> <solutionFile>
```
```ps1
$inFiles = Get-ChildItem -Path . -Filter *.in
foreach ($file in $inFiles) {
    Get-Content $file.FullName | <lang> <solutionFile>
}
```

### Bash
```bash
cd <solutionDir>
cat <inputFile> | <lang> <solutionFile>
```
```bash
#!/bin/bash

inFiles=$(find . -maxdepth 1 -type f -name "*.in")
for file in $inFiles; do
    echo "Test case $file"
    cat "$file" | <lang> <solutionFile>
done
```

<br/>

1. [Disjoint Sets](./hand-ins/01-disjoint-sets.md)
    * [java](./java-solutions/handins/disjointSets/UnionFind.java)
    * [java (w. path compression)](./java-solutions/handins/disjointSets/UnionFind_wPathCompression.java)
    * [Python](./python/handins/disjointSets/disjointSets.py)
    * [Python (w. path compression)](./python/handins/disjointSets/disjointSets_wPathCompression.py)
    * [F#](./java-solutions/handins/disjointSets/)
2. [Fixed Length Sequences](./hand-ins/02-fixed-length-sequences.md)
    * [A - Atlögur](./hand-ins/02-fixed-length-sequences.md/#problem-a---atlögur-⚔️)
        - [Java](./java-solutions//handins/fixedLengthSequences/Atlogur/Atlogur.java)
        - [Python](./python/handins/fixedLengthSequences/Atlogur/Atlogur.py)
        - [F#](./fsharp/handins/fixedLengthSequences/Atlogur/Atlogur.fsx)
    * [B - Coffee Cup Combo](./hand-ins/02-fixed-length-sequences.md/#problem-b---coffee-cup-combo-☕)
        - [Java](./java-solutions/handins/fixedLengthSequences/CoffeeCupCombo/CoffeeCupCombo.java)
        - [Python](./python/handins/fixedLengthSequences/CoffeeCupCombo/CoffeeCupCombo.py)
        - [F#](./fsharp/handins/fixedLengthSequences/CoffeeCupCombo/CoffeeCupCombo.fsx)
    * [C - Zoom](./hand-ins/02-fixed-length-sequences.md/#problem-c---zoom-🔢)
        - [Java](./java-solutions/handins/fixedLengthSequences/Zoom/Zoom.java)
        - [Python](./python/handins/fixedLengthSequences/Zoom/Zoom.py)
        - [F#](./fsharp/handins/fixedLengthSequences/Zoom/Zoom.fsx)
    * [D - Howl](./hand-ins/02-fixed-length-sequences.md/#problem-d---howl-🐺)
        - [Java](./java-solutions/handins/fixedLengthSequences/Howl/Howl.java)
        - [Python](./python/handins/fixedLengthSequences/Howl/Howl.py)
        - [F#](./fsharp/handins/fixedLengthSequences/Howl/Howl.fsx)
    * [E - Bit by Bit](./hand-ins/02-fixed-length-sequences.md/#problem-e---bit-by-bit-🖳)
        - [Java](./java-solutions/handins/fixedLengthSequences/BitByBit/BitByBit.java)
        - [Python](./python/handins/fixedLengthSequences/BitByBit/BitByBit.py)
3. [Balance](./hand-ins/03-balance.md)
    - [Java](./java-solutions/handins/balance/Balance.java)
    - [Python](./python/handins/balance/Balance.py)
    - [F#](./fsharp/handins/balance/Balance.fsx)
4. [Grades](./hand-ins/04-grades.md)
5. [Seat Allocation](./hand-ins/05-seat-allocation.md)
6. [Harmony and Conflict](./hand-ins/06-harmony-and-conflict.md)
7. [Flights](./hand-ins/07-flights.md)


<!-- ### Exams

1. [May] -->