import java.util.Arrays;
import java.util.Scanner;

public class J02022_So_xa_cach {
    static int n;
    static int[] a, vs;
    static void initial () {
        for (int i = 0; i < n; i++)
            a[i] = i;
        Arrays.fill(a, 0);
    }
    static void printArr () {
        for (int i : a)
            System.out.print(i);
        System.out.println();
    }
    static void backtrack (int i) {
        for (int j = 1; j <= n; j++) {
            if (vs[j] == 0) {
                a[i] = j;
                if (i > 0 && Math.abs(a[i] - a[i-1]) == 1)  continue;
                vs[j] = 1;
                if (i == n-1)   printArr();
                else    backtrack(i+1);
                vs[j] = 0;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            n = sc.nextInt();
            a = new int[n];
            vs = new int[n+5];
            backtrack(0);
        }
        sc.close();
    }
}
