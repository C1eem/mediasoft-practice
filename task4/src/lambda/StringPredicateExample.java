package lambda;

import java.util.function.Predicate;

public class StringPredicateExample {
    public static void main(String[] args) {
        Predicate<String> isNotNull = s -> s != null;
        Predicate<String> isNotEmpty = s -> !s.isEmpty();
        Predicate<String> isValid = isNotNull.and(isNotEmpty);

        System.out.println(isValid.test("Hello"));
        System.out.println(isValid.test(""));
        System.out.println(isValid.test(null));

        Predicate<String> startsWithJorN = s -> s != null && (s.startsWith("J") || s.startsWith("N"));
        Predicate<String> endsWithA = s -> s != null && s.endsWith("A");
        Predicate<String> combined = startsWithJorN.and(endsWithA);

        System.out.println(combined.test("Java"));
        System.out.println(combined.test("NexusA"));
        System.out.println(combined.test("Python"));
    }
}