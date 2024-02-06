class CoffeCupCombo(object):
    def __init__(self, n: int, arr: []):
        self.n = n
        self.arr = arr
    
    def max_lectures(self) -> int:
        m,c = 0,0                       # keep track of the max and coffee count
        for i in range(self.n):
            if self.arr[i] == '0':
                if c > 0:
                    m += 1              # increment maxCount
                    c -= 1              # consume 1 cup of coffee
            else:
                m += 1                  # increment maxCount
                c = 2                   # bring lots of coffee
        return m 
    
def main():
    n: int = int(input())
    s: str = input()
    ccbo = CoffeCupCombo(n, list(s))
    print(ccbo.max_lectures())

if __name__ == "__main__":
    main()