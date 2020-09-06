package cn.jast.java.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ClassMethods {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class myclass = MyClass.class;
        System.out.println("获取本类或父类所有可见方法名称");
        for (Method method : myclass.getMethods()) {
            System.out.println(method.getName() + (Modifier.isPublic(method.getModifiers()) ? " is public " : " is not public "));
        }

        System.out.println("\r\n获取本类的所有方法名称");
        for (Method declaredMethod : myclass.getDeclaredMethods()) {
            System.out.println(declaredMethod.getName());
        }

        MyClass myClass = new MyClass();
        Method method = myclass.getDeclaredMethod("hello");
        method.setAccessible(true);
        method.invoke(myClass);
        Method setI = myclass.getDeclaredMethod("setI",int.class);
        setI.invoke(myClass,1);
        System.out.println(myClass.getI());
    }

}

class MyClass {
    private String s;
    private int i;

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    private void hello() {
        System.out.println("hello is private method");
    }

}
