import java.util.Scanner;

public class J03018_Tim_so_du {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            s = s.length() > 2 ? s.substring(s.length()-2) : s;
            int n = Integer.parseInt(s);
            System.out.println(n%4 == 0 ? 4 : 0);
        }
        sc.close();
    }
}
