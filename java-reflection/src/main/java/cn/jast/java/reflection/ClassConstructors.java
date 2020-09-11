package cn.jast.java.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ClassConstructors {

    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        String s = new String();
        Class integerClass = Integer.class;
        for (Constructor constructor : integerClass.getConstructors()) {
            System.out.println(constructor.getParameterCount());
        }
        Constructor constructor = integerClass.getConstructor(int.class);
        Integer integer1 = (Integer) constructor.newInstance(1);
        Integer integer2 = (Integer) constructor.newInstance(1);
        System.out.println(integer1==integer2);
        Integer i1 = 1;
        Integer i2 = 1;
        System.out.println(i1==i2);
        System.out.println(ClassConstructors.class.getClassLoader().getParent().getClass().getName());

    }
}
