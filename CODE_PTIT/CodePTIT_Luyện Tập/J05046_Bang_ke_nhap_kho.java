import java.util.*;

public class J05046_Bang_ke_nhap_kho {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Product> products = new ArrayList<>();
        int t = sc.nextInt();
        ArrayList<String> name = new ArrayList<>();
        for (int i = 0; i < t; i++) {
            sc.nextLine();
            products.add(new Product(sc.nextLine(), sc.nextInt(),
                    sc.nextInt()));
            int ind = name.indexOf(products.get(i).getId().substring(0, 2));
            if (ind == -1) {
                products.get(i).id = 1;
            } else {
                products.get(i)
                        .id = (Integer.parseInt(products.get(name.lastIndexOf(products.get(i).getNameId())).getId().substring(2))+ 1);
            }
            name.add(products.get(i).getNameId());
        }
        products.forEach(System.out::println);
        sc.close();
    }
}

class Product {
    String name;
    int id, quantity, unitPrice;

    public Product(String name, int quantity, int unitPrice) {
        this.name = name;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }
   
    public String getNameId() {
        String[] tmp = name.split(" ");
        return (String.valueOf(tmp[0].charAt(0)) + tmp[1].charAt(0)).toUpperCase();
    }

    public String getId() {
        return getNameId() + String.format("%02d", id);
    }

    public int getDiscount() {
        if (quantity > 10)
            return unitPrice * quantity * 5 / 100;
        if (quantity >= 8)
            return unitPrice * quantity * 2 / 100;
        if (quantity >= 5)
            return unitPrice * quantity / 100;
        return 0;
    }

    public int getAmount() {
        return unitPrice * quantity - getDiscount();
    }

    @Override
    public String toString() {
        return getId() + " " + name + " " + getDiscount() + " " + getAmount();
    }
}