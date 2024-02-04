package algo.exercises.week1;

public class WeekOne {

    //#region Exercise 1.1.14

    // calculating power of x without math lib
    private static double pow(double N, int power) {
        if (power == 0) return 1;
        double result = 1;

        if (power > 0) {
            while (power != 0) {
                result *= N;
                power--;
            }
        } else {
            while (power < 0) {
                result /= N;
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
        int res = 1;

        return 0;
    }

    //#endregion

    public static void main(String[] args) {
        double s = pow(2, -4);
        System.out.println(s);
    }
}
