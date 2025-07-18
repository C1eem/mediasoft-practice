package lambda;

import java.util.function.Consumer;
import model.HeavyBox;

public class HeavyBoxExample {
    public static void main(String[] args) {
        Consumer<HeavyBox> ship = box ->
                System.out.println("Отправляем ящик с весом " + box.getWeight());
        Consumer<HeavyBox> deliver = box ->
                System.out.println("Отгрузили ящик с весом " + box.getWeight());

        Consumer<HeavyBox> combined = ship.andThen(deliver);
        combined.accept(new HeavyBox(100));
    }
}