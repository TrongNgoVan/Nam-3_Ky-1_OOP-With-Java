import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class J07022_Loai_bo_so_nguyen {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("DATA.in"));
        ArrayList<String> arr= new ArrayList<>();
        while (sc.hasNext()) {
            String tmp = sc.next();
            try {
                Integer.valueOf(tmp);
            }
            catch (NumberFormatException e) {
                arr.add(tmp);
            }
        }   
        arr.sort((a, b) -> a.compareTo(b));
        arr.forEach(n -> System.out.print(n + " "));
        sc.close();
    }
}
