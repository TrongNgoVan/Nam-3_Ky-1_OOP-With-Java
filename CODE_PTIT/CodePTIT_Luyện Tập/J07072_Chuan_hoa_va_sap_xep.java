import java.io.*;
import java.util.*;

public class J07072_Chuan_hoa_va_sap_xep {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("DANHSACH.in"));
        ArrayList<Human> list = new ArrayList<>();
        while (sc.hasNextLine()) 
            list.add(new Human(sc.nextLine().trim().split("\\s+")));
        list.sort((a, b) -> {
            if (!a.getFirstName().equals(b.getFirstName()))
                return a.getFirstName().compareTo(b.getFirstName());
            if (!a.getLastName().equals(b.getLastName()))
                return a.getLastName().compareTo(b.getLastName());
            return a.getMiddleName().compareTo(b.getMiddleName());
        });
        list.forEach(System.out::println);
    }
}

class Human {
    private String firstName, lastName, middleName;

    public Human(String[] name) {
        this.firstName = formatName(name[name.length - 1]);
        this.lastName = formatName(name[0]);
        this.middleName = formatName(String.join(" ", Arrays.copyOfRange(name, 1, name.length - 1)));
    }

    public String formatName (String name) {
        String[] s = name.trim().split("\\s+");
        String res = "";
        for (String i : s)
            res += i.substring(0, 1).toUpperCase() + i.substring(1).toLowerCase() + " ";
        return res;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getMiddleName() {
        return this.middleName;
    }

    @Override
    public String toString() {
        return lastName  + middleName  + firstName;
    }


}
