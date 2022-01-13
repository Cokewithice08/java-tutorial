package io.github.jast90.singleton;

/**
 * 简单饿汉单例
 *
 */
public class SimpleHungerSingleton {

    private static SimpleHungerSingleton simpleSingleton;

    private SimpleHungerSingleton(){
        simpleSingleton = new SimpleHungerSingleton();
    }

    public static SimpleHungerSingleton getInstance(){
        return simpleSingleton;
    }

}
