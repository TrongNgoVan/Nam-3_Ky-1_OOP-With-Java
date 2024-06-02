import java.util.*;

public class J05049_Liet_ke_nhap_xuat_hang_theo_nhom {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Product> list = new ArrayList<>();
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++)
            list.add(new Product(sc.nextLine(), Integer.parseInt(sc.nextLine())));
        list.sort((a, b) -> b.getTariff() - a.getTariff());
        String type = sc.nextLine();
        list.forEach((e) -> {
            if (e.getId().startsWith(type))
                System.out.println(e);
        });
        sc.close();
    }
}

class Product {
    private String id;
    private int importQuantity;

    public Product(String id, int importQuantity) {
        this.id = id;
        this.importQuantity = importQuantity;
    }

    public String getId() {
        return id;
    }

    public int getExportQuantity() {
        if (id.startsWith("A"))
            return (int) Math.round(0.6 * importQuantity);
        if (id.startsWith("B"))
            return (int) Math.round(0.7 * importQuantity);
        return 0;
    }

    public int getUnitPrice() {
        if (id.endsWith("Y"))
            return 110000;
        if (id.endsWith("N"))
            return 135000;
        return 0;
    }

    public int getTotalPrice() {
        return getExportQuantity() * getUnitPrice();
    }

    public int getTariff() {
        if (id.startsWith("A") && id.endsWith("Y"))
            return (int) Math.round(0.08 * getTotalPrice());
        if (id.startsWith("A") && id.endsWith("N"))
            return (int) Math.round(0.11 * getTotalPrice());
        if (id.startsWith("B") && id.endsWith("Y"))
            return (int) Math.round(0.17 * getTotalPrice());
        if (id.startsWith("B") && id.endsWith("N"))
            return (int) Math.round(0.22 * getTotalPrice());
        return 0;
    }

    @Override
    public String toString() {
        return id + " " + importQuantity + " " + getExportQuantity() + " " + getUnitPrice() + " " + getTotalPrice()
                + " " + getTariff();
    }
}