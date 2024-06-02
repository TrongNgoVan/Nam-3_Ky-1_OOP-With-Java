import java.util.*;

public class J08026_Bien_doi_S_T {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test-- > 0) {
            Queue<Pair<Integer, Integer> > q = new LinkedList<>();
            int[] map = new int[100005];
            int s = sc.nextInt(), t = sc.nextInt(); 
            q.add(new Pair<Integer, Integer>(s, 0));
            while (!q.isEmpty()) {
                Pair<Integer, Integer> tmp = q.poll(); 
                if (tmp.getFirst() == t) {
                    System.out.println(tmp.getSecond());
                    break;
                }
                if (tmp.getFirst() > 1 && map[tmp.getFirst()-1] == 0) {
                    q.add(new Pair<Integer, Integer>(tmp.getFirst() - 1, tmp.getSecond() + 1)); 
                    map[tmp.getFirst() - 1]++;
                }
                if (tmp.getFirst() <= t && map[tmp.getFirst()*2] == 0) {
                    q.add(new Pair<Integer, Integer>(tmp.getFirst() * 2, tmp.getSecond() + 1)); map[tmp.getFirst() * 2]++;
                }
            }
        }
        sc.close();
    }
    
}

class Pair<S, T> {
    private S first;
    private T second;

    public Pair(S first, T second) {
        this.first = first;
        this.second = second;
    }

    public S getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }

    
}