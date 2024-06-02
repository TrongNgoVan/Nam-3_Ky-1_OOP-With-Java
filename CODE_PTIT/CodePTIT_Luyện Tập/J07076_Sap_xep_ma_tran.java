import java.util.*;
import java.io.*;

public class J07076_Sap_xep_ma_tran {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("MATRIX.in"));
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt(), m = sc.nextInt(), index = sc.nextInt();
            int[][] a = new int[n+5][m+5];
            for (int i = 1; i <= n; i++) 
                for (int j = 1; j <= m; j++)
                    a[i][j] = sc.nextInt();
            int[] col = new int[n];
            for (int i = 1; i <= n; i++)
                col[i-1] = a[i][index];
            Arrays.sort(col);
            for (int i = 1; i <= n; i++)
                a[i][index] = col[i-1];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++)
                    System.out.print(a[i][j] + " ");
                System.out.println();
            }
        }
    }
}
