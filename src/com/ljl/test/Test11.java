package com.ljl.test;

import java.util.function.Predicate;

/**
 * java.util.function.Predicate<T>接口
 * 有3个默认方法：
 * and：并且关系，可以连接多个判断条件
 * or：或者关系
 * negate:取反
 */
public class Test11 {
    public static void main(String[] args) {
        //默认方法：and
        //需求：判断一个字符串，长度大于5并且包含a
        String s="Hello";
        boolean o = checkStringAnd(s, str -> str.length() > 5, str -> str.contains("a"));
        System.out.println(o);

        //默认方法：or
        //需求：判断一个字符串，长度大于5或者包含a
        String ss="Hello";
        boolean oo = checkStringOr(s, str -> str.length() > 5, str -> str.contains("a"));
        System.out.println(oo);

        //默认方法：negate
        //需求：判断一个字符串，长度大于5返回false
        String sss="Hello";
        boolean ooo = checkStringNegate(s, str -> str.length() > 5);
        System.out.println(ooo);

    }

    public static boolean checkStringAnd(String s, Predicate<String> pre1, Predicate<String> pre2){
        return pre1.and(pre2).test(s);
    }

    public static boolean checkStringOr(String s, Predicate<String> pre1, Predicate<String> pre2){
        return pre1.or(pre2).test(s);
    }

    public static boolean checkStringNegate(String s, Predicate<String> pre){
        return pre.negate().test(s);
    }
}
