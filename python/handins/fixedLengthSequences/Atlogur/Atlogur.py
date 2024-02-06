class Atlogur(object):
    def __init__(self, n: int, h: [], s: []):
        self.n = n
        self.h = h
        self.s = s
    
    def begin_battles(self):
        i, j = 0, 1
        while j < self.n:
            self.battle(i, j)
            if self.h[j] > self.h[i]:
                i = j
                j += 1
            else:
                j += 1
        print(i + 1 if self.h[i] > 0 else j + 1) 
    
    def battle(self, i: int, j: int):
        self.h[j] -= self.s[i]
        if self.h[j] > 0:
            self.battle(j, i)
        
def main():
    n: int = int(input())
    H, S = [0] * n, [0] * n 
    for i in range(n):
        h, s = map(int, input().split())
        H[i] = h
        S[i] = s
    atl = Atlogur(n, H, S)
    atl.begin_battles()
    
if __name__ == "__main__":
    main()