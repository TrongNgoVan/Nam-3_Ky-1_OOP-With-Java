import java.util.Scanner;

public class J04003 {
    static Scanner input = new Scanner(System.in);
    static long gcd (long a, long b) {
        if (b == 0) return a;
        else    return gcd(b, a%b);
    }
    static void output (PhanSo a) {
        long ucln = gcd (a.getTu(), a.getMau());
        System.out.println((a.getTu() / ucln) + "/" + (a.getMau()/ucln));
    }
    public static void main(String[] args) {
        PhanSo a = new PhanSo();
        a.setTu(input.nextLong());
        a.setMau(input.nextLong());
        output (a);
    }
}
class PhanSo {
    private long tu, mau;
    public void setTu (Long tu) {
        this.tu = tu;
    }
    void setMau (Long mau) {
        this.mau = mau;
    }
    long getTu () {
        return this.tu;
    }
    long getMau () {
        return this.mau;
    }
}