import java.util.Scanner;

public class J3007_So_dep_2 {
    static boolean sum(StringBuilder s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum += s.charAt(i) - '0';
        }
        return sum % 10 == 0;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            StringBuilder s = new StringBuilder(sc.nextLine());
            System.out.println(s == s.reverse() && s.toString().matches("^8.*8$") && sum(s) ? "YES" : "NO");
        }
        sc.close();
    }
}
