import java.util.*;

public class J08012_Hinh_sao {
    public static boolean isValid (int[] mark, int n) {
        for (int i = 1; i <= n; i++)
            if (mark[i] == n-1)   return true;
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] mark = new int[n+2];
        for (int i = 0; i < n-1; i++) {
            int a = sc.nextInt(), b = sc.nextInt();
            mark[a]++;
            mark[b]++;
        }
        System.out.println(isValid(mark, n) ? "Yes" : "No");
        sc.close();
    }
}
