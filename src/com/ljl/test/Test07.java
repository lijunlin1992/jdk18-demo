package com.ljl.test;

import java.util.function.Consumer;

/**
 * 常用函数式接口
 * java.util.function,Consumer<T>接口与Supplier接口相反。
 * 接口中包含抽象方法void accept(T t)，意为消费一个指定范型的数据
 * 消费型接口
 */
public class Test07 {

    public static void main(String[] args) {
        method("小李哥",(String name)-> System.out.println(name));
    }
    //定义一个方法，方法参数传递一个字符串姓名
    //方法参数传递consumer接口，范型使用String
    //使用consumer接口消费字符串的姓名
    public static void method(String name, Consumer<String> con){
        con.accept(name);
    }
}
