def reverse(arr: []) -> []:
    l,r = 0, len(arr) - 1
    while l < r:
        arr[l], arr[r] = arr[r], arr[l]
        l += 1
        r -= 1
    return arr

def main():
    ln = input()
    print(" ".join(reverse(ln.split())))

if __name__ == "__main__":
    main()