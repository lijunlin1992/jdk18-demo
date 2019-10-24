package com.ljl.test;

/**
 * 方法引用
 */
public class Test19 {
    public static void main(String[] args) {
        //调用printString方法，方法参数printable是一个函数式接口，所以可以传递lambda表达式
        DemoPrintable.printString(s-> System.out.println(s));
        /**
         * 分析：
         *      lambda表达式的目的是打印参数传递的字符串
         *      把参数s，传递给了system.out对象，调用out对象中的方法println对字符串进行了输出
         *      注意：
         *          1，system.out对象是已经存在的
         *          2，println方法也是已经存在的
         *          所以我们可以使用方法引用来优化lambda表达式
         */
        DemoPrintable.printString(System.out::println);
    }
}

/**
 * 定义一个函数式接口：(条件)有且仅有一个抽象方法
 */
@FunctionalInterface //检测接口是否是一个函数式接口，是：编译成功 否：编译失败
interface Printable{
    //定义一个抽象方法,public abstract可以省略不写
    public abstract void pring(String s);
}

class DemoPrintable{
    //定义一个方法，参数传递printable接口，对字符串进行打印
    public static void printString(Printable p){
        p.pring("hello");
    }
}
