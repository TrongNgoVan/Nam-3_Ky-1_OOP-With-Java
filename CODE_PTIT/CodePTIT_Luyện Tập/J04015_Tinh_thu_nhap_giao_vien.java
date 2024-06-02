import java.util.Scanner;

public class J04015_Tinh_thu_nhap_giao_vien {
    public static void main(String[] args) throws NumberFormatException {
        Teacher tc = new Teacher();
        System.out.println(tc);
    }
}

class Teacher {
    String code, name, position;
    Integer basicSalary, base, totalSalary, allowance;
    
    public Teacher() {
        Scanner sc = new Scanner(System.in);
        this.code = sc.nextLine();
        this.name = sc.nextLine();
        this.basicSalary = sc.nextInt();
        this.position = code.substring(0, 2);
        this.base = Integer.valueOf(code.substring(2));
        if (position.equals("HT"))  allowance = 2000000;
        else if (position.equals("HP")) allowance = 900000;
        else    allowance = 500000;
        sc.close();
    }
    public Integer getTotalSalary () {
        return basicSalary * base + allowance;
    }
    @Override
    public String toString() {
        return code + " " + name + " " + base + " " + allowance + " " + getTotalSalary();
    }
    
}
