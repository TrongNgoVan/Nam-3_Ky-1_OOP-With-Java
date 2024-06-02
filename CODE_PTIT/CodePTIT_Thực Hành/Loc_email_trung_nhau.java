package Practice;

import java.util.Scanner;
import java.util.TreeSet;

public class Loc_email_trung_nhau {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeSet<String> set = new TreeSet<>();
        while (sc.hasNext()) {
            set.add(sc.next().toLowerCase());
        }
        set.forEach(System.out::println);
        sc.close();
    }
}
