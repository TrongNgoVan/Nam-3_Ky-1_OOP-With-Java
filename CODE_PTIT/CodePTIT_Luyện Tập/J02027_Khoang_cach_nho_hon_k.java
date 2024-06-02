import java.util.*;

public class J02027_Khoang_cach_nho_hon_k {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = sc.nextInt();
            Arrays.sort(a);
            long res = 0;
            for (int i = 0; i < n-1; i++) {
                int lb = Arrays.binarySearch(a, i+1, n, a[i] + k);
                if (lb < 0) lb = Math.abs(lb) - 1;
                else { // check if the number is present multiple times or not
                    int y = a[lb];
                    while (a[lb-1] == y)
                        lb--;
                }
                res += lb - i - 1;
            }
            System.out.println(res);
        }
        sc.close();
    }
}
