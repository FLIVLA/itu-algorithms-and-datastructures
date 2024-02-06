class Howl(object):
    def __init__(self, h: str):
        self.n = len(h) + 1
        self.H = [''] * self.n
    
    def super_awesome_howl(self) -> str:
        lim: int = self.n - 3
        next = 'A'
        for i in range(lim):
            self.H[i] = next
            if next == 'A':
                next = 'W'
            else: next = 'A'
        self.H[lim] = 'H'
        for i in range(lim + 1, len(self.H)):
            self.H[i] = 'O'
        return "".join(self.H)

def main():
    h: str = input()
    howl = Howl(h)
    print(howl.super_awesome_howl())
    
if __name__ == "__main__":
    main()

