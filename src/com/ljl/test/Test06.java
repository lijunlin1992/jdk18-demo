package com.ljl.test;

import java.util.function.Supplier;

/**
 * 常用函数式接口
 * java.util.function,Supplier<T>接口仅包含一个无参的方法：T get()。
 * 范型T是什么，方法get就返回什么
 * 用于生产数据
 */
public class Test06 {

    public static void main(String[] args) {
        //调用getString方法，方法的参数Supplier是一个函数式接口，所以可以传递lambda表达式
        String string = getString(() -> "胡歌");
        System.out.println(string);
        //=====================求数组中最大值======================================
        int[] ii={12,234,34,123};
        int max1 = getMax(() -> {
            //重写get方法
            //获取数组最大值并返回
            //定义一个变量将数组第一个元素赋值给它，记录数组中元素最大值
            int max = ii[0];
            //遍历数组获取数组中其他元素，其他元素与最大值比较
            for (int i : ii) {
                if (i > max) {
                    max = i;
                }
            }
            return max;
        });
        System.out.println("数组中元素最大值是："+max1);
    }

    //定义一个方法，用于获取int类型数组中元素最大值，方法参数传递Supplier接口
    public static int getMax(Supplier<Integer> sup){
        return sup.get();
    }

    //定义一个方法，方法的参数传递Supplier<T>接口，范型执行String,get方法就会返回一个String
    public static String getString(Supplier<String> sup){
        return sup.get();
    }
}
