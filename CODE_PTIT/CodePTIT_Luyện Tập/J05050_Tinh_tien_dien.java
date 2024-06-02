import java.util.ArrayList;
import java.util.Scanner;

public class J05050_Tinh_tien_dien {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Receipt> list = new ArrayList<>();
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 1; i <= n; i++)
            list.add(new Receipt(i, sc.nextLine(), Integer.parseInt(sc.nextLine()), Integer.parseInt(sc.nextLine())));
        list.forEach(System.out::println);
        sc.close();
    }
}

class Receipt {
    String type, id;
    int oldIndex, newIndex;

    public Receipt(int i, String type, int oldIndex, int newIndex) {
        this.type = type;
        this.oldIndex = oldIndex;
        this.newIndex = newIndex;
        this.id = String.format("KH%02d", i);
    }

    public long getFactor() {
        switch (type) {
            case "KD":  return 3;
            case "NN":  return 5;
            case "TT":  return 4;
            case "CN":  return 2;
        }
        return 0;
    }

    public long toMoney() {
        return (newIndex - oldIndex) * getFactor() * 550;
    }

    public long getExtra() {
        int tmp = newIndex - oldIndex;
        if (tmp < 50)   return 0;
        if (tmp >= 50 && tmp <= 100)    return (long) Math.round(toMoney() / 100.0 * 35);
        return toMoney();
    }

    public long getTotal () {
        return toMoney() + getExtra();
    }

    @Override
    public String toString() {
        return id + " " + getFactor() + " " + toMoney() + " " + getExtra() + " " + getTotal();
    }

}