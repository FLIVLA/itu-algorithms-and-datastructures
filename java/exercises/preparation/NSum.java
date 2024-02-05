package java.exercises.preparation;

import java.util.Scanner;

public class NSum {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.nextLine();
        String[] ints = scanner.nextLine().split(" ");
        scanner.close();

        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += Integer.parseInt(ints[i]);
        }

        System.out.println(sum);
    }
}
