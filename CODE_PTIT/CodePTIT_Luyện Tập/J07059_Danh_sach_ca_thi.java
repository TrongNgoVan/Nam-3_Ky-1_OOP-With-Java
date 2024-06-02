import java.io.*;
import java.text.*;
import java.util.*;;

public class J07059_Danh_sach_ca_thi {
    public static void main(String[] args) throws FileNotFoundException, ParseException {
        Scanner sc = new Scanner(new File("CATHI.in"));
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<Cathi> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(new Cathi(i, sc.nextLine() + " " + sc.nextLine(), sc.nextLine()));
        }
        list.sort((a, b) -> {
            try {
                return a.toDate().equals(b.toDate()) ? a.getId().compareTo(b.getId()) : a.toDate().compareTo(b.toDate());
            } catch (ParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return 0;
        });
        list.forEach(System.out::println);
    }
}

class Cathi {
    private String time, room, id;

    public Cathi(int i, String time, String room) {
        this.time = time;
        this.room = room;
        this.id = String.format("C%03d", i);
    }

    public Date toDate () throws ParseException {
        return new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(time);
    }


    public String getId() {
        return this.id;
    }
    
    @Override
    public String toString() {
        return id + " " + time + " " + room;
    }
    
}