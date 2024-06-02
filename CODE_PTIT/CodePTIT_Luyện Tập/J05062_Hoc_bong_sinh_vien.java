import java.util.*;

public class J05062_Hoc_bong_sinh_vien {
    public static void main(String args[]) {
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        ArrayList<Student> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String name = sc.nextLine();
            String[] s = sc.nextLine().split("\\s+");
            list.add(new Student(i+1, name, Double.parseDouble(s[0]), Integer.parseInt(s[1])));
        }
        list.sort((a, b) -> b.getGpa() == a.getGpa() ? b.getDrl() > a.getDrl() ? 1 : -1 : b.getGpa() > a.getGpa() ? 1 : -1);
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            if (!list.get(i).getType().equals("KHONG") && count < m)
                count++;
            else if (list.get(i).getGpa() == list.get(i-1).getGpa() && list.get(i).getDrl() == list.get(i-1).getDrl())
                list.get(i).setType(list.get(i-1).getType());
            else list.get(i).setType("KHONG");
        }
        list.sort((a, b) -> a.getStt() - b.getStt());
        list.forEach(System.out::println);
        sc.close();
    }
    
}

class Student {
    private String name, type;
    private double gpa;
    private int drl, stt;

    public int getStt() {
        return stt;
    }


    public Student(int stt, String name, double gpa, int drl) {
        this.stt = stt;
        this.name = name;
        this.gpa = gpa;
        this.drl = drl;
        this.type = getType();
    }

    public String getType() {
        if (gpa >= 3.6 && drl >= 90)    return "XUATSAC";
        if (gpa >= 3.2 && drl >= 80)    return "GIOI";
        if (gpa >= 2.5 && drl >= 70)    return "KHA";
        return "KHONG";
    }
    

    public void setType(String type) {
        this.type = type;
    }

    public double getGpa() {
        return gpa;
    }

    public String getName() {
        return name;
    }

    public int getDrl() {
        return drl;
    }

    @Override
    public String toString() {
        return name + ": " + type; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    
}