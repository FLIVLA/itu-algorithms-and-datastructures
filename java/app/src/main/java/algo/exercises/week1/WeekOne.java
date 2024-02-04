package algo.exercises.week1;

public class WeekOne {

    //#region Exercise 1.1.14

    // calculating power of x without math lib
    private static double pow(double x, int power) {
        if (power == 0) return 1;
        double result = 1;

        if (power > 0) {
            while (power != 0) {
                result *= x;
                power--;
            }
        } else {
            while (power < 0) {
                result /= x;
                power++;
            }
        }
        return result;
    }

    /**
     * Exercise 1.1.14 solution
     * @param N input integer
     * @return largest integer that is not larger than the base-2 logarithm of N
     */
    public static int lg(int N) {
        if (N <= 0) {
            throw new IllegalArgumentException("N must be a positive integer");
        } 
        int result = -1;
        while (N > 0) {
            N /= 2;
            result++;
        }
        return result;
    }

    //#endregion

    public static void main(String[] args) {
        double s = pow(2, -4);
        System.out.println(s);
    }
}
