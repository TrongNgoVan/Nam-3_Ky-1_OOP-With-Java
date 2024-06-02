import java.util.*;

public class J05070_Cau_lac_bo_bong_da_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<Club> club = new ArrayList<>();
        for (int i = 0; i < n; i++)
            club.add(new Club(sc.nextLine(), sc.nextLine(), Integer.parseInt(sc.nextLine())));

        int m = Integer.parseInt(sc.nextLine());
        ArrayList<Match> match = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            String[] tmp = sc.nextLine().split("\\s+");
            String id = tmp[0].substring(1, 3);
            for (Club j : club)
                if (j.id.equals(id))
                    match.add(new Match(tmp[0], j, Integer.parseInt(tmp[1])));
        }
        match.sort((a, b) -> a.income() == b.income() ? a.club.name.compareTo(b.club.name) : b.income() - a.income());
        match.forEach(System.out::println);
        sc.close();
    
    }
}

class Club {
    String id, name;
    int price;

    public Club(String id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}

class Match {
    String id;
    Club club;
    int amount;

    public Match(String id, Club club, int amount) {
        this.id = id;
        this.club = club;
        this.amount = amount;
    }

    public int income() {
        return club.price * amount;
    }

    @Override
    public String toString() {
        return id + " " + club.name + " " + income();
    }

}