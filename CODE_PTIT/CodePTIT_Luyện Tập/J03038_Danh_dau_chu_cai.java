import java.util.HashSet;
import java.util.Scanner;

public class J03038_Danh_dau_chu_cai {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        char[] s = input.next().toLowerCase().toCharArray();
        HashSet<Character> hs = new HashSet<>();
        for (char c : s) 
            hs.add(c);
        System.out.println(hs.size());
        input.close();
    }
}
