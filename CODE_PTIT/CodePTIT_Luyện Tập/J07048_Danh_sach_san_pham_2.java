import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class J07048_Danh_sach_san_pham_2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("SANPHAM.in"));
        int t = Integer.parseInt(sc.nextLine());
        ArrayList<Product> res = new ArrayList<>();
        while (t-- > 0)
            res.add(new Product(sc.nextLine(), sc.nextLine(), Integer.valueOf(sc.nextLine()), Integer.valueOf(sc.nextLine())));
        res.sort((a, b) -> {
            if (a.getPrice() < b.getPrice())    return 1;
            else if (a.getPrice() == b.getPrice())  return a.getId().compareTo(b.getId());
            return -1;
        });
        res.forEach(System.out::println);
        sc.close();
    }
}

class Product {
    String id, name;
    Integer price, warranty;

    public Product(String id, String name, Integer price, Integer warranty) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.warranty = warranty;
    }

    public Integer getPrice () {
        return this.price;
    }

    public String getId () {
        return this.id;
    }
    @Override
    public String toString() {
        return id + " " + name + " " + price + " " + warranty;
    }

}
