import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class J07008_Day_con_tang_dan {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("DAYSO.in"));
        int n = Integer.parseInt(sc.nextLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = Integer.parseInt(sc.next());
        Subsequence sb = new Subsequence(n, a);
        sb.solution();
        sc.close();
    }
}

class Subsequence {
    int n;
    ArrayList<String> res;
    int[] bin, a;

    public Subsequence(int n, int[] a) {
        this.n = n;
        this.a = a;
        bin = new int[n];
        res = new ArrayList<>();
    }

    void isDecreasing() {
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++)
            if (bin[i] == 1)
                arr.add(a[i]);
        if (arr.size() <= 1)
            return;
        for (int i = 1; i < arr.size(); i++)
            if (arr.get(i) <= arr.get(i - 1))
                return;
        String tmp = "";
        for (Integer i : arr)
            tmp += i + " ";
        res.add(tmp);
    }

    void Try(int i) {
        for (int j = 0; j <= 1; j++) {
            bin[i] = j;
            if (i == n - 1) 
                isDecreasing();
            else Try(i+1);
        }
    }

    void solution () {
        Try(0);
        res.sort((s1, s2) -> s1.compareTo(s2));
        res.forEach(System.out::println);
    }
}
