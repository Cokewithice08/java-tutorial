package io.github.jast90.singleton;

public class Synchronized2Singleton {

    private static Synchronized2Singleton instance;

    private Synchronized2Singleton(){

    }

    public static Synchronized2Singleton getInstance(){
        if(instance == null){
            synchronized (Synchronized2Singleton.class){
                if(instance==null){
                    instance = new Synchronized2Singleton();
                }
            }
        }
        return instance;
    }

}
