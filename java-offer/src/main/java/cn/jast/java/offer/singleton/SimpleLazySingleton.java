package cn.jast.java.offer.singleton;

/**
 * 简单懒汉单例
 * 
 */
public class SimpleLazySingleton {

    private static SimpleLazySingleton simpleSingleton;

    private SimpleLazySingleton(){

    }

    public static SimpleLazySingleton getInstance(){
        if(simpleSingleton == null){
            simpleSingleton = new SimpleLazySingleton();
        }
        return simpleSingleton;
    }

}
