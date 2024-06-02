package Practice;

import java.util.Arrays;
import java.util.Scanner;

public class Tinh_tong_cac_chu_so {
    static void sum (char[] s) {
        Arrays.sort(s);
        int res = 0;
        for (char i : s) 
            if (i >= '0' && i <= '9')
                res += (i - '0');
            else System.out.print(i);
        System.out.println(res);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0)
            sum(sc.next().toCharArray());
        sc.close();
    }
}
