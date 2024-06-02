import java.util.Scanner;

public class J03006_So_dep_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            StringBuffer s = new StringBuffer(sc.nextLine());
            System.out.println(s.toString().matches("[^13579]+") && s == s.reverse() ? "YES" : "NO");
        }
        sc.close();
    }
}
