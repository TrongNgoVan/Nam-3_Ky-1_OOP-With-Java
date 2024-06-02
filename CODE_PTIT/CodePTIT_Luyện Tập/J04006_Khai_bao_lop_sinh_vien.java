//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Scanner;
//
//public class J04006_Khai_bao_lop_sinh_vien {
//    public static void main(String[] args) throws ParseException {
//        Scanner input = new Scanner(System.in);
//        String name = input.nextLine();
//        String cls = input.next();
//        String dob = input.next();
//        float gpa = input.nextFloat();
//        Student st = new Student("B20DCCN001", name, cls, dob, gpa);
//        System.out.println(st);
//        input.close();
//    }
//}
//class Student {
//    String id, name, cls, dob;
//    float gpa;
//
//    public Student(String id, String name, String cls, String dob, float gpa) throws ParseException{
//        this.id = id;
//        this.name = name;
//        this.cls = cls;
//        this.gpa = gpa;
//        SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
//        this.dob = sdf.format(sdf.parse(dob));
//    }
//
//    @Override
//    public String toString() {
//        return id + " " + name + " " + cls + " " + dob + " " + String.format("%.2f", gpa);
//    }
//
//}
