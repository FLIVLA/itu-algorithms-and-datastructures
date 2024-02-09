class Reverse {
    public static <T> T[] reverse(T[] arr) {
        int l = 0, r = arr.length - 1;
        while (l < r) {
            T t = arr[l];
            arr[l] = arr[r];
            arr[r] = t;
            l++;
            r--;
        }
        return arr;
    }
}