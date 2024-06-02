import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class J02012_Sap_xep_chen {
    static void printArr (ArrayList<Integer> a, int step) {
        System.out.printf("Buoc %d:", step);
        for (int i : a)
            System.out.print(" " + i);
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();
        for (int i = 0; i < n; i++) 
            a.add(sc.nextInt());
        for (int i = 0; i < n; i++) {
            b.add(a.get(i));
            Collections.sort(b);
            printArr(b, i);
        }
        sc.close();
    }
}
