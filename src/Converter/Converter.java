package Converter;

import Annotations.Label;
import Annotations.Skip;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import static java.lang.System.out;


public class Converter {
    public static Object convertTo(Object fromObj, Class toClazz) {
        String fmt = "%6S:  %-7s = %s%n";
        Class fromClazz = fromObj.getClass();
        Map<String, Field> fromFields = Arrays.stream(fromClazz.getDeclaredFields())
                .filter(field -> !field.isAnnotationPresent(Skip.class))
                .collect(Collectors.toMap(Field::getName, f -> f));

        Object toObj = new Object();
        try {
            toObj = toClazz.newInstance();


            assert toObj != null;
            for (Field field : toObj.getClass().getDeclaredFields()) {
                if (!field.isAnnotationPresent(Skip.class)) {
                    String fieldName;
                    if (field.isAnnotationPresent(Label.class)) {
                        Label label = field.getAnnotation(Label.class);

                        fieldName = label.name();


                    } else {
                        fieldName = field.getName();
                    }

                    Field fromField = fromFields.get(fieldName);


                    fromField.setAccessible(true);
                    field.setAccessible(true);
                    field.set(toObj, fromFields.get(fieldName).get(fromObj));
                    out.format(fmt, "after", "field", field.get(toObj));



                }
            }

        } catch (InstantiationException | NullPointerException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return toObj;
    }
}
