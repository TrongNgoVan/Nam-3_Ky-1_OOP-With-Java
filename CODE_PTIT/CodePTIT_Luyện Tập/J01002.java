import java.util.Scanner;

public class J01002 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        while (t-- > 0) {
            long n = input.nextLong();
            System.out.println(n * (n + 1) / 2);
        }
        input.close();
    }
}
