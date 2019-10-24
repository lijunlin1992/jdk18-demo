package com.ljl.test;

/**
 * 方法引用：
 *      通过对象名来引用成员方法
 */
public class Test20 {
    public static void main(String[] args) {
        //通过对象名来引用成员方法
        //使用前提是对象名是已经存在的，成员方法也是已经存在的
        DemoPrintable1.printString(s->{
            //创建MethodRreObject对象
            MethodRreObject obj = new MethodRreObject();
            //调用MethodRreObject中的成员方法print，把字符串大写输出
            obj.print(s);
        });
        /**
         * 使用方法引用优化lambda
         * 对象已经存在MethodRreObject，成员方法print也存在
         */
        MethodRreObject obj = new MethodRreObject();
        DemoPrintable1.printString(obj::print);
    }
}

class MethodRreObject{
    //定义一个成员方法，传递字符串，将字符串大写输出
    public void print(String s){
        System.out.println(s.toUpperCase());
    }
}

/**
 * 定义一个函数式接口：(条件)有且仅有一个抽象方法
 */
@FunctionalInterface //检测接口是否是一个函数式接口，是：编译成功 否：编译失败
interface Printable1{
    //定义一个抽象方法,public abstract可以省略不写
    public abstract void pring(String s);
}
class DemoPrintable1{
    //定义一个方法，参数传递printable接口，对字符串进行打印
    public static void printString(Printable1 p){
        p.pring("hello");
    }
}
