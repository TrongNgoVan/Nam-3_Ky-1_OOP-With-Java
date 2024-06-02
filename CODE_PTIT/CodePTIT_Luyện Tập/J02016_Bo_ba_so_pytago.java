import java.util.*;

public class J02016_Bo_ba_so_pytago {
    static boolean check (long[] a, int n) {
        Arrays.sort(a);
        int i = n-1, j = i - 1, k = 0;
        while (j > k) {
            if (a[i] == a[j] + a[k])    return true;
            if (a[i] > a[j] + a[k]) {
                k++;
            }
            else if (a[i] < a[j] + a[k]) {
                j--;
            }
            if (j == k) {
                i--;
                j = i-1;
                k = 0;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
                a[i] *= a[i];
            }
            System.out.println(check(a, n) ? "YES" : "NO");
        }
        sc.close();
    }
}
