import java.util.Scanner;

public class J01017 {
    static Scanner input = new Scanner(System.in);
    static void test_case () {
        char[] n = input.nextLine().toCharArray();
        for (int i = 1; i < n.length; i++) {
            if (Math.abs(n[i] - n[i-1]) != 1) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");

    }
    public static void main(String[] args) {
        int t = input.nextInt();
        input.nextLine();
        while (t-- > 0) 
            test_case();
    }
}
