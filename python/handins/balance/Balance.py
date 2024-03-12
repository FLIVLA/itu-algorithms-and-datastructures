class Balance:
    def is_corresponding_elm(self, c1: str, c2: str) -> bool:
        if c1 == '(':
            return c2 == ')'
        elif c1 == '[':
            return c2 == ']'
        elif c1 == '{':
            return c2 == '}'
        else:
            return False

    def is_balanced(self, s: str) -> bool:
        N: int = len(s)
        if N == 0:
            return True             # empty strings are considered balanced
        if N % 2 != 0:
            return False        # if uneven length, s can't be balanced

        w = Stack(N)
        for i in range(N):
            c: str = s[i]
            # if c is opening parenthesis, push!
            if c == '(' or c == '[' or c == '{':
                w.push(c)
            else:
                if w.is_empty():
                    return False       # if empty here, there is imbalance in s
                else:
                    w.pop()                                         # decrement top pointer
                    t: str = w.peek()                               # get top element in stack
                    if not (t == '(' or t == '[' or t == '{') \
                            and self.is_corresponding_elm(t, c):
                        return False                           # imbalance if t is not corresponding elm to c
        return w.is_empty()                                    # if empty, s is balanced


class Stack(object):                                # stack implementation (see p. 135)
    def __init__(self, N: int):
        self.w = [None] * N
        self.t = 0

    def push(self, i: object):
        self.w[self.t] = i
        self.t += 1

    def pop(self) -> object:
        self.t -= 1
        return self.w[self.t]

    def peek(self) -> object:
        return self.w[self.t - 1]

    def is_empty(self) -> bool:
        return self.t == 0


def main():
    s: str = input()
    b = Balance()
    print(1 if b.is_balanced(s) else 0)


if __name__ == "__main__":
    main()
