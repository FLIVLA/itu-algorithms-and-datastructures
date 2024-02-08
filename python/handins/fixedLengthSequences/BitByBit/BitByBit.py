class BitByBit:
    def __init__(self):
        self.lns = []
    
    def execute(self, N: int, seq: [str]):
        reg = ['?' for _ in range(32)]
        for n in range(N):
            s = seq[n].split()
            ins = s[0]
            i = int(s[1])
            if ins == "CLEAR":
                reg[i] = '0'
            elif ins == "SET":
                reg[i] = '1'
            else:
                j = int(s[2])
                res = ''
                for b1, b2 in zip(reg[i], reg[j]):
                    if b1 == '?' or b2 == '?':
                        res += '?'
                    else:
                        if ins == "OR":
                            res += str(int(b1) | int(b2)) 
                        else: 
                            res += str(int(b1) & int(b2)) 
                reg[i] = res
        reg = reg[::-1]
        self.lns.append("".join(reg))
    
    def print_result(self):
        for i in range(len(self.lns)):
            print(self.lns[i])

def main():
    b = BitByBit()
    n = int(input())
    while n != 0:
        seq = [None] * n
        for i in range(n):
            seq[i] = input()
        b.execute(n, seq)
        n = int(input())
    b.print_result()
        
if __name__ == "__main__":
    main()
