import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class J07084_Thoi_gian_online_lien_tuc {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("ONLINE.in"));
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<Student> list = new ArrayList<>();
        for (int i = 0; i < n; i++)
            list.add(new Student(sc.nextLine(), sc.nextLine(), sc.nextLine()));
        list.sort((a, b) -> {
            if (b.getOnlineTime() == a.getOnlineTime()) 
                return a.getName().compareTo(b.getName());
            return (int)(b.getOnlineTime() - a.getOnlineTime());
        });
        list.forEach(System.out::println);
    }
}

class Student {
    private String name, login, logout;
    private long onlineTime;

    public Student(String name, String login, String logout) throws ParseException {
        this.name = name;
        this.login = login;
        this.logout = logout;
        this.onlineTime = countTime();
    }

    public String getName() {
        return this.name;
    }

    public long getOnlineTime() {
        return this.onlineTime;
    }

    public long countTime () throws ParseException {
        long time = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(logout).getTime() - new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").parse(login).getTime();
        return TimeUnit.MILLISECONDS.toMinutes(time);
    }

    @Override
    public String toString() {
        return name + " " + onlineTime;
    }

}