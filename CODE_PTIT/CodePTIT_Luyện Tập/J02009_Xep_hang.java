import java.util.*;

public class J02009_Xep_hang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int res = 0;
        ArrayList<Pair<Integer, Integer>> map = new ArrayList<>();
        while (t-- > 0) 
            map.add(new Pair<Integer, Integer>(sc.nextInt(), sc.nextInt()));
        map.sort((a, b) -> a.getA().compareTo(b.getA()));
        for (Pair<Integer, Integer> i : map) {
            res = i.getA() > res ? i.getA() : res;
            res += i.getB();
        }
        System.out.println(res);
        sc.close();
    }
}

class Pair <T, S> {
    private T a;
    private S b;

    public Pair(T a, S b) {
        this.a = a;
        this.b = b;
    }

    public T getA() {
        return this.a;
    }

    public S getB() {
        return this.b;
    }

}