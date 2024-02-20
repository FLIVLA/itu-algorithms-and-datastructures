import java.util.Random;

public class ThreeSum {

    public static int sums(int[] n) {
        int N = n.length, c = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                for (int k = j+1; k < N; k++) {
                    if (n[i] + n[j] + n[k] == 0) c++;
                }
            }
        } return c;
    }

    public static double timeTrial(int N) {
        int MAX = 1_000_000;
        Random r = new Random();
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = r.nextInt(2 * MAX) - MAX;
        }
        long startTime = System.currentTimeMillis();
        int sums = sums(a);
        System.out.println("Found " + sums + " for input size " + N);
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    public static void main(String[] args) {
        for (int N = 250; true; N += N) {
            double time = timeTrial(N);
            System.out.println(time/1000);
        }
    }
}