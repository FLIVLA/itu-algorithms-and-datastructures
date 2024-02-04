class UnionFind_wPathCompression(object):
    def __init__(self, n: int) -> None:
        arr = []
        for i in range(n):
            arr.append(i)
        self.arr = arr
    
    def find(self, x: int) -> int:
        if self.arr[x] != x:
            self.arr[x] = self.find(self.arr[x])
        return self.arr[x]
    
    def query(self, s: int, t: int) -> None:
        print(1 if self.arr[s] == self.arr[t] else 0)
        
    def union(self, s: int, t: int) -> None:
        sID, tID = self.find(s), self.find(t)
        if sID == tID: 
            return
        for i in range(len(self.arr)):
            if self.arr[i] == sID:
                self.arr[i] = tID
    
    def move(self, s: int, t: int) -> None:
        if self.arr[s] == self.arr[t]:
            return
        self.arr[s] = self.arr[t]

def main():
    fln = input().split(' ')
    n,m = int(fln[0]), int(fln[1])
    uf = UnionFind_wPathCompression(n)
    
    ins = []
    for i in range(m):
        str = input().split(' ')
        ins.append([
            int(str[0]), 
            int(str[1]), 
            int(str[2])
        ])
    
    for i in range(len(ins)):
        o,s,t = ins[i][0], ins[i][1], ins[i][2]
        if o == 0: 
            uf.query(s, t)
        elif o == 1: 
            uf.union(s, t)
        else:
            uf.move(s, t)
    
if __name__ == "__main__":
    main()
            