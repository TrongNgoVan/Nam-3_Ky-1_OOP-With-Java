import java.util.Scanner;

public class J01001 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        int b = input.nextInt();
        System.out.println( a <= 0 || b <= 0 ? 0 : ((a + b) * 2 + " " + a * b));
        input.close();
    }
}
