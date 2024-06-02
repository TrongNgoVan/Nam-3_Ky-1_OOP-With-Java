import java.util.Scanner;

public class J02101_In_ma_tran {
    static Scanner sc = new Scanner(System.in);
    static void test_case() {
        int n = sc.nextInt();
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) 
                a[i][j] = sc.nextInt();
        for (int i = 0; i < n; i++) {
            if (i%2 == 0)
                for (int j = 0; j < n; j++)
                    System.out.print(a[i][j] + " ");
            else 
                for (int j = n-1; j >= 0; j--)
                    System.out.print(a[i][j] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int t = sc.nextInt();
        while (t-- > 0)
            test_case();
    }
}
