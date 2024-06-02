import java.util.*;
import java.io.*;


public class J07038_Danh_sach_thuc_tap_3 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc1 = new Scanner(new File("SINHVIEN.in"));
        ArrayList<Student> students = new ArrayList<>();
        int n = Integer.parseInt(sc1.nextLine());
        for (int i = 0; i < n; i++)
            students.add(new Student(sc1.nextLine(), sc1.nextLine(), sc1.nextLine(), sc1.nextLine()));
        
        Scanner sc2 = new Scanner(new File("DN.in"));
        ArrayList<Group> groups = new ArrayList<>();
        int m = Integer.parseInt(sc2.nextLine());
        for (int i = 0; i < m; i++)
            groups.add(new Group(sc2.nextLine(), sc2.nextLine(), Integer.parseInt(sc2.nextLine())));

        Scanner sc3 = new Scanner(new File("THUCTAP.in"));
        ArrayList<Intern> interns = new ArrayList<>();
        int k = Integer.parseInt(sc3.nextLine());
        for (int i = 0; i < k; i++) {
            Intern intern = new Intern();
            String[] s = sc3.nextLine().split("\\s+");
            String studentId = s[0], groupId = s[1];
            for (Student st : students)
                if (st.getId().equals(studentId)) {
                    intern.setStudent(st);
                    break;
                }
            for (Group gr : groups)
                if (gr.getId().equals(groupId)) {
                    intern.setGroup(gr);
                    break;
                }
            interns.add(intern);
        }
        interns.sort((a, b) -> a.getStudent().getId().compareTo(b.getStudent().getId()));
        
        int l = Integer.parseInt(sc3.nextLine());
        while (l-- > 0) {
            String groupId = sc3.nextLine();
            String groupName = "";
            Integer amount = 0;
            for (Group gr : groups)
                if (gr.getId().equals(groupId)) {
                    amount = gr.getAmount();
                    groupName = gr.getName();
                    break;
                }
            System.out.println(String.format("DANH SACH THUC TAP TAI %s:", groupName));
            for (Intern in : interns) {
                if (in.getGroup().getId().equals(groupId)) {
                    System.out.println(in);
                    amount--;
                }
                if (amount == 0)    break;
            }
        }
    }
}

class Student {
    private String id, name, classId, email;

    public Student(String id, String name, String classId, String email) {
        this.id = id;
        this.name = formatName(name);
        this.classId = classId;
        this.email = email;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getClassId() {
        return this.classId;
    }

    public String getEmail() {
        return this.email;
    }

    public String formatName (String name) {
        String[] s = name.trim().split("\\s+");
        for (int i = 0; i < s.length; i++)
            s[i] = s[i].substring(0, 1).toUpperCase() + s[i].substring(1).toLowerCase();
        return String.join(" ", s);
    }

}

class Group {
    private String id, name;
    private Integer amount;

    public Group(String id, String name, Integer amount) {
        this.id = id;
        this.name = name;
        this.amount = amount;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Integer getAmount() {
        return this.amount;
    }

}

class Intern {
    private Student student;
    private Group group;

    public Intern() {
    }

    public Intern(Student student, Group group) {
        this.student = student;
        this.group = group;
    }

    public Student getStudent() {
        return this.student;
    }

    public Group getGroup() {
        return this.group;
    }
    public void setStudent(Student student) {
        this.student = student;
    }
    public void setGroup(Group group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return student.getId() + " " + student.getName() + " " + student.getClassId();
    }

}