package com.ljl.test;

import java.util.Arrays;

/**
 * 数组的构造器引用
 */
public class Test25 {
    public static void main(String[] args) {
        //方式一
        int[] array = Demo2.createArray(10, (len) -> {
            //根据数组长度创建数组并返回
            return new int[len];
        });
        System.out.println(array.length);
        //方式二
        int[] array1 = Demo2.createArray(10, int[]::new);
        System.out.println(Arrays.toString(array1));
        System.out.println(array1.length);
    }
}

/**
 * 定义一个创建数组的函数式接口
 */
@FunctionalInterface
interface ArrayBuilder{
    //定义一个创建int类型数组的方法，参数传递数组的长度，返回创建好的数组
    int[] arrayBuilder(int len);
}

class Demo2{
    //定义一个方法，方法的参数传递创建数组的长度和ArrayBuilder接口
    //方法内部根据传递的长度使用ArrayBuilder中的方法创建数组并返回
    public static int[] createArray(int len,ArrayBuilder a){
        return a.arrayBuilder(len);
    }
}

