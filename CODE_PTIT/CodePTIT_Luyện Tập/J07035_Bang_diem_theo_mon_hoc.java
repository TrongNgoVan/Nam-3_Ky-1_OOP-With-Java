import java.util.*;
import java.io.*;

public class J07035_Bang_diem_theo_mon_hoc {

    public static void main(String args[]) throws FileNotFoundException {
        // TODO code application logic here
        Scanner sc1 = new Scanner(new File("SINHVIEN.in"));
        int n = Integer.parseInt(sc1.nextLine());
        ArrayList<Student> students = new ArrayList<>();
        for (int i = 0; i < n; i++)
            students.add(new Student(sc1.nextLine(), sc1.nextLine(), sc1.nextLine(), sc1.nextLine()));
        
        Scanner sc2 = new Scanner(new File("MONHOC.in"));
        int m = Integer.parseInt(sc2.nextLine());
        ArrayList<Subject> subjects = new ArrayList<>();
        for (int i = 0; i < m; i++)
            subjects.add(new Subject(sc2.nextLine(), sc2.nextLine(), Integer.parseInt(sc2.nextLine())));
        
        Scanner sc3 = new Scanner(new File("BANGDIEM.in"));
        int k = Integer.parseInt(sc3.next());
        ArrayList<ScoreTable> tables = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            String stId = sc3.next(), sjId = sc3.next(), score = sc3.next();
            
            Student student = new Student();
            Subject subject = new Subject();
            for (Student st : students) 
                if (st.getId().equals(stId)) {
                    student = st;
                    break;
                }
            for (Subject sj : subjects) 
                if (sj.getId().equals(sjId)) {
                    subject = sj;
                    break;
                }
            tables.add(new ScoreTable(student, subject, score));
        }
        
        tables.sort((a, b) -> Double.valueOf(b.getScore()).compareTo(Double.valueOf(a.getScore())) == 0 ? a.getStudent().getId().compareTo(b.getStudent().getId()) : Double.valueOf(b.getScore()).compareTo(Double.valueOf(a.getScore())));
        
        int q = Integer.parseInt(sc3.next());
        while (q-- > 0) {
            String sjId = sc3.next(), sjName = "";
            for (Subject sj : subjects)
                if (sj.getId().equals(sjId)) {
                    sjName = sj.getName();
                    break;
                }
            System.out.printf("BANG DIEM MON %s:\n", sjName);
            tables.forEach((e) -> {
                if (e.getSubject().getId().equals(sjId))
                    System.out.println(e);
            });
        }
        
        sc1.close();
        sc2.close();
        sc3.close();
    }
}

class Student {
    private String id, name, className, email;

    public Student() {
    }
 
    public Student(String id, String name, String className, String email) {
        this.id = id;
        this.name = nameFormat(name);
        this.className = className;
        this.email = email;
    }

    public String getClassName() {
        return className;
    }

    
    public String getId() {
        return id;
    }

    private String nameFormat (String name) {
        String[] s = name.trim().split("\\s+");
        for (int i = 0; i < s.length; i++)
            s[i] = s[i].substring(0, 1).toUpperCase() + s[i].substring(1).toLowerCase();
        return String.join(" ", s);
    }
    
    @Override
    public String toString() {
        return id + " " + name + " " + className; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
}

class Subject {
    private String id, name;
    private int credits;

    public Subject() {
    }

    public Subject(String id, String name, int credits) {
        this.id = id;
        this.name = name;
        this.credits = credits;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return id + " " + name; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
}

class ScoreTable {
    private Student student;
    private Subject subject;
    private String score;

    public ScoreTable(Student student, Subject subject, String score) {
        this.student = student;
        this.subject = subject;
        this.score = score;
    }

    public Subject getSubject() {
        return subject;
    }

    public Student getStudent() {
        return student;
    }

    public String getScore() {
        return score;
    }

    @Override
    public String toString() {
        return student + " " + score; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
}