import java.util.*;
import java.text.*;
import java.io.*;

public class J07025_Danh_sach_khach_hang_trong_file {
    public static void main(String[] args) throws FileNotFoundException {
        final SimpleDateFormat toDate = new SimpleDateFormat("dd/MM/yyyy");

        Scanner sc = new Scanner(new File("KHACHHANG.in"));
        ArrayList<KH> list = new ArrayList<>();
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 1; i <= n; i++)
            list.add(new KH(i, sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine()));
        list.sort((a, b) -> {
            try {
                return toDate.parse(a.getDob()).compareTo(toDate.parse(b.getDob()));
            } catch (ParseException e) {
                return 0;
            }
        });
        list.forEach(System.out::println);
        sc.close();
    }
}

class KH {
    private String id, name, gender, dob, address;

    public KH(int id, String name, String gender, String dob, String address) {
        this.id = String.format("KH%03d", id);
        this.name = formatName(name);
        this.gender = gender;
        this.dob = dobFormat(dob);
        this.address = address;
    }

    private String formatName(String name) {
        String[] s = name.trim().split("\\s+");
        String res = "";
        for (String i : s)
            res += i.substring(0, 1).toUpperCase() + i.substring(1).toLowerCase() + " ";
        return res;
    }

    private String dobFormat(String dob) {
        if (dob.charAt(2) != '/')
            dob = "0" + dob;
        if (dob.charAt(5) != '/')
            dob = dob.substring(0, 3) + "0" + dob.substring(3);
        return dob;
    }

    public String getDob() {
        return this.dob;
    }

    @Override
    public String toString() {
        return id + " " + name + gender + " " + address + " " + dob;
    }

}