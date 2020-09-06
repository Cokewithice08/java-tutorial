package cn.jast.java.reflection;

import java.lang.reflect.Field;

/**
 * 输出：
 * i
 * j
 * a
 * this$0
 *
 * MyClass1{i=0, j=0, a=0}
 * i
 * j
 * a
 * c
 * MyClass1{i=1, j=1, a=1}
 */
public class ClassFields {

    public static void main(String[] args) throws IllegalAccessException {
        Class integer = MyClass.class;
        for (Field field : integer.getDeclaredFields()) {
            System.out.println(field.getName());
        }
        System.out.println("");
        Class integer1 = MyClass1.class;
        MyClass1 myClass1 = new MyClass1();
        System.out.println(myClass1);
        for (Field field : integer1.getDeclaredFields()) {
            System.out.println(field.getName());
            if(field.isAccessible()==false){
                field.setAccessible(true);
            }
            field.set(myClass1,1);
        }
        System.out.println(myClass1);
    }

    class MyClass {
        private int i;
        protected int j;
        public int a;
    }

}

class MyClass1 {
    private int i;
    protected int j;
    public int a;

    static int c;

    @Override
    public String toString() {
        return "MyClass1{" +
                "i=" + i +
                ", j=" + j +
                ", a=" + a +
                '}';
    }
}
