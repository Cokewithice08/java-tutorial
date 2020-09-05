package cn.jast.java.reflection;

/**
 * 获取类包信息
 * - 包名
 */
public class ClassPackage {
    public static void main(String[] args) {
        Class stringClass = String.class;
        System.out.println("java.lang".equals(stringClass.getPackage().getName()));
    }
}
