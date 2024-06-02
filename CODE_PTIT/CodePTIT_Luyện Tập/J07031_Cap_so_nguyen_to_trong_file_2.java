import java.util.*;
import java.io.*;

public class J07031_Cap_so_nguyen_to_trong_file_2 {
    public static boolean prime(int n) {
        if (n < 2)
            return false;
        if (n % 2 == 0 && n > 2)
            return false;
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream o = new ObjectInputStream(new FileInputStream("DATA1.in"));
        ArrayList<Integer> data1 = (ArrayList<Integer>) o.readObject();
        int[] m1 = new int[1000005];
        Arrays.fill(m1, 0);
        data1.forEach(e -> m1[e]++);

        o = new ObjectInputStream(new FileInputStream("DATA2.in"));
        ArrayList<Integer> data2 = (ArrayList<Integer>) o.readObject();
        int[] m2 = new int[1000005];
        Arrays.fill(m2, 0);
        data2.forEach(e -> m2[e]++);

        for (int i = 0; i < 1000000 / 2; i++) {
            if (m1[i] > 0 && m1[1000000 - i] > 0 && m2[i] == 0 && m2[1000000 - i] == 0 && prime(i) && prime(1000000 - i)) {
                System.out.println(i + " " + (1000000 - i));
            }
        }
    }
}
