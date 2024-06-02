import java.util.*;
import java.io.*;

public class J07071_Ten_viet_tat {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("DANHSACH.in"));
        int t = Integer.parseInt(sc.nextLine());
        ArrayList<Name> name = new ArrayList<>();
        for (int i = 0; i < t; i++)
            name.add(new Name(sc.nextLine()));
        name.sort((a, b) -> a.getFirstName().equals(b.getFirstName()) ? a.getLastName().compareTo(b.getLastName()) : a.getFirstName().compareTo(b.getFirstName()));
        int n = Integer.parseInt(sc.nextLine());
        while (n-- > 0) {
            String query = sc.nextLine();
            for (int i = 0; i < query.length(); i++) {
                if (query.charAt(i) == '*')
                    query = query.substring(0, i) + "." + query.substring(i+1);
            }
            for (Name i : name) {
                if (i.getSortName().matches("^" + query + "$"))
                    System.out.println(i);
            }
        }
    }
}

class Name {
    private String fullName, sortName, firstName, lastName;

    public Name(String fullName) {
        this.fullName = fullName;
        this.sortName = nameFormat(fullName);
    }


    public String getSortName() {
        return this.sortName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    private String nameFormat (String fullName) {
        String[] s = fullName.split("\\s+");
        this.lastName = s[0];
        this.firstName = s[s.length - 1];
        for (int i = 0; i < s.length; i++)
            s[i] = s[i].substring(0, 1);
        return String.join(".", s);
    }

    @Override
    public String toString() {
        return this.fullName;
    }

}