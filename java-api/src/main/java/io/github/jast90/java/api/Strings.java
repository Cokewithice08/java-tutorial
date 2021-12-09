package io.github.jast90.java.api;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author zhangzhiwen
 * @Description:
 * @date 2021/12/8 14:58
 */
public class Strings {
    public static void main(String[] args) {
        String s = processDate("2021-12-8");
        System.out.println(s);
    }

    private static String processDate(String yyyyMMdd){
        List<String> strings = Lists.newArrayList(yyyyMMdd.split("-"));
        strings.remove(strings.size()-1);
        return String.join("-",strings);
    }
}
