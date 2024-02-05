package java.handins.disjointSets;

import java.util.Scanner;

public class UnionFind_wPathCompression {
        
    private int[] arr;

    public UnionFind_wPathCompression(int n) {
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
    }

    private int find(int x) {       // path compression applied here!
        if (arr[x] != x) {
            arr[x] = find(arr[x]);
        }
        return arr[x];
    }

    private void query(int s, int t) {
        int res;
        if (arr[s] == arr[t]) {
            res = 1;
        } else res = 0;
        System.out.println(res);
    }

    private void union(int s, int t) {
        int sID = find(s), tID = find(t);
        if (sID == tID) { return; }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == sID) arr[i] = tID;
        }
    }

    private void move(int s, int t) {
        if (arr[s] == arr[t]) { return; } 
        arr[s] = arr[t];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] fln = scanner.nextLine().split(" ");
        int n = Integer.parseInt(fln[0]), m = Integer.parseInt(fln[1]);

        UnionFind_wPathCompression uf =  new UnionFind_wPathCompression(n);

        // add instructions
        int[][] ins = new int[m][3];
        for (int i = 0; i < m; i++) {
            String[] str = scanner.nextLine().split(" ");
            int[] nums = new int[] { 
                Integer.parseInt(str[0]),
                Integer.parseInt(str[1]),
                Integer.parseInt(str[2]),
            };
            ins[i] = nums;
        }

        scanner.close();

        for (int i = 0; i < ins.length; i++) {
            int o = ins[i][0], s = ins[i][1], t = ins[i][2]; 
            switch (o) {
                case 0: uf.query(s, t); break;
                case 1: uf.union(s, t); break;
                case 2: uf.move(s, t);  break;
            }   
        }
    }
}
