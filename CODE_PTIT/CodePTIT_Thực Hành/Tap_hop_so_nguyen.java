package Practice;

import java.util.TreeSet;
import java.util.Scanner;

public class Tap_hop_so_nguyen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer n = sc.nextInt(), m = sc.nextInt();
        TreeSet<Integer> a = new TreeSet<>();
        TreeSet<Integer> b = new TreeSet<>();
        int[] mark = new int[1005];
        for (int i = 0; i < n; i++) {
            Integer x = sc.nextInt();
            a.add(x);
            mark[x] = 1;
        }
        for (int i = 0; i < m; i++) {
            Integer x = sc.nextInt();
            b.add(x);
            if (mark[x] == 1)
                mark[x] = 3;
            else if (mark[x] == 0)
                mark[x] = 2;
        }

        for (Integer i:b)
            if (mark[i] == 3)
                System.out.print(i + " ");
        System.out.println();
        
        for (Integer i:a)
            if (mark[i] == 1)
                System.out.print(i + " ");
        System.out.println();
        
        for (Integer i:b)
            if (mark[i] == 2)
                System.out.print(i + " ");
        System.out.println();
        sc.close();
    }
}
