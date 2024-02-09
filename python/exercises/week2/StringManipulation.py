def b_to_ones(s: str) -> str:
    S = list(s)
    n = len(S)
    for i in range(n):
        if S[i] == 'b':
            S[i] = '1'
    return "".join(S)

def b_to_alt_zeros_ones(s: str) -> str:
    S = list(s)
    n = len(S)
    b = 0                           # track the b's
    for i in range(n):
        if S[i] == 'b':
            S[i] = str(b % 2)       # use modulo to alternate 0 and 1
            b += 1                  # increment b
    return "".join(S)

def main():
    s = input()
    print(b_to_ones(s))
    print(b_to_alt_zeros_ones(s))

if __name__ == "__main__":
    main()