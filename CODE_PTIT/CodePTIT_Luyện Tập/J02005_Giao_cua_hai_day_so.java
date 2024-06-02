import java.util.Arrays;
import java.util.Scanner;

public class J02005_Giao_cua_hai_day_so {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        boolean[] mark = new boolean[1005];
        int[] a = new int[n];
        int[] b = new int[m];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            mark[a[i]] = true;
        }
        for (int i = 0; i < m; i++) {
            b[i] = sc.nextInt();
        }
        Arrays.sort(b);
        for (int i = 0; i < m; i++) 
            if (mark[b[i]] == true) {
                System.out.print(b[i] + " ");
                mark[b[i]] = false;
            }
        System.out.println();
        sc.close();
    }
}
