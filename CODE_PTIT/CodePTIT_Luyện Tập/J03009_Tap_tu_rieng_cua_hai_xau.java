import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class J03009_Tap_tu_rieng_cua_hai_xau {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            HashSet<String> set1 = new HashSet<>(Arrays.asList(sc.nextLine().split(" ")));
            HashSet<String> set2 = new HashSet<>(Arrays.asList(sc.nextLine().split(" ")));
            for (String i : set1)
                if (!set2.contains(i))
                    System.out.print(i + " ");
            System.out.println();
        }
        sc.close();
    }
}
