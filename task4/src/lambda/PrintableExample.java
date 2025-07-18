package lambda;

@FunctionalInterface
interface Printable {
    void print();
}

public class PrintableExample {
    public static void main(String[] args) {
        Printable printable = () -> System.out.println("Printing from lambda");
        printable.print();
    }
}