import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class J07010_Danh_sach_sinh_vien_trong_file_2 {
    public static void main(String[] args) throws FileNotFoundException, NumberFormatException, ParseException {
        Scanner sc = new Scanner(new File("SV.in"));
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<SV> sv = new ArrayList<>();
        for (int i = 1; i <= n; i++)
            sv.add(new SV(i, sc.nextLine(), sc.nextLine(), sc.nextLine(), Double.parseDouble(sc.nextLine())));
        sv.forEach(System.out::println);
        sc.close();
    }
}

class SV {
    String name, className, dob, id;
    Double gpa;

    public SV(int stt, String name, String className, String dob, Double gpa) throws ParseException {
        this.id = "B20DCCN" + String.format("%3d", stt).replace(' ', '0');
        this.name = name;
        this.className = className;
        this.dob = formatDate(dob);
        this.gpa = gpa;
    }
    String formatDate (String dob) throws ParseException {
        return new SimpleDateFormat("dd/MM/yyyy").format(new SimpleDateFormat("dd/MM/yyyy").parse(dob));
    }
    @Override
    public String toString() {
        return id + " " + name + " " + className + " " + dob + " " + String.format("%.2f", gpa);
    }
     

}