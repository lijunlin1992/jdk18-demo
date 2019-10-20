package com.ljl.test;

/**
 * 例如java.lang.Runnable接口就是一个函数式接口
 * 假设有一个startThread方法使用该接口作为参数，那么就可以使用lambda进行传参
 * 这种情况其实和Thread类的构造方法参数为Runnable没有本质区别
 *
 */
public class Test04 {
    public static void main(String[] args) {
        //方式1
        //调用startThread方法，方法的参数是一个接口，那么我们可以传递这个接口的匿名内部类
        startThread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"-->线程启动");
            }
        });
        //方式2
        //调用startThread方法，方法的参数是一个函数式接口，那么我们可以传递lambda表达式
        startThread(()->{
            System.out.println(Thread.currentThread().getName()+"-->线程启动");
        });

    }

    //定义一个方法startThread，方法参数使用函数式接口Runnable
    public static void startThread(Runnable run){
        //开启多线程
        new Thread(run).start();
    }
}
