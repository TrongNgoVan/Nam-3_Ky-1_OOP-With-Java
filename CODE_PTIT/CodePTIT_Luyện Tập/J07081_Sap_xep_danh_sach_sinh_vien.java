import java.util.*;
import java.io.*;

public class J07081_Sap_xep_danh_sach_sinh_vien {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("SINHVIEN.in"));
        ArrayList<Student> list = new ArrayList<>();
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) 
            list.add(new Student(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine()));
        list.sort((a, b) -> {
            if (a.getFirstName().compareTo(b.getFirstName()) != 0)
                return a.getFirstName().compareTo(b.getFirstName());
            if (a.getLastName().compareTo(b.getLastName()) != 0)
                return a.getLastName().compareTo(b.getLastName());
            if (a.getMidName().compareTo(b.getMidName()) != 0)
                return a.getMidName().compareTo(b.getMidName());
            return a.getId().compareTo(b.getId());
        });
        list.forEach(System.out::println);
    }
}

class Student {
    private String id, phone, email, firstName, midName, lastName, name;

    public Student(String id, String name, String phone, String email) {
        this.id = id;
        this.phone = phone;
        this.email = email;
        this.name = name;
        String[] s = name.split("\\s+");
        this.firstName = s[s.length - 1];
        this.lastName = s[0];
        this.midName = String.join(" ", Arrays.copyOfRange(s, 1, s.length - 1));
    }

    public String getId() {
        return this.id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getMidName() {
        return this.midName;
    }

    public String getLastName() {
        return this.lastName;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + phone + " " + email;
    }

}