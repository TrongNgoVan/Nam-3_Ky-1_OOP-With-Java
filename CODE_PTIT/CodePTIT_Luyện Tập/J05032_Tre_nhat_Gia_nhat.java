import java.util.*;
import java.text.*;

public class J05032_Tre_nhat_Gia_nhat {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<Human> list = new ArrayList<>();
        for (int i = 0; i < n; i++)
            list.add(new Human(sc.nextLine().trim().split("\\s+")));
        list.sort((a, b) -> b.dob.compareTo(a.dob));
        System.out.println(list.get(0) + "\n" + list.get(n-1));
        sc.close();
    }
}

class Human {
    String name;
    Date dob;

    public Human(String[] list) throws ParseException {
        this.name = list[0];
        this.dob = new SimpleDateFormat("dd/MM/yyyy").parse(list[1]);
    }

    @Override
    public String toString() {
        return name;
    }

}
