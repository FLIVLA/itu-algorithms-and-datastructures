import java.util.Scanner;

public class StringManipulation {

    static String bToOnes(String s) {
        char[] S = s.toCharArray();
        int n = S.length;
        for (int i = 0; i < n; i++) {
            if (S[i] == 'b') { S[i] = '1'; }
        }
        return new String(S);
    }

    static String bToAltZerosAndOnes(String s) {
        char[] S = s.toCharArray();
        int n = S.length, b = 0;
        for (int i = 0; i < n; i++) {
            if (S[i] == 'b') {
                S[i] = (char) (b % 2);
                b++;
            }
        }
        return new String(S);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        scanner.close();
        System.out.println(StringManipulation.bToOnes(s));
        System.out.println(StringManipulation.bToAltZerosAndOnes(s));
    }
}
