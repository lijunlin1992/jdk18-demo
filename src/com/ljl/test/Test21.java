package com.ljl.test;

/**
 * 通过类名引用静态方法
 * 前提：
 *      类已经存在，静态成员方法也已经存在
 */
public class Test21 {
    public static void main(String[] args) {
        //调用method方法，传递计算绝对值的整数，和lambda表达式
        int i = DemoMethodReference.method(-11, n -> {
            //对参数进行绝对值计算并返回结果
            return Math.abs(n);
        });
        System.out.println(i);
        /**
         * 使用方法引用优化lambda
         */
        int ii = DemoMethodReference.method(-10,Math::abs);
        System.out.println(ii);
    }
}

@FunctionalInterface
interface Calcable{
    //定义一个抽象方法，传递一个整数，对整数进行绝对值计算
    public abstract int calsAbs(int num);
}

class DemoMethodReference{
    //定义一个方法，方法的参数传递要计算绝对值的整数，和函数式接口Calcable
    public static int method(int num,Calcable c){
        return c.calsAbs(num);
    }
}
