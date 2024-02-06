import java.util.Scanner;

class Howl {

    private int n;
    private StringBuilder H;

    public Howl(String f) {
        n = f.length() + 1;
        H = new StringBuilder();
    }

    private String superAwesomeHowl() {
        int lim = n - 3;
        char next = 'A';
        for (int i = 0; i < lim; i++) {
            H.append(next);
            if (next == 'A') next = 'W';
            else next = 'A';
        }
        H.append('H');
        for (int i = lim + 1; i < n; i++) {
            H.append('O');
        }
        return H.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String f = scanner.next();
        scanner.close();
        Howl howl = new Howl(f);
        System.out.println(howl.superAwesomeHowl());
    }
}
