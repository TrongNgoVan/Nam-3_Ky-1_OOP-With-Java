import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class J02013_Sap_xep_noi_bot {
    static void printArr (ArrayList<Integer> a, int step) {
        System.out.printf("Buoc %d:", step);
        for (int i : a)
            System.out.print(" " + i);
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), step = 0;
        ArrayList<Integer> a = new ArrayList<>();
        for (int i = 0; i < n; i++) 
            a.add(sc.nextInt());
        for (int i = 0; i < n; i++) {
            boolean isSorted = false;
            for (int j = 0; j < n - i - 1; j++)
                if (a.get(j) > a.get(j+1)) {
                    Collections.swap(a, j+1, j);
                    isSorted = true;
                }
            if (isSorted)
                printArr(a, ++step);
        }
        sc.close();
    }
}
