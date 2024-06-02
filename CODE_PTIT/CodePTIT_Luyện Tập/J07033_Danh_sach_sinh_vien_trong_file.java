import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class J07033_Danh_sach_sinh_vien_trong_file {
    public static void main(String[] args) throws FileNotFoundException, ParseException {
        Scanner sc = new Scanner(new File("SINHVIEN.in"));
        ArrayList<SinhVien> sv = new ArrayList<>();
        int n = Integer.parseInt(sc.nextLine());
        while (n-- > 0)
            sv.add(new SinhVien(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine()));
        sv.sort((sv1, sv2) -> sv1.getId().compareToIgnoreCase(sv2.getId()));
        sv.forEach(System.out::println);
        sc.close();
    }
}

class SinhVien {
    String id, name, className, email;

    public String getId() {
        return this.id;
    }

    public SinhVien(String id, String name, String className, String email) {
        this.id = id;
        this.name = formatName(name);
        this.className = className;
        this.email = email;
    }

    String formatName(String name) {
        String[] tmp = name.trim().split("\\s+");
        for (int i = 0; i < tmp.length; i++)
            tmp[i] = tmp[i].substring(0, 1).toUpperCase() + tmp[i].substring(1).toLowerCase();
        return String.join(" ", tmp);
    }

    @Override
    public String toString() {
        return id + " " + name + " " + className + " " + email;
    }
}