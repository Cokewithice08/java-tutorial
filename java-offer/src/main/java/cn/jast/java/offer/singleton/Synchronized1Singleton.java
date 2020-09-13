package cn.jast.java.offer.singleton;

public class Synchronized1Singleton {

    private static Synchronized1Singleton instance;

    private Synchronized1Singleton(){

    }

    /**
     * 每次获取对象时都加锁来确保创建对象
     * @return
     */
    public static synchronized Synchronized1Singleton getInstance(){
        if(instance == null){
            instance = new Synchronized1Singleton();
        }
        return instance;
    }
}
