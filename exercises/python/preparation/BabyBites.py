from typing import List

def baby_bites() -> None:
    n: int = int(input())
    words: List[str] = input().split(' ')
    res = True
    for i in range(n):
        if not words[i] == "mumble" and int(words[i]) != i + 1:
            res = False
    print("makes sense" if res else "something is fishy")

baby_bites()
    