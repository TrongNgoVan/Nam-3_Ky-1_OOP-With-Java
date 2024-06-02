import java.util.Arrays;
import java.util.Scanner;

public class J05033_Sap_xep_thoi_gian {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] a = new int[n][3];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < 3; j++)
                a[i][j] = sc.nextInt();
        Arrays.sort(a, (o1, o2) -> (o1[0] < o2[0] || (o1[0] == o2[0] && o1[1] < o2[1]) || (o1[0] == o2[0] && o1[1] == o2[1] && o1[2] < o2[2]) ? -1 : 1));
        for (int[] i: a) {
            for (int j : i)
                System.out.print(j + " ");
            System.out.println();
        }
        sc.close();
    }
}
