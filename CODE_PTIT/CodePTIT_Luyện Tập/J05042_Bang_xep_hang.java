import java.util.*;

public class J05042_Bang_xep_hang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        ArrayList<Student> arrayList = new ArrayList<>();

        while (t-- > 0) {
            sc.nextLine();
            arrayList.add(new Student(sc.nextLine(), sc.nextInt(), sc.nextInt()));
        }
        arrayList.sort((a, b) -> a.correct == b.correct ? (a.submit == b.submit ? a.name.compareTo(b.name) : a.submit - b.submit) : b.correct - a.correct);
        arrayList.forEach(System.out::println);
        sc.close();
    }
}
class Student {
    String name;
    int correct, submit;

    public Student(String name, int correct, int submit) {
        this.name = name;
        this.correct = correct;
        this.submit = submit;
    }

    @Override
    public String toString() {
        return name + " " + correct + " " + submit;
    }

}
