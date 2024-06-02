import java.util.Scanner;

public class J03015_Hieu_so_nguyen_lon_2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println(input.nextBigInteger().subtract(input.nextBigInteger()));
        input.close();
    }
}
