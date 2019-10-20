package com.ljl.test;

/**
 * bilibili:JDK8新特性-撸代码的青年
 * 函数式接口
 * 作用：一般可以作为方法的参数和返回值类型来使用
 */
public class Test01 {
    public static void main(String[] args) {
        //普通/函数式接口使用方式1：调用show方法，方法的参数是一个接口，所以可以传递接口的实现类对象
        show(new MyFunctionInterfaceImpl());
        //普通/函数式接口使用方式2：调用show方法，方法的参数是一个接口，所以可以传递接口匿名内部类
        show(new MyFunctionInterface() {
            @Override
            public void method() {
                System.out.println("使用匿名内部类重写接口中的抽象方法");
            }
        });
        //函数式接口使用方式：调用show方法，方法的参数是一个函数式接口，所以可以用Lambda表达式
        show(()->{
            System.out.println("使用Lambda表达式重写接口中的抽象方法");
        });
        //简化lambda表达式
        show(()->System.out.println("使用Lambda表达式重写接口中的抽象方法"));

    }

    //定义一个方法，参数使用函数式接口MyFunctionInterface
    public static void show(MyFunctionInterface myInter){
        myInter.method();
    }
}

/**
 * 定义一个函数式接口：(条件)有且仅有一个抽象方法
 */
@FunctionalInterface //检测接口是否是一个函数式接口，是：编译成功 否：编译失败
interface MyFunctionInterface{
    //定义一个抽象方法,public abstract可以省略不写
    public abstract void method();
}

/**
 * 定义函数式接口实现类
 */
class MyFunctionInterfaceImpl implements MyFunctionInterface{

    @Override
    public void method() {

    }
}
