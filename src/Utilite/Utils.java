package Utilite;

import Converter.Converter;

public class Utils {
    public static Object convert(Object object, Class clazz) {
        return Converter.convertTo(object, clazz);

    }
}
