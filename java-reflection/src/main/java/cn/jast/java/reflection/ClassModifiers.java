package cn.jast.java.reflection;

import java.lang.reflect.Modifier;

/**
 * 获取类限定符
 * 1. public/protected/private
 * 2. abstract
 * 3. final
 * 4. static
 * 5. native
 * 6. interface
 * 7. synchronized
 * 8. transient
 * 9. volatile
 */
public class ClassModifiers {

    public static void main(String[] args) {
        System.out.println("-------publicFinalClass------");
        Class publicFinalClass = PublicFinalClass.class;
        System.out.println(Modifier.isPublic(publicFinalClass.getModifiers()));
        System.out.println(Modifier.isFinal(publicFinalClass.getModifiers()));

        System.out.println("\r\n-------privateAbstractClass------");
        Class privateAbstractClass = PrivateAbstractClass.class;
        System.out.println(Modifier.isPrivate(privateAbstractClass.getModifiers()));
        System.out.println(Modifier.isAbstract(privateAbstractClass.getModifiers()));
    }

    public final class PublicFinalClass{

    }

    private abstract class PrivateAbstractClass{

    }
}
