package annotations;

import java.lang.reflect.Field;

public class JsonSerializer {
    public static String toJson(Object object) throws IllegalAccessException {
        StringBuilder json = new StringBuilder("{");
        Field[] fields = object.getClass().getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(JsonField.class)) {
                field.setAccessible(true);
                JsonField annotation = field.getAnnotation(JsonField.class);

                if (json.length() > 1) {
                    json.append(", ");
                }

                json.append("\"").append(annotation.name()).append("\": ");

                Object value = field.get(object);
                if (value instanceof String) {
                    json.append("\"").append(value).append("\"");
                } else {
                    json.append(value);
                }
            }
        }

        json.append("}");
        return json.toString();
    }
}