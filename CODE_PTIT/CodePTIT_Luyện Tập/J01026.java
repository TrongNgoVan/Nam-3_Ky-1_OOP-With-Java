import java.util.Scanner;

public class J01026 {
    static boolean check (int n) {
        int sqrt = (int)(Math.sqrt(n));
        return sqrt*sqrt == n ? true : false;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        while (t-- > 0) {
            int n = input.nextInt();
            System.out.println(check(n) ? "YES" : "NO");
        }
        input.close();
    }
}
