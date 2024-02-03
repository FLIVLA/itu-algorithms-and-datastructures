from typing import List

class AddTwoNumbers:
    def add() -> None:
        chars: List[str] = input().split(' ')
        a, b = int(chars[0]), int(chars[1])
        print(a + b)

AddTwoNumbers.add()