import java.util.Scanner;

public class J02021_Liet_ke_to_hop_2 {
    static int n, k, a[], cou = 0;
    
    static public void combination (int i) {
        for (int j = a[i-1] + 1; j <= n-k+i; j++) {
            a[i] = j;
            if (i == k) {
                for (int l = 1; l <= k; l++)
                    System.out.print(a[l]);
                System.out.print(" ");
                cou++;
            }
            else 
                combination(i + 1);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        a = new int[k + 5];
        combination(1);
        System.out.printf("\nTong cong co %d to hop", cou);
        sc.close();
    }
}
