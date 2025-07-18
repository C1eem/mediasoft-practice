import annotations.DeprecatedExProcessor;
import annotations.JsonSerializer;
import model.OldClass;
import model.Person;

public class Main {
    public static void main(String[] args) throws Exception {
        DeprecatedExProcessor.process(OldClass.class);

        Person person = new Person("John", 30);
        System.out.println(JsonSerializer.toJson(person));
    }
}