import java.util.Scanner;

public class J03012_Tong_so_nguyen_lon_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
            System.out.println(sc.nextBigInteger().add(sc.nextBigInteger()));
        sc.close();
    }
}
