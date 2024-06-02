import java.util.ArrayList;
import java.util.Scanner;

public class J05054 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<Student> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Student(String.format("HS%02d", i + 1), sc.nextLine(), Float.parseFloat(sc.nextLine())));
            list.get(i).setClassification();
        }
        list.sort((a, b) -> {
            if(a.getScore() > b.getScore()) {
                return -1;
            }
            return 1;
        });
        for (int i = 0; i < n; i++)
            list.get(i).setRanking(i+1);
        for (int i = 1; i < n; i++)
            if (list.get(i).getScore() == list.get(i-1).getScore())
                list.get(i).setRanking(list.get(i-1).getRanking());
        list.sort((a, b) -> {
            return a.getId().compareTo(b.getId());
        });
        list.forEach(System.out::println);
        sc.close();
    }
}

class Student {
    private String id;
    private String name;
    private float score;
    private String classification;
    private int ranking;

    public Student(){}

    public String getId() {
        return id;
    }

    public Student(String id, String name, float score){
        this.id = id;
        this.name = name;
        this.score = score;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public float getScore(){
        return score;
    }

    public int getRanking() {
        return ranking;
    }

    public void setClassification() {
        if (score < 5) {
            this.classification = "Yeu";
        }
        else if (score < 7) {
            this.classification = "Trung Binh";
        }
        else if(score < 9) {
            this.classification = "Kha";
        }
        else this.classification = "Gioi";
    }

    @Override
    public String toString() {
        return id + " " + name + " " + score + " " + classification + " " + ranking;
    }
}
