import java.util.*;

public class Danh_sach_thi_ICPC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nTeam = Integer.parseInt(sc.nextLine());
        ArrayList<Team> teams = new ArrayList<>();
        for (int i = 0; i < nTeam; i++) 
            teams.add(new Team(i+1, sc.nextLine(), sc.nextLine()));
        ArrayList<Student> students = new ArrayList<>();
        int nStudent = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < nStudent; i++) {
            students.add(new Student(i + 1, sc.nextLine()));
            String team = sc.nextLine();
            for (Team t : teams) {
                if (t.getId().equals(team))
                    students.get(i).setTeam(t);
            };
        }
        Collections.sort(students);
        students.forEach(System.out::println);
        sc.close();
    }
}

class Team {
    int id;
    String name, school;

    public Team(int id, String name, String school) {
        this.id = id;
        this.name = name;
        this.school = school;
    }

    public String getId() {
        return String.format("Team%02d", id);
    }

    public String getName() {
        return this.name;
    }

    public String getSchool() {
        return this.school;
    }

}

class Student implements Comparable<Student> {
    int id;
    String name;
    Team team;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return String.format("C%03d", id);
    }

    public String getName() {
        return this.name;
    }


    public Team getTeam() {
        return this.team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    @Override 
    public int compareTo (Student o) {
        return this.name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return getId() + " " + name + " " + team.getName() + " " + team.getSchool();
    }

}

