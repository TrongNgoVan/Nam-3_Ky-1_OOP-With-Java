import java.util.Scanner;

public class J03032_Dao_tu {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        input.nextLine();
        while (t-- > 0) {
            String[] s = input.nextLine().split("\\s+");
            for (int i = 0; i < s.length; i++) {
                s[i] = new StringBuilder(s[i]).reverse().toString();
            }
            for (String i : s)
                System.out.print(i + " ");
            System.out.println();
        }
        input.close();
    }
}
