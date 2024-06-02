import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Tinh_tong_so_long {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("DATA.in"));
        long sum = 0;
        while (sc.hasNext()) {
            String n = sc.next();
            try {
                Integer.parseInt(n);
            } catch (NumberFormatException err) {
                try {
                    sum += Long.parseLong(n);
                } catch (NumberFormatException err2) {}
            }
        }
        System.out.println(sum);
        sc.close();
    }
}
