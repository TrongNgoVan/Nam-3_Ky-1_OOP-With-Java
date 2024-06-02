import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class J02011_Sap_xep_chon {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> a = new ArrayList<>();
        for (int i = 0; i < n; i++)
            a.add(sc.nextInt());
        for (int i = 0; i < n - 1; i++) {
            int index = i;
            for (int j = i + 1; j < n; j++)
                if (a.get(index) > a.get(j))
                    index = j;
            Collections.swap(a, i, index);
            System.out.printf("Buoc %d:", i + 1);
            for (int k : a)
                System.out.print(" " + k);
            System.out.println();
        }
        sc.close();
    }
}
