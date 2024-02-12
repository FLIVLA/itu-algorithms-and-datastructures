# initial approach
def is_rotation_of(s: str, t: str) -> bool:
    S = list(s)
    T = list(t)
    if S == T: return True
    c = 0                                   # for tracking iteration count in while loop
    while S != T:
        last = S[-1]                        # store te last element of S
        for i in range(len(S) - 1, 0, -1):  
            S[i] = S[i-1]
        S[0] = last                         # place last in first position
        if S == T: return True
        c += 1
        if c == len(S): break               # all possibilities have been checked
    return False

def is_rotation_of_concat(s: str, t: str) -> bool:
    tt = t+t
    if s in tt: return True
    return False


print(is_rotation_of("ACTGACG", "TGACGAC"))
print(is_rotation_of_concat("ACTGACG", "TGACGAC"))