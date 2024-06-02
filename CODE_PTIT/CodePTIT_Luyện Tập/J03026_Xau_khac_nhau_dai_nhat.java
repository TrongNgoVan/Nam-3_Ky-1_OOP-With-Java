import java.util.Scanner;

public class J03026_Xau_khac_nhau_dai_nhat {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        while(t-- > 0) {
            String a = input.next();
            String b = input.next();
            System.out.println(a.equals(b) ? "-1" : Math.max(a.length(), b.length()));
        }
        input.close();
    }
}
