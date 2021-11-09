package com.az.mall.infrastructure.util;

/**
 * @author AZ
 * @since 2021-11-02
 */
public class AttributeUtils {


    public static <T> T copyField(Object object, Class<T> target) throws InstantiationException, IllegalAccessException {
        T t = target.newInstance();
        Class<?> source = object.getClass();

        // source.

        return t;
    }
}
