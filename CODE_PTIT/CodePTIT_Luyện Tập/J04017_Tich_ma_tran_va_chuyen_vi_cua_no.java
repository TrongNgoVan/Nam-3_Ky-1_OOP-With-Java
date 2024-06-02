import java.util.*;

public class J04017_Tich_ma_tran_va_chuyen_vi_cua_no {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt(), m = sc.nextInt();
            Matrix a = new Matrix(n, m);
            a.nextMatrix(sc);
            Matrix b = a.trans();
            System.out.println(a.mul(b));
        }
    }
}

class Matrix {
    private int[][] a;
    private int n, m;

    public Matrix(int n, int m) {
        this.a = new int[n][m];
        this.n = n;
        this.m = m;
    }

    public Matrix(int[][] matrix) {
        this.a = matrix;
        this.n = a.length;
        this.m = a[0].length;
    }

    public void nextMatrix(Scanner sc) {
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                a[i][j] = sc.nextInt();
    }

    public int[][] getA() {
        return this.a;
    }

    public int getN() {
        return this.n;
    }

    public int getM() {
        return this.m;
    }

    public Matrix mul(Matrix o) {
        int p = o.getM();
        int[][] b = o.getA();
        int[][] res = new int[n][p];
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < p; k++) {
                for (int j = 0; j < m; j++)
                    res[i][k] += a[i][j] * b[j][k];
            }
        }
        return new Matrix(res);
    }

    public Matrix trans () {
        int[][] b = new int[m][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                b[j][i] = a[i][j];
        return new Matrix(b);
    }

    @Override
    public String toString() {
        String res = "";
        for (int[] i : a) {
            for (int j : i)
                res += j + " ";
            res += "\n";
        }
        return res.trim();
    }

}