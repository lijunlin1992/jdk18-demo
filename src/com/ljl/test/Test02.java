package com.ljl.test;

/**
 * 日志案例
 * 如果日志等级不为1，就不会输出信息，但是showLog传入的msg信息已经拼接好了，就存在
 * 一个性能资源浪费的问题，将在Test03中使用lambda表达式优化
 */
public class Test02 {
    public static void main(String[] args) {
        //定义3个日志信息
        String msg1="hello111";
        String msg2="hello222";
        String msg3="hello333";
        showLog(1,msg1+msg2+msg3);
    }

    //定义一个根据日志级别显示日志信息方法
    public static void showLog(int level,String msg){
        if (level==1){
            System.out.println(msg);
        }
    }
}
