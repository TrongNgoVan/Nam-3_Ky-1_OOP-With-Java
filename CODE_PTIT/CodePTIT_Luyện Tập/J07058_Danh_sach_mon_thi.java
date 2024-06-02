import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class J07058_Danh_sach_mon_thi {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("MONHOC.in"));
        int n = sc.nextInt();
        sc.nextLine();
        ArrayList<Subjects> sj = new ArrayList<>();
        for (int i = 0; i < n; i++) 
            sj.add(new Subjects(sc.nextLine(), sc.nextLine(), sc.nextLine()));
        sj.sort((a, b) -> a.getId().compareTo(b.getId()));
        sj.forEach(System.out::println);
    }
}

class Subjects {
    String id, name, format;

    public String getId() {
        return this.id;
    }

    public Subjects(String id, String name, String format) {
        this.id = id;
        this.name = name;
        this.format = format;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + format;
    }

}