import java.util.Scanner;

public class J01016 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        char[] n = input.nextLine().toCharArray();
        int count = 0;
        for (char i:n) 
            if (i == '4' || i == '7')   count++;
        System.out.println(count == 4 || count == 7 ? "YES" : "NO");
        input.close();
    }
}
