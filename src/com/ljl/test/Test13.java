package com.ljl.test;

import java.util.function.Function;

/**
 * java.util.function.Function<T,R>接口
 * T：转换前对象，R：转换后对象
 * 作用：根据一个类型的数据得到另一个类型的数据
 * 该接口中最主要的抽象方法为：R apply(T t)，根据类型T的参数获取类型R的结果
 * 使用场景如：将String转Integer
 */
public class Test13 {

    public static void main(String[] args) {
        //将String转Integer
        String s="123";
        Integer integer = changeStr(s, str -> Integer.parseInt(str));
        System.out.println(integer);
    }

    public static Integer changeStr(String s, Function<String,Integer> f){
        Integer apply = f.apply(s);
        return apply;
    }
}
