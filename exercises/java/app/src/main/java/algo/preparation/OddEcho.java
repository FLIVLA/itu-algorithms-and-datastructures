package algo.preparation;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

class OddEcho {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); 
        List<String> input = new ArrayList<String>();
        while (scanner.hasNextLine()) {
            input.add(scanner.nextLine());
        }

        scanner.close();

        int N = Integer.parseInt(input.get(0));
        for (int i = 1; i <= N; i++) {
            if (i % 2 != 0) {
                System.out.println(input.get(i));
            } 
        }
    }
}
