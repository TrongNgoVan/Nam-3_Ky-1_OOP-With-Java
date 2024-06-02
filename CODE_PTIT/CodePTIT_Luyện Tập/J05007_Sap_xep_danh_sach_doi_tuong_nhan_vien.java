import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class J05007_Sap_xep_danh_sach_doi_tuong_nhan_vien {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        ArrayList<NhanVien> nv = new ArrayList<>();
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 1; i <= n; i++)
            nv.add(new NhanVien(i, sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine(),
                    sc.nextLine()));
        nv.sort((a, b) -> a.dob.compareTo(b.dob));
        for (NhanVien i : nv)
            System.out.println(i);
        sc.close();
    }
}

class NhanVien {
    String id, name, gender, address, tax, signDate;
    Date dob;

    public NhanVien(int i, String name, String gender, String dob, String address, String tax, String signDate)
            throws ParseException {
        this.id = String.format("%05d", i);
        this.name = name;
        this.gender = gender;
        this.dob = new SimpleDateFormat("dd/MM/yyyy").parse(dob);
        this.address = address;
        this.tax = tax;
        this.signDate = signDate;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + gender + " " + new SimpleDateFormat("dd/MM/yyyy").format(dob) + " " + address
                + " " + tax + " " + signDate;
    }

}