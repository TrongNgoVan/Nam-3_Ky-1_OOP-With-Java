import java.util.ArrayList;
import java.util.Scanner;

public class J02034_Bo_sung_day_so {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> a = new ArrayList<>();
        for (int i = 0; i < n; i++)
            a.add(sc.nextInt());
        int max = a.get(n-1);
        if (n == max)
            System.out.println("Excellent!");
        else {
            for (int i = 1; i <= max; i++)
                if (!a.contains(i))
                    System.out.println(i);
        }
        sc.close();
    }
}
