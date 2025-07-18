package lambda;

import java.util.function.Function;

public class FunctionExample {
    public static void main(String[] args) {
        Function<Integer, String> numberCheck = num -> {
            if (num > 0) return "Положительное число";
            else if (num < 0) return "Отрицательное число";
            else return "Ноль";
        };

        System.out.println(numberCheck.apply(5));
        System.out.println(numberCheck.apply(-3));
        System.out.println(numberCheck.apply(0));
    }
}