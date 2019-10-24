package com.ljl.test;

import java.util.function.Function;

/**
 * java.util.function.Function<T,R>接口
 * 默认方法：
 * andThen：组合操作，把两个function组合在一起
 */
public class Test14 {
    public static void main(String[] args) {
        //把字符串123转integer，再把结果加上10输出
        String s="123";
        Integer integer = functionAndThen(s, str -> Integer.parseInt(str), i -> i + 10);
        System.out.println(integer);
        /**
         * 使用function进行函数模型拼接
         * String ss="赵丽颖,20";
         * 1,将字符串截取数字部分
         * 2，将数字转换为int
         * 3，将数字累加100
         */
        String ss="赵丽颖,20";
        Integer integer1 = functionAndThen1(ss, str -> str.split(",")[1], str -> Integer.parseInt(str), str -> str + 100);
        System.out.println(integer1);
    }

    public static Integer functionAndThen(String s, Function<String,Integer> f1,Function<Integer,Integer> f2){
       return f1.andThen(f2).apply(s);
    }

    public static Integer functionAndThen1(String s,
                                           Function<String,String> f1,
                                           Function<String,Integer> f2,
                                           Function<Integer,Integer> f3){
        return f1.andThen(f2).andThen(f3).apply(s);
    }
}

