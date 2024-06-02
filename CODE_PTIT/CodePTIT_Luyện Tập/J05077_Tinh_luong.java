import java.util.*;

public class J05077_Tinh_luong {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = Integer.parseInt(sc.nextLine());
        ArrayList<Department> de = new ArrayList<>();
        while (m-- > 0) 
            de.add(new Department(sc.nextLine()));
        
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<Staff> st = new ArrayList<>();
        while (n-- > 0) {
            Staff staff = new Staff(sc.nextLine(), sc.nextLine(), Long.parseLong(sc.nextLine()), Integer.parseInt(sc.nextLine()));
            for (Department i : de)
                if (i.getSortName().equals(staff.getDepartment())) {
                    staff.setDepartment(i.getName());
                    break;
                }
            st.add(staff);
        }
        st.forEach(System.out::println);
        sc.close();
    }
}

class Staff {
    private String id, name, department;
    private Long basicSalary;
    private int workdays;

    public Staff(String id, String name, Long basicSalary, int workdays) {
        this.id = id;
        this.name = name;
        this.basicSalary = basicSalary;
        this.workdays = workdays;
    }
    public void setDepartment(String department) {
        this.department = department;
    }

    public Long getBasicSalary() {
        return this.basicSalary;
    }

    public int getWorkdays() {
        return this.workdays;
    }

    public String getDepartment () {
        return id.substring(3, 5);
    }

    public int salaryFactor () {
        char type = id.charAt(0);
        int years = Integer.parseInt(id.substring(1, 3));
        switch (type) {
            case 'A':
                if (years >= 1 && years <= 3)   return 10;
                if (years >= 4 && years <= 8)   return 12;
                if (years >= 9 && years <= 15)   return 14;
                if (years >= 16)   return 20;
                break;
            case 'B':
                if (years >= 1 && years <= 3)   return 10;
                if (years >= 4 && years <= 8)   return 11;
                if (years >= 9 && years <= 15)   return 13;
                if (years >= 16)   return 16;
                break;
            case 'C':
                if (years >= 1 && years <= 3)   return 9;
                if (years >= 4 && years <= 8)   return 10;
                if (years >= 9 && years <= 15)   return 12;
                if (years >= 16)   return 14;
                break;
            case 'D':
                if (years >= 1 && years <= 3)   return 8;
                if (years >= 4 && years <= 8)   return 9;
                if (years >= 9 && years <= 15)   return 11;
                if (years >= 16)   return 13;
                break;
        }
        return 0;
    }

    private Long getSalary () {
        return basicSalary * getWorkdays() * salaryFactor() * 1000;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + department + " " + getSalary();
    }

}

class Department {
    private String sortName, name;

    public Department(String line) {
        String[] s = line.split("\\s+");
        this.sortName = s[0];
        this.name = String.join(" ", Arrays.copyOfRange(s, 1, s.length));
    }

    public String getSortName() {
        return this.sortName;
    }

    public String getName() {
        return this.name;
    }

}