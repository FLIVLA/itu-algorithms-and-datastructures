import java.util.Scanner;

class UnionFind {
    private int[] P;
    private int[] R;

    public UnionFind(int N) {
        P = new int[N];
        R = new int[N];

        for (int i = 0; i < N; i++) {
            P[i] = i; 
            R[i] = 0;
        }
    }

    public int find(int x) {
        if (P[x] != x) {
            P[x] = find(P[x]);
        }
        return P[x];
    }

    public void union(int a, int b) {
        int aID = find(a), bID = find(b);
        if (aID != bID) {
            if (R[aID] < R[bID]) {
                P[aID] = bID;
            } else if (R[aID] > R[bID]) {
                P[bID] = aID;
            } else {
                P[aID] = bID;
                R[bID]++;
            }
        }
    }

    public String query(int a, int b) {
        return find(a) == find(b) ? "yes" : "no";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(), Q = scanner.nextInt();
        scanner.nextLine();
        UnionFind uf = new UnionFind(N);
        
        String[] ops = new String[Q];
        for (int i = 0; i < Q; i++) {
            ops[i] = scanner.nextLine();
        }
        scanner.close();

        for (int i = 0; i < Q; i++) {
            String[] ln = ops[i].split(" ");
            String o = ln[0];
            int a = Integer.parseInt(ln[1]), b = Integer.parseInt(ln[2]);
            if (o.equals("=")) {
                uf.union(a, b);
            } else {
                System.out.println(uf.query(a, b));
            }
        }
    }
}
