package com.ljl.test;

import java.util.function.Consumer;

/**
 * 常用函数式接口
 * java.util.function,Consumer<T>接口默认方法addThen
 * 作用：需要两个Consumer接口可以把两个Consumer接口组合到一起
 * 再对数据进行消费
 *
 * 例如：
 * Consumer<String> con1
 * Consumer<String> con2
 * String s="hello";
 * con1.accept(s);
 * con2.accept(s);
 * 连接两个Consumer接口，在进行消费，谁在前谁先消费
 * con1.andThen(con2).accept(s);
 */
public class Test08 {

    public static void main(String[] args) {
        //方式一
        //调用method方法，传入字符串和两个lambda表达式
        method("hello",(t)->{
            //消费方式：把字符串转大写输出
            System.out.println(t.toUpperCase());
        },(t)->{
            //消费方式：把字符串转小写输出
            System.out.println(t.toLowerCase());
        });
        System.out.println("----------------------------------------");
        //方式2
        //调用method方法，传入字符串和两个lambda表达式
        method1("hello",(t)->{
            //消费方式：把字符串转大写输出
            System.out.println(t.toUpperCase());
        },(t)->{
            //消费方式：把字符串转小写输出
            System.out.println(t.toLowerCase());
        });
    }

    //定义一个方法，方法参数传递一个字符串和两个Consumer接口，接口泛型使用字符串
    public static void method(String s, Consumer<String> con1, Consumer<String> con2){
        con1.accept(s);
        con2.accept(s);
    }

    //定义一个方法，方法参数传递一个字符串和两个Consumer接口，接口泛型使用字符串
    public static void method1(String s, Consumer<String> con1, Consumer<String> con2){
        //使用andThen方法连接两个Consumer接口，在进行消费，谁在前谁先消费
        con1.andThen(con2).accept(s);
    }
}
