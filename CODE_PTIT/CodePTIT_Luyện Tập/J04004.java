import java.util.Scanner;

public class J04004 {
   static Scanner input = new Scanner(System.in);
   static long gcd (long a, long b) {
       if (b == 0) return a;
       else    return gcd(b, a%b);
   }
   static void solution (PhanSo a, PhanSo b) {
       PhanSo res = new PhanSo();
       res.setTu(a.getTu()*b.getMau() + a.getMau()*b.getTu());
       res.setMau(a.getMau()*b.getMau());
       long ucln = gcd(res.getTu(), res.getMau());
       System.out.println((res.getTu()/ucln) + "/" + (res.getMau()/ucln));
   }
   public static void main(String[] args) {
       PhanSo a = new PhanSo();
       PhanSo b = new PhanSo();
       a.setTu(input.nextLong());
       a.setMau(input.nextLong());
       b.setTu(input.nextLong());
       b.setMau(input.nextLong());
       solution(a, b);
   }
}
class PhanSo {
   private long tu, mau;

   public long getTu() {
       return this.tu;
   }

   public void setTu(long tu) {
       this.tu = tu;
   }

   public long getMau() {
       return this.mau;
   }

   public void setMau(long mau) {
       this.mau = mau;
   }

}
