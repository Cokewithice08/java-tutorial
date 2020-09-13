package cn.jast.java.offer.singleton;

public class SynchronizedSingleton2 {

    private static SynchronizedSingleton2 instance;

    private SynchronizedSingleton2(){

    }

    public static SynchronizedSingleton2 getInstance(){
        if(instance == null){
            synchronized (SynchronizedSingleton2.class){
                if(instance==null){
                    instance = new SynchronizedSingleton2();
                }
            }
        }
        return instance;
    }

}
