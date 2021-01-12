package cn.jast.jvm.gcroot;

/**
 * Created by jast90 on 2021/1/9
 */
public class BigClass {
    private int _10MB = 10 * 1024 * 1024;
    private byte[] memory = new byte[8 * _10MB];
}
