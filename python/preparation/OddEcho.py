from typing import List

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

odd_echo()  # run the function