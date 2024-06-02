import java.text.*;
import java.util.*;
import java.io.*;

public class J07060_Sap_xep_lich_thi {
    public static void main(String[] args) throws Exception {
        Scanner sc1 = new Scanner(new File("MONTHI.in"));
        ArrayList<Subject> subjects = new ArrayList<>();
        int n = Integer.parseInt(sc1.nextLine());
        for (int i = 0; i < n; i++)
            subjects.add(new Subject(sc1.nextLine(), sc1.nextLine(), sc1.nextLine()));

        Scanner sc2 = new Scanner(new File("CATHI.in"));
        ArrayList<Ca> cas = new ArrayList<>();
        int m = Integer.parseInt(sc2.nextLine());
        for (int i = 0; i < m; i++)
            cas.add(new Ca(i + 1, sc2.nextLine(), sc2.nextLine(), sc2.nextLine()));

        Scanner sc3 = new Scanner(new File("LICHTHI.in"));
        ArrayList<Schedule> schedules = new ArrayList<>();
        int k = sc3.nextInt();
        for (int i = 0; i < k; i++) {
            String caId = sc3.next(), sjId = sc3.next();
            Ca ca = new Ca();
            Subject subject = new Subject();
            for (Ca c : cas)
                if (c.getId().equals(caId)) {
                    ca = c;
                    break;
                }
            for (Subject sj : subjects)
                if (sj.getId().equals(sjId)) {
                    subject = sj;
                    break;
                }

            schedules.add(new Schedule(ca, subject, sc3.next(), Integer.parseInt(sc3.next())));
        }

        schedules.sort((a, b) -> {
            try {
                return a.getCa().getDateTime().compareTo(b.getCa().getDateTime()) == 0
                        ? a.getCa().getId().compareTo(b.getCa().getId())
                        : a.getCa().getDateTime().compareTo(b.getCa().getDateTime());
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        });
        schedules.forEach(System.out::println);

        sc1.close();
        sc2.close();
        sc3.close();
    }
}

class Subject {
    private String id, name, format;

    public Subject() {
    }

    public Subject(String id, String name, String format) {
        this.id = id;
        this.name = name;
        this.format = format;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return name;
    }
}

class Ca {
    private String id, date, time, room;

    public Ca() {
    }

    public Ca(int id, String date, String time, String room) {
        this.id = String.format("C%03d", id);
        this.date = date;
        this.time = time;
        this.room = room;
    }

    public String getId() {
        return id;
    }

    public Date getDateTime() throws ParseException {
        return new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(date + " " + time);
    }

    @Override
    public String toString() {
        return date + " " + time + " " + room;
    }
}

class Schedule {
    private Ca ca;
    private Subject subject;
    private String groupId;
    private int number;

    public Schedule(Ca ca, Subject subject, String groupIs, int number) {
        this.ca = ca;
        this.subject = subject;
        this.groupId = groupIs;
        this.number = number;
    }

    public Ca getCa() {
        return ca;
    }

    @Override
    public String toString() {
        return ca + " " + subject + " " + groupId + " " + number;
    }
}