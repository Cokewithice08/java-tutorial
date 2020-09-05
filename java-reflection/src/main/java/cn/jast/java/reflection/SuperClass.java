package cn.jast.java.reflection;

/**
 * 获取父类
 * - 存在直接继承是继承的父类，不存在直接继承的是java.lang.Object类
 */
public class SuperClass {
    public static void main(String[] args) {
        Class stringClass = String.class;
        Class supperClass = stringClass.getSuperclass();
        System.out.println("java.lang.Object".equals(supperClass.getName()));
    }
}
