import java.util.Scanner;

public class J02004 {
    static Scanner input = new Scanner(System.in);
    static String test_case () {
        int n = input.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = input.nextInt();
        for (int i = 0; i <= n/2; i++)
            if (a[i] != a[n-1-i])   
                return "NO";
        return "YES";
    }
    public static void main(String[] args) {
        int t = input.nextInt();
        while (t-- > 0) 
            System.out.println(test_case());
    }
}
