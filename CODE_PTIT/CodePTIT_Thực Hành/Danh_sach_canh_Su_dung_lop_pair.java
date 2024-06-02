import java.util.*;

public class Danh_sach_canh_Su_dung_lop_pair {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] a = new int[n+1][n+1];
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= n; j++)
                a[i][j] = sc.nextInt();
        for (int i = 1; i <= n; i++)
            for (int j = i + 1; j <= n; j++) {
                if (a[i][j] == 1) {
                    System.out.println(new Pair<Integer, Integer>(i, j));
                    a[i][j] = a[j][i] = 0;
                }
            }
        sc.close();
    }
}

class Pair <T, S> {
    T x;
    S y;

    public Pair(T x, S y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }
}
// 6
// 0 1 1 0 1 0
// 1 0 1 0 1 0
// 1 1 0 1 0 0
// 0 0 1 0 1 1
// 1 1 0 1 0 1
// 0 0 0 1 1 0