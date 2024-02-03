package algo.exercises.preparation;

import java.util.Scanner;

public class EchoEchoEcho {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String w = scanner.next(), s = "";

        for (int i = 0; i < 3; i++) {
            s += w + " ";
        }
        scanner.close();
        System.out.println(s);
    }
}
