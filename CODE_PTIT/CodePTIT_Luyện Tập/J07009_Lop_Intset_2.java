import java.io.*;
import java.util.*;

public class J07009_Lop_Intset_2 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("DATA.in"));
        // Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt(), a[] = new int[n], b[] = new int[m];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        for (int i = 0; i < m; i++)
            b[i] = sc.nextInt();
        IntSet s1 = new IntSet(a);
        IntSet s2 = new IntSet(b);
        IntSet s3 = s1.intersection(s2);
        System.out.println(s3);
    }
}

class IntSet {
    private TreeSet<Integer> set;

    public IntSet(int[] arr) {
        set = new TreeSet<>();
        for (int i = 0; i < arr.length; i++)
            set.add(arr[i]);
    }

    public IntSet(TreeSet<Integer> set) {
        this.set = set;
    }

    public IntSet intersection(IntSet other) {
        set.retainAll(other.set);
        return new IntSet(set);
    }

    @Override
    public String toString() {
        for (int i : set)
            System.out.print(i + " ");
        return "";
    }
}