import java.util.Scanner;

public class J02106_Ma_tran_nhi_phan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), res = 0;
        int[][] a = new int[n+1][4];
        for (int i = 1; i <= n; i++) 
            for (int j = 1; j <= 3; j++)
                a[i][j] = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            int zero = 0, one = 0;
            for (int j = 1; j <= 3; j++) {
                if (a[i][j] == 0)   zero++;
                else    one++;
            }
            if (one > zero) ++res;
        }
        System.out.println(res);
        sc.close();
    }
}
