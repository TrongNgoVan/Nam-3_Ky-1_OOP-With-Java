import java.util.*;
import java.io.*;

public class J07054_Tinh_diem_trung_binh {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("BANGDIEM.in"));
        ArrayList<Student> st = new ArrayList<>();

        int n = Integer.parseInt(sc.nextLine());
        for (int i = 1; i <= n; i++)
            st.add(new Student(i, sc.nextLine(), Double.parseDouble(sc.nextLine()), Double.parseDouble(sc.nextLine()), Double.parseDouble(sc.nextLine())));
        st.sort((a, b) -> a.average == b.average ? a.id.compareTo(b.id) : b.average.compareTo(a.average));
        st.get(0).rank = 1;
        for (int i = 1; i < n; i++) {
            st.get(i).rank = (st.get(i).average.compareTo(st.get(i-1).average) == 0) ? st.get(i-1).rank : i+1;
        }
        st.forEach(System.out::println);
    }
}

class Student {
    String name, id;
    Double sj1, sj2, sj3, average;
    int rank;

    public Student(int i, String name, Double sj1, Double sj2, Double sj3) {
        this.id = String.format("SV%02d", i);
        this.name = formatName(name);
        this.sj1 = sj1;
        this.sj2 = sj2;
        this.sj3 = sj3;
        this.average = (sj1 * 3 + sj2 * 3 + sj3 * 2) / 8;
    }

    public String formatName(String name) {
        String[] list = name.trim().split("\\s+");
        for (int i = 0; i < list.length; i++)
            list[i] = list[i].substring(0, 1).toUpperCase() + list[i].substring(1).toLowerCase();
        return String.join(" ", list);
    }

    @Override
    public String toString() {
        return id + " " + name + " " + String.format("%.2f", average) + " " + rank;
    }
}