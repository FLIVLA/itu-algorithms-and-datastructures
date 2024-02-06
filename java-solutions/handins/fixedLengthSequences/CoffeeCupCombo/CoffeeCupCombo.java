import java.util.Scanner;

public class CoffeeCupCombo {

    private int n;
    private char[] arr;
    
    public CoffeeCupCombo(int n, char[] arr) {
        this.n = n;
        this.arr = arr;
    }

    private int maxLectures() {
        int m = 0, c = 0;               // keep track of the max and coffee count
        for (int i = 0; i < n; i++) {
            if (arr[i] == '0') {
                if (c > 0) {
                    m++;                // increment maxCount
                    c--;                // consume 1 cup of coffee
                }
            } else {            
                m++;                    // increment maxCount
                c = 2;                  // bring lots of coffee
            }
        } return m;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        String s = scanner.nextLine();
        scanner.close();

        CoffeeCupCombo ccbo = new CoffeeCupCombo(n, s.toCharArray());
        System.out.println(ccbo.maxLectures());
    }
}
