import java.util.*;

public class J02102_Ma_tran_xoan_oc_tang_dan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] a = new int[n][n];
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) 
            for (int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
                list.add(a[i][j]);
            }
        list.sort((o1, o2) -> o1.compareTo(o2));
        int d = 0, row = n-1, col = n-1, k = 0;
        while (d <= n/2) {
            for (int i = d; i <= col; i++)
                a[d][i] = list.get(k++);
            for (int i = d+1; i <= row; i++)
                a[i][col] = list.get(k++);
            for (int i = col - 1; i >= d; i--)
                a[row][i] = list.get(k++);
            for (int i = row - 1; i > d; i--) 
                a[i][d] = list.get(k++);
            row--; col--; d++;          
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}
