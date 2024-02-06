import java.util.Scanner;

class Zoom {

    private int n;
    private int k;
    private int[] x;    
    
    public Zoom(int n, int k, int[] x) {
        this.n = n;
        this.k = k;
        this.x = x;
    }

    private void display() {
        StringBuilder sb = new StringBuilder();
        for (int i = k - 1; i < n; i += k) {
            sb.append(x[i]).append(" ");
        }
        System.out.println(sb.toString().trim());
    } 

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] fln = scanner.nextLine().split(" ");
        String[] s = scanner.nextLine().split(" ");
        scanner.close();

        int n = Integer.parseInt(fln[0]), k = Integer.parseInt(fln[1]);
        int[] x = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = Integer.parseInt(s[i]); 
        }

        Zoom z = new Zoom(n, k, x);
        z.display();
    }
}
