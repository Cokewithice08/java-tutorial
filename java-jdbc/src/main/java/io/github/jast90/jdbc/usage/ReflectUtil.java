package io.github.jast90.jdbc.usage;

import com.google.common.collect.Lists;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author zhangzhiwen
 * @Description:
 * @date 2021/12/9 16:17
 */
public class ReflectUtil {

    public static List<String> columns(String sql){
        return Lists.newArrayList(sql.split("from")[0].split("select")[1].trim().split(","));
    }

    private static Field getFieldByName(Class clazz, String name) throws NoSuchFieldException {
        Field field = clazz.getDeclaredField(name);
        return field;
    }

    private static Method getSetterByName(Class clazz, String name, Class paramType) throws NoSuchMethodException {
        char[] chars = name.toCharArray();
        chars[0] = (char) (chars[0]-32);
        Method setter = clazz.getMethod(String.format("set%s",new String(chars)),paramType);
        return setter;
    }

    public static void setFieldValue(Object object, ResultSet resultSet, String field, int index, Class clazz) throws NoSuchFieldException, NoSuchMethodException, SQLException, InvocationTargetException, IllegalAccessException {
        Field fieldByName = getFieldByName(clazz, field);
        Method setterByName = getSetterByName(clazz, field,fieldByName.getType());
        final Class fieldClass = fieldByName.getType();
        Object value = null;
        if(fieldClass == int.class){
            value = resultSet.getInt(index);
        }
        if(fieldClass == String.class){
            value = resultSet.getString(index);
        }
        if(fieldClass == float.class){
            value = resultSet.getString(index);
        }
        if(fieldClass == byte.class){
            value = resultSet.getString(index);
        }
        setterByName.invoke(object,value);
    }

    public static void fillParams(PreparedStatement preparedStatement, Object... params) throws SQLException {
        int i = 0;
        for (Object param : params) {
            if(param.getClass() == byte.class){
                preparedStatement.setByte(++i, (byte) param);
            }
            if(param.getClass() == int.class ||param.getClass() == Integer.class){
                preparedStatement.setInt(++i, (int) param);
            }
            if(param.getClass() == String.class){
                preparedStatement.setString(++i, (String) param);
            }
        }
    }
}
