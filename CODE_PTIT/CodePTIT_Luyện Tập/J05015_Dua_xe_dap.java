import java.util.*;

public class J05015_Dua_xe_dap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        ArrayList<Person> list = new ArrayList<>();
        while (t-- > 0) 
            list.add(new Person(sc.nextLine(), sc.nextLine(), sc.nextLine()));
        list.sort((a, b) -> a.getSpeed() < b.getSpeed() ? 1 : -1);
        list.forEach(System.out::println);
        sc.close();
    }
}

class Person {
    private String name;
    private String team;
    private String time;

    public Person(String name, String team, String time) {
        this.name = name;
        this.team = team;
        this.time = time;
    }

    public String getId() {
        String[] s1 = team.split(" ");
        String res = "";
        for (String i : s1) {
            res += i.charAt(0);
        }
        String[] s2 = name.split(" ");
        for (String i : s2) {
            res += i.charAt(0);
        }
        return res.toUpperCase();
    }

    public double getSpeed() {
        double h = Double.parseDouble(time.substring(0, 1)) - 6;
        double s = Double.parseDouble(time.substring(2, 4)) / 60;
        return (double) 120 / (h + s);
    }

    @Override
    public String toString() {
        return getId() + " " + name + " " + team + " " + (int) Math.round(getSpeed()) + " Km/h";
    }
}