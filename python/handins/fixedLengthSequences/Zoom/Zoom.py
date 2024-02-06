class Zoom(object):
    def __init__(self, n: int, k: int, x: []):
        self.n = n
        self.k = k
        self.x = x
    
    def display(self):
        res = []
        for i in range(self.k - 1, self.n, self.k):
            res.append(str(self.x[i]))
        print(" ".join(res))
          
def main():
    n,k = map(int, input().split())
    s = input().split(' ')
    x = [0] * n
    for i in range(n):
        x[i] = int(s[i])
    z = Zoom(n, k, x)
    z.display()

if __name__ == "__main__":
    main()