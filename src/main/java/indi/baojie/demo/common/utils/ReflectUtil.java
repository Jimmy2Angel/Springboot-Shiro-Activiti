package indi.baojie.demo.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.Date;

/**
 * Created by Lollipop on 2017/4/19.
 */
public class ReflectUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReflectUtil.class);

    /**
     * 根据反射或者一个对象的方法
     * @param obj
     * @param fieldName
     * @param <T>
     * @return
     */
    public static <T> T getFieldValue(Object obj, String fieldName) {
        Object result = null;
        Field field = ReflectUtil.getField(obj, fieldName);
        if (field != null) {
            field.setAccessible(true);
            try {
                result = field.get(obj);
            } catch (IllegalArgumentException e) {
                LOGGER.info("ReflectUtil getFieldValue cause IllegalArgumentException",e);
            } catch (IllegalAccessException e2) {
                LOGGER.info("ReflectUtil getFieldValue cause IllegalAccessException",e2);
            }
        }
        return (T)result;
    }

    private static Field getField(Object obj, String fieldName) {
        Field field = null;
        for (Class<?> clazz=obj.getClass(); clazz != Object.class; clazz=clazz.getSuperclass()) {
            try {
                field = clazz.getDeclaredField(fieldName);
                break;
            } catch (NoSuchFieldException e) {
                LOGGER.info("ReflectUtil getField cause NoSuchFieldException",e);
            }
        }
        return field;
    }

    /**
     * 利用反射 将对象的null中不合理的值设置成null
     * @param object
     */
    public static void setIllegalValueToNull(Object object) {
        if (object == null) {
            return;
        }
        Class<?> clazzType = object.getClass();
        Field[] fields = clazzType.getDeclaredFields();
        try {
            if (fields == null || fields.length == 0) {
                return;
            }

            for (Field field : fields) {
                //double
                field.setAccessible(true);
                if (Double.class.equals(field.getType())) {
                    if ((Double)field.get(object) == null) {
                        field.set(object, null);
                    }
                }
            }


        } catch (Exception e) {
            LOGGER.error("handle illegal value for target class cause exception ", e);
        }
    }

    /**
     * 利用反射将对象的null值设置成对应类型的默认值
     * @param object
     */
    public static void fillDefaultValue(Object object) {
        if (object == null) {
            return;
        }

        Class<?> clazzType = object.getClass();
        Field[] fields = clazzType.getDeclaredFields();
        try {
            if (fields != null && fields.length > 0) {
                for (Field field : fields) {
                    field.setAccessible(true);
                    Class<?> type = field.getType();
                    String typeName = type.getName();
                    if (field.get(object) == null) {
                        //String
                        if (String.class.getName().equals(typeName)) {
                            field.set(object, "");
                        }
                        //int
                        if (Integer.class.getName().equals(typeName)) {
                            field.set(object, new Integer(0));
                        }
                        //long
                        if (Long.class.getName().equals(typeName)) {
                            field.set(object, new Long(0));
                        }
                        //double
                        if (Double.class.getName().equals(typeName)) {
                            field.set(object, new Double(0.0));
                        }
                        //date
                        if (Date.class.getName().equals(typeName)) {
                            field.set(object, new Date());
                        }
                        //boolean
                        if (Boolean.class.getName().equals(typeName)) {
                            field.set(object, new Boolean(false));
                        }
                        //float
                        if (Float.class.getName().equals(typeName)) {
                            field.set(object,new Float(0));
                        }
                    }
                }
            }
        } catch (Exception e) {
            LOGGER.error("set default value for target class cause exception ", e);
        }
    }

}
