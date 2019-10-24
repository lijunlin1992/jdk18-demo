package com.ljl.test;

/**
 * 使用super引用父类的成员方法
 */
public class Test22 {
    public static void main(String[] args) {
        new Man().show();
    }
}

/**
 * 定义见面的函数式接口
 */
@FunctionalInterface
interface Greetable{
    //定义一个见面的方法
    void greet();
}
/**
 * 定义父类
 */
class Human{
    public void say(){
        System.out.println("hello 我是父类");
    }
}
/**
 * 定义子类
 */
class Man extends Human{
    //子类重写父类say方法

    @Override
    public void say() {
        System.out.println("hello 我是子类");
    }
    //定义一个方法参数传递Greetable接口
    public void method(Greetable g){
        g.greet();
    }
    public void show(){
        //方式一
//        method(()->{
//            //创建父类human对象
//            Human human = new Human();
//            human.say();
//        });
        //方式二
        //因为有子父类关系，所以存在一个关键字super代表父类，所以我们可以直接使用super调用父类的成员方法
//        method(()->{
//            super.say();
//        });
        //方式三
        method(super::say);
    }
}
