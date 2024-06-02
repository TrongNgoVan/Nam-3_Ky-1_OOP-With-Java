import java.util.*;
import java.io.*;

public class J07074_Lich_giang_day_theo_mon_hoc {
    public static void main(String[] args) throws Exception {
        Scanner sc1 = new Scanner(new File("MONHOC.in"));
        ArrayList<Subject> subjects = new ArrayList<>();
        int n = Integer.parseInt(sc1.nextLine());
        for (int i = 0; i < n; i++)
            subjects.add(new Subject(sc1.nextLine(), sc1.nextLine(), Integer.parseInt(sc1.nextLine())));
        sc1.close();

        Scanner sc2 = new Scanner(new File("LICHGD.in"));
        ArrayList<Group> groups = new ArrayList<>();
        int m = Integer.parseInt(sc2.nextLine());
        for (int i = 0; i < m; i++) {
            String id = sc2.nextLine();
            for (Subject sj : subjects) {
                if (sj.getId().equals(id)) {
                    groups.add(new Group(i+1, sj, sc2.nextLine(), sc2.nextLine(), sc2.nextLine(), sc2.nextLine()));
                    break;
                }
            }
        }

        String id = sc2.nextLine();
        String name = "";
        for (Subject i : subjects)
            if (i.getId().equals(id)) {
                name = i.getName();
                break;
            }
        sc2.close();

        groups.sort((a, b) -> a.getDate().compareTo(b.getDate()));
        System.out.println(String.format("LICH GIANG DAY MON %s:", name));
        for (Group i : groups) 
            if (i.getSubject().getId().equals(id))
                System.out.println(i);
    }
}

class Subject {
    private String id, name;
    private int credits;
    
    public Subject(String id, String name, int credits) {
        this.id = id;
        this.name = name;
        this.credits = credits;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCredits() {
        return credits;
    }

}

class Group {
    private String id;
    private Subject subject;
    private String date, shift, name, room;

    public Group(int id, Subject subject, String date, String shift, String name, String room) {
        this.id = String.format("HP%03d", id);
        this.subject = subject;
        this.date = date;
        this.shift = shift;
        this.name = name;
        this.room = room;
    }

    public String getId() {
        return id;
    }
    public Subject getSubject() {
        return subject;
    }
    public String getDate() {
        return date;
    }
    public String getShift() {
        return shift;
    }
    public String getName() {
        return name;
    }
    public String getRoom() {
        return room;
    }

    @Override
    public String toString() {
        return id + " " + date + " " + shift + " " + name + " " + room;
    }

}