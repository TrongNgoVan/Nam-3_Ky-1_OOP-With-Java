import java.util.*;

public class J02028_Day_con_lien_tiep_tong_bang_k {
    public static boolean isExist (int n, long[] a, long k) {
        for (int i = 0; i <= n; i++)
            if (Arrays.binarySearch(a, i + 1, a.length, a[i] + k) >= 0) {
                return true;
            }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            long k = sc.nextLong();
            long[] a = new long[n+1];
            a[0] = 0;
            for (int i = 1; i <= n; i++) 
                a[i] = a[i-1] + sc.nextLong();
            System.out.println(isExist(n, a, k) ? "YES" : "NO");
        }
        sc.close();
    }
}
