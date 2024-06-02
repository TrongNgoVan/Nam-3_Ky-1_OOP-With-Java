import java.util.Scanner;

public class J01006 {
    static Scanner input = new Scanner(System.in);
    static long[] fibo = new long[95];
    static void Init () {
        for (int i = 3; i <= 92; i++)   fibo[i] = 0; 
        fibo[1] = fibo[2] = 1;
        for (int i = 3; i <= 92; i++) 
            fibo[i] = fibo[i-1] + fibo[i-2];
    }
    static void test_case () {
        int n = input.nextInt();
        System.out.println(fibo[n]);
    }
    public static void main(String[] args) {
        Init(); 
        int t = input.nextInt();
        while (t-- > 0)
            test_case();
    }
}
