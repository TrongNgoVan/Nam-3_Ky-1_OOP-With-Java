import java.util.Scanner;

public class J01008 {
    static Scanner input = new Scanner(System.in);
    static void solution (long n) {
        int i = 2, cou = 0;
        while (n >= i) {
            while (n % i == 0) {
                n /= i;
                ++cou; 
            }
            if (cou > 0) {
                System.out.print(i + "(" + cou + ") ");
                cou = 0;
            }    
            ++i;
        }
    }
    static void test_case (int t) {
        long n = input.nextLong();
        System.out.print("Test " + t + ": ");
        solution(n);
        System.out.println();
    }
    public static void main(String[] args) {
        int t = input.nextInt();
        for (int i = 1; i <= t; i++)
            test_case(i);
    }
}
