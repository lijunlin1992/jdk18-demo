package com.ljl.test;

/**
 * 使用lambda表达式优化日志案例(Test02)
 * lambda特点：延迟加载
 * lambda前提：必须存在函数式接口
 */
public class Test03 {
    public static void main(String[] args) {
        //定义3个日志信息
        String msg1="hello111";
        String msg2="hello222";
        String msg3="hello333";
        //调用showLog方法，参数MsgBuilder是一个函数式接口,所以可以传递lambda表达式
        showLog(1,()->{
            //返回一个拼接好的字符串
            return msg1+msg2+msg3;
        });
    }

    //定义一个显示日志的方法，方法的参数传递日志等级和MsgBuilder接口
    public static void showLog(int level,MsgBuilder bu){
        //如果是1级，则调用MsgBuilder接口中的buildMsg方法
        if (level==1){
            System.out.println(bu.buildMsg());
        }
    }


}

/**
 * 定义一个函数式接口类
 */
@FunctionalInterface
interface MsgBuilder{
    //定义一个拼接消息的抽象方法，返回被拼接的消息
    public abstract String buildMsg();
}
