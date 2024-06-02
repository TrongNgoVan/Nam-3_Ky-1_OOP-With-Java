import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Luyen_tap_lap_trinh {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("LUYENTAP.in"));
        ArrayList<SinhVien> st = new ArrayList<>();
        int t = sc.nextInt();
        while (t-- > 0) {
            sc.nextLine();
            st.add(new SinhVien(sc.nextLine(), sc.nextInt(), sc.nextInt()));
        }
        Collections.sort(st);
        st.forEach(System.out::println);
        sc.close();
    }
}

class SinhVien implements Comparable<SinhVien> {
    String name;
    int ac, submit;

    public SinhVien(String name, int ac, int submit) {
        this.name = name;
        this.ac = ac;
        this.submit = submit;
    }

    @Override
    public String toString() {
        return name + " " + ac + " " + submit;
    }
    
    @Override
    public int compareTo (SinhVien o) {
        if (ac == o.ac) 
            return (this.submit == o.submit) ? this.name.compareTo(o.name) : (this.submit - o.submit);
        return o.ac - this.ac;
    }
}