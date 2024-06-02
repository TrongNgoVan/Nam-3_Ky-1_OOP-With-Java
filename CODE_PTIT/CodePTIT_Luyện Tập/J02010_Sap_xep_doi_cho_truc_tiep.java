import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class J02010_Sap_xep_doi_cho_truc_tiep {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> a = new ArrayList<>();
        for (int i = 0; i < n; i++)
            a.add(sc.nextInt());
        for (int i = 0; i < n - 1; i++) {
            System.out.printf("Buoc %d:", i + 1);
            for (int j = i + 1; j < n; j++) {
                if (a.get(i) > a.get(j))
                    Collections.swap(a, i, j);
            }
            for (int k : a)
                System.out.print(" " + k);
            System.out.println();
        }
        sc.close();
    }
}
