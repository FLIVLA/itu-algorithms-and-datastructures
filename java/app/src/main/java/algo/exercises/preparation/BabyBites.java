package algo.exercises.preparation;

import java.util.Scanner;

public class BabyBites {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        String[] words = scanner.nextLine().split(" ");
        scanner.close();

        String res = "makes sense";
        for (int i = 0; i < n; i++) {
            if (!words[i].equals("mumble") && Integer.parseInt(words[i]) != i + 1) {
                res = "something is fishy";
                break;
            }
        }
        System.out.println(res);
    }
}
