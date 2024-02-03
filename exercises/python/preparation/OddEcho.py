from typing import List

class OddEcho:
    def main() -> None:
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

OddEcho.main()  # run the function