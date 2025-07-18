package lambda;

import java.util.Random;
import java.util.function.Supplier;

public class SupplierExample {
    public static void main(String[] args) {
        Supplier<Integer> randomSupplier = () -> new Random().nextInt(11);
        System.out.println(randomSupplier.get());
    }
}