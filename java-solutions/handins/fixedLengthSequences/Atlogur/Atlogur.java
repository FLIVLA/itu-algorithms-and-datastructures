import java.util.Scanner;

class Atlogur {
    
    private int n;
    private int[] h;
    private int[] s;

    public Atlogur(int n, int[] h, int[] s) {
        this.n = n;
        this.h = h;
        this.s = s;
    }

    private void beginBattles() {
        int i = 0, j = 1;
        while (j < n) {
            battle(i, j);
            if (h[j] > h[i]) {
                i = j;
                j++;
            } else j++;
        }
        int w;
        if (h[i] > 0) {
            w = i + 1;
        } else {
            w = j + 1;
        }
        System.out.println(w);
    }

    private void battle(int i, int j) {
        h[j] -= s[i];
        if (h[j] > 0) {
            battle(j, i);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        int[] h = new int[n], s = new int[n];
        for (int i = 0; i < n; i++) {
            String[] k = scanner.nextLine().split(" ");
            h[i] = Integer.parseInt(k[0]); 
            s[i] = Integer.parseInt(k[1]);
        }

        scanner.close();
        Atlogur atl = new Atlogur(n, h, s);
        atl.beginBattles();
    }
}