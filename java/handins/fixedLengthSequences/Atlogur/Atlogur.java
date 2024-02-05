package java.handins.fixedLengthSequences.Atlogur;

import java.util.Scanner;

public class Atlogur {
    
    private int n;
    private int[][] K;

    public Atlogur(int n, int[][] K) {
        this.n = n;
        this.K = K;
    }

    private void beginBattles() {
        int i = 0, j = i + 1;
        while (j < n) {
            battle(i, j);
            if (K[i][0] > K[j][0]) {
                j++;
            } else {
                i++; j++;
            }
        }
        int v;
        if (i < n - 1) {
            v = i + 1;
        } else {
            v = j + 1;
        }
        System.out.println(v);
    }

    private void battle(int i, int j) {
        K[j][0] -= K[i][1];
        if (K[j][0] >= 0) {
            battle(j, i);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        int[][] K = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] k = scanner.nextLine().split(" ");
            K[i] = new int[] { Integer.parseInt(k[0]), Integer.parseInt(k[1]) }; // hp/str
        }

        scanner.close();
        Atlogur atl = new Atlogur(n, K);
        atl.beginBattles();
    }
}



/*

sample 1 input

6
12 1
4 3
2 6
3 4
1 12
6 2



5
14 3
43 6
32 8
13 9
29 5

 */
