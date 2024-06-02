import java.util.Scanner;

public class J04018_So_phuc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            ComplexNumber a = new ComplexNumber(sc.nextInt(), sc.nextInt());
            ComplexNumber b = new ComplexNumber(sc.nextInt(), sc.nextInt());
            ComplexNumber sum = a.add(b);
            System.out.printf("%s, %s\n", sum.multiply(a), sum.multiply(sum));
        }
        sc.close();
    }
}

class ComplexNumber {
    int real, imaginary;

    public ComplexNumber(int real, int imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    ComplexNumber add (ComplexNumber a) {
        return new ComplexNumber(real + a.real, imaginary + a.imaginary);
    }

    ComplexNumber multiply (ComplexNumber a) {
        return new ComplexNumber(real * a.real - imaginary * a.imaginary, real * a.imaginary + imaginary * a.real);
    }

    @Override
    public String toString() {
        return imaginary >= 0 ? (real + " + " + imaginary + "i") : (real + " - " + Math.abs(imaginary) + "i");
    }

}