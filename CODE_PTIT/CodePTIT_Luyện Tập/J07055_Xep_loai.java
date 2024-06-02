import java.util.*;
import java.io.*;

public class J07055_Xep_loai {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("BANGDIEM.in"));
        ArrayList<Student> st = new ArrayList<>();

        int n = Integer.parseInt(sc.nextLine());
        for (int i = 1; i <= n; i++)
            st.add(new Student(i, sc.nextLine(), Double.parseDouble(sc.nextLine()), Double.parseDouble(sc.nextLine()),
                    Double.parseDouble(sc.nextLine())));
        st.sort((a, b) -> a.average == b.average ? a.id.compareTo(b.id) : b.average.compareTo(a.average));
        
        st.forEach(System.out::println);
    }
}

class Student {
    String name, id, rank;
    Double sc1, sc2, sc3, average;

    public Student(int i, String name, Double sc1, Double sc2, Double sc3) {
        this.id = String.format("SV%02d", i);
        this.name = formatName(name);
        this.sc1 = sc1;
        this.sc2 = sc2;
        this.sc3 = sc3;
        this.average = sc1 * .25 + sc2 * .35 + sc3 * .4;
        this.rank = getRank();
    }

    public String formatName(String name) {
        String[] list = name.trim().split("\\s+");
        for (int i = 0; i < list.length; i++)
            list[i] = list[i].substring(0, 1).toUpperCase() + list[i].substring(1).toLowerCase();
        return String.join(" ", list);
    }

    public String getRank () {
        if (average >= 8)   return "GIOI";
        if (average >= 6.5) return "KHA";
        if (average >= 5)   return "TRUNG BINH";
        return "KEM";
    }
    @Override
    public String toString() {
        return id + " " + name + " " + String.format("%.2f", average) + " " + rank;
    }
}