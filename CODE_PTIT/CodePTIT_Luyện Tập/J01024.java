import java.util.Scanner;

public class J01024 {
    static boolean check (char[] s) {
        for (char i:s) 
            if (i > '2')   return false;
        return true;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        input.nextLine();
        while (t-- > 0) {
            char s[] = input.nextLine().toCharArray();
            System.out.println(check(s) ? "YES" : "NO");
        }
        input.close();
    }
}
