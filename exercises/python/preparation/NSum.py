from typing import List

class Nsum:
    def sum() -> None:
        N: int = int(input())
        ints: List[str] = input().split(' ')
        sum: int = 0
        for i in range(N):
            sum += int(ints[i])
        print(sum)

Nsum.sum()