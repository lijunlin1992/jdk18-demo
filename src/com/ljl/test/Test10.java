package com.ljl.test;

import java.util.function.Predicate;

/**
 * java.util.function.Predicate<T>接口
 * 作用：对某种数据类型的数据进行判断，返回一个boolean值
 * Predicate中包含一个抽象方法：
 * boolean test(T t)
 */
public class Test10 {

    public static void main(String[] args) {
        String s="hello";
        //方式一
        boolean b = checkString(s, (String str) -> {
            //对参数传递的字符串进行判断，判断长度是否大于3
            return str.length() > 3;
        });
        System.out.println(b);
        //方式二
        boolean b1 = checkString(s, str -> str.length() > 3);
        System.out.println(b1);
    }

    //定义一个方法，参数传递一个字符串和Predicate接口，泛型使用String
    //使用Predicate中的test方法对字符串进行判断
    public static boolean checkString(String s, Predicate<String> pre){
        return pre.test(s);
    }
}
