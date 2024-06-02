package Practice;

import java.util.Scanner;

public class Chuan_hoa_ho_ten {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int choice = sc.nextInt();
            sc.nextLine();
            String[] name = sc.nextLine().toLowerCase().split("\\s+");
            int n = name.length;
            for (int i = 0; i < n; i++) 
                name[i] = name[i].substring(0, 1).toUpperCase() + name[i].substring(1);
            if (choice == 1) {
                System.out.print(name[n-1] + " ");
                for (int i = 0; i < n-1; i++)
                    System.out.print(name[i] + " ");
            }
            else {
                for (int i = 1; i < n; i++)
                    System.out.print(name[i] + " ");
                System.out.print(name[0]);
            }
            System.out.println();
        }
        sc.close();
    }
}
