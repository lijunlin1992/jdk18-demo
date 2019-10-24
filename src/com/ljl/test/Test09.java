package com.ljl.test;

import java.util.function.Consumer;

/**
 * 练习：
 * 字符串数组中存有多条信息，按照格式：姓名：xx。性别：xx。打印出来
 * 要求将打印姓名的动作作为第一个consumer接口的lambda实例，
 * 将两个consumer接口按照顺序拼接在一起
 */
public class Test09 {
    public static void main(String[] args) {
        String[] arr={"迪丽热巴,女","古力娜扎,女","马尔扎哈,男"};
        pringInfo(arr,(t)->{
            String name = t.split(",")[0];
            System.out.println("姓名："+name);
        },(t)->{
            String sex = t.split(",")[1];
            System.out.println("性别："+sex);
        });
    }

    //定义一个方法，方法参数传递一个字符串和两个Consumer接口，接口泛型使用字符串
    public static void pringInfo(String[] arr, Consumer<String> con1, Consumer<String> con2){
        for (String s : arr) {
            con1.andThen(con2).accept(s);
        }
    }
}
