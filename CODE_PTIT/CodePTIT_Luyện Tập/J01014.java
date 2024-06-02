import java.util.Scanner;

public class J01014 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        while (t-- > 0) {
            Long n = input.nextLong();
            int i = 2, res = 0;
            while (i <= Math.sqrt(n)) {
                if (n%i == 0)   res = i;
                while (n%i == 0) {
                    n /= i;
                }
                i++;
            }
            System.out.println(n != 0 ? Math.max(n, res) : res);
        }
        input.close();
    }
}
