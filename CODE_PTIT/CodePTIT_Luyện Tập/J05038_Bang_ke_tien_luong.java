import java.util.*;

public class J05038_Bang_ke_tien_luong {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       int t = sc.nextInt();
       ArrayList<Employee> arrayList = new ArrayList<>();
       for (int i = 0; i < t; i++){
           sc.nextLine();
           arrayList.add(new Employee(i + 1, sc.nextLine(), sc.nextInt(), sc.nextInt(), sc.next()));
       }

       long totalSalary = 0;
       for (int i = 0; i < arrayList.size(); i++){
           System.out.println(arrayList.get(i));
           totalSalary += arrayList.get(i).getNetIncome();
       }
       System.out.println("Tong chi phi tien luong: " + totalSalary);
        sc.close();
    }
}

class Employee {
    String id, name;
    int basicSalary, workingDays;
    String position;

    public Employee(int id, String name, int basicSalary, int workingDays, String position) {
        this.id = String.format("NV%02d", id);
        this.name = name;
        this.basicSalary = basicSalary;
        this.workingDays = workingDays;
        this.position = position;
    }

    public int getSalary() {
        return basicSalary * workingDays;
    }

    public int getBonus() {
        if (workingDays >= 25)
            return getSalary() * 2 / 10;
        if (workingDays >= 22)
            return getSalary() / 10;
        return 0;
    }

    public int getAllowance() {
        switch (position) {
            case "GD":
                return 250000;
            case "PGD":
                return 200000;
            case "TP":
                return 180000;
            case "NV":
                return 150000;
            default:
                return 0;
        }
    }

    public int getNetIncome() {
        return getSalary() + getBonus() + getAllowance();
    }

    @Override
    public String toString() {
        return id + " " + name + " " + getSalary() + " " + getBonus() + " " + getAllowance() + " "
                + getNetIncome();
    }
}