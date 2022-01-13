package io.github.jast90.singleton;

/**
 * 推荐
 */
public class StaticInnerClassSingleton {

    private StaticInnerClassSingleton(){

    }

    public static StaticInnerClassSingleton getInstance(){
        return Inner.instance;
    }


    private static class Inner{
        private static final StaticInnerClassSingleton instance = new StaticInnerClassSingleton();
    }


}
