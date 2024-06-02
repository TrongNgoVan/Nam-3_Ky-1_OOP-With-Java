import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Scanner;

public class J07003_Tach_doi_va_tinh_tong {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("DATA.in"));
        String n = sc.next();
        while (n.length() > 1) {
            int index = (int)(n.length()/2);
            n = (new BigInteger(n.substring(0, index)).add(new BigInteger(n.substring(index)))).toString();
            System.out.println(n);
        }
        sc.close();
    }
}
