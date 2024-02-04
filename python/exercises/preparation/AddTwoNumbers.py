from typing import List

def add_two_numbers() -> None:
    chars: List[str] = input().split(' ')
    a, b = int(chars[0]), int(chars[1])
    print(a + b)

add_two_numbers()