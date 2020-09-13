package cn.jast.java.offer.singleton;

public class SynchronizedSingleton1 {

    private static SynchronizedSingleton1 instance;

    private SynchronizedSingleton1(){

    }

    /**
     * 每次获取对象时都加锁来确保创建对象
     * @return
     */
    public static synchronized SynchronizedSingleton1 getInstance(){
        if(instance == null){
            instance = new SynchronizedSingleton1();
        }
        return instance;
    }
}
