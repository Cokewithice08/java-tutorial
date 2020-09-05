package cn.jast.java.reflection;

/**
 * 获取类名称:
 *  1. 简单类名称
 *  2. 带包名类名称
 */
public class ClassNames {

    /**
     * --------getClass()---------
     * true
     * true
     * true
     *
     * --------Class.forName()---------
     * true
     * true
     * true
     *
     * @param args
     * @throws ClassNotFoundException
     */
    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println("--------getClass()---------");
        Integer integer = new Integer(1);
        Class<?> clazz = integer.getClass();
        /**
         * 获取类名
         */
        System.out.println("Integer".equals(clazz.getSimpleName()));
        /**
         * 获取带包名的类名
         */
        System.out.println("java.lang.Integer".equals(clazz.getName()));
        /**
         * 获取准确的名称
         */
        System.out.println("java.lang.Integer".equals(clazz.getCanonicalName()));


        System.out.println("\n--------Class.forName()---------");
        Class clazz1 = Class.forName("java.lang.Integer");
        /**
         * 获取类名
         */
        System.out.println("Integer".equals(clazz1.getSimpleName()));
        /**
         * 获取带包名的类名
         */
        System.out.println("java.lang.Integer".equals(clazz1.getName()));
        /**
         * 获取准确的名称
         */
        System.out.println("java.lang.Integer".equals(clazz1.getCanonicalName()));

    }
}
