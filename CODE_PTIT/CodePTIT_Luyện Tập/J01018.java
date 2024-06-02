import java.util.Scanner;

public class J01018 {
    static Scanner input = new Scanner(System.in);
    static boolean test_case () {
        char[] n = input.nextLine().toCharArray();
        int sum = 0;
        for (char i:n)  sum += (i - '0');
        if (sum % 10 != 0)  return false;
        for (int i = 1; i < n.length; i++) {
            if (Math.abs(n[i] - n[i-1]) != 2)
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        int t = input.nextInt();
        input.nextLine();
        while (t-- > 0) {
            System.out.println(test_case() ? "YES" : "NO");
        }
    }
}
