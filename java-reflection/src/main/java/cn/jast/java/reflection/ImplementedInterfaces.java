package cn.jast.java.reflection;

/**
 * 获取实现的接口
 * - implements 之后的
 */
public class ImplementedInterfaces {

    public static void main(String[] args) {
        Class stringClass = String.class;
        Class[] interfaces = stringClass.getInterfaces();
        for (Class anInterface : interfaces) {
            System.out.println(anInterface.getName());
        }
    }
}
