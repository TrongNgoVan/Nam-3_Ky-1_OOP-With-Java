import java.util.*;

public class J05017_Hoa_don_tien_nuoc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<BillWater> list = new ArrayList<>();
        for (int i = 1; i <= n; i++)
            list.add(new BillWater(i, sc.nextLine(), Integer.parseInt(sc.nextLine()),
                    Integer.parseInt(sc.nextLine())));
        list.sort((a, b) -> {
            return b.getMoney() - a.getMoney();
        });
        list.forEach(System.out::println);
        sc.close();
    }
}

class BillWater {
    private String id;
    private String name;
    private int oldIndex, newIndex;

    public BillWater(int id, String name, int oldIndex, int newIndex) {
        this.id = String.format("KH%02d", id);
        this.name = name;
        this.oldIndex = oldIndex;
        this.newIndex = newIndex;
    }

    public int getMoney() {
        float num = newIndex - oldIndex;
        if (num <= 50)
            return (int) (num * 102);
        if (num <= 100)
            return (int) Math.round((50 * 100 + (num - 50) * 150) * 1.03);
        return (int) Math.round((50 * 100 + 50 * 150 + (num - 100) * 200) * 1.05);
    }

    @Override
    public String toString() {
        return id + " " + name + " " + getMoney();
    }
}