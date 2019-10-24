package com.ljl.test;

/**
 * 通过this引用成员方法
 */
public class Test23 {
    public static void main(String[] args) {
        new Husband().soHappy();
    }
}

@FunctionalInterface
interface Richable{
    void buy();
}

class Husband{
    //定义一个买房子的方法
    public void buyHouse(){
        System.out.println("买房子");
    }
    //定义一个结婚的方法
    public void marry(Richable r){
        r.buy();
    }
    //定义一个非常高兴的方法
    public void soHappy(){
        //方式一
//        marry(()->{
//            //使用this调用本类买房子方法
//            this.buyHouse();
//        });
        //方式二
        marry(this::buyHouse);
    }
}
