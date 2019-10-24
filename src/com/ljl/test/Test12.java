package com.ljl.test;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * java.util.function.Predicate<T>接口
 */
public class Test12 {
    public static void main(String[] args) {
        /**
         * 练习：集合信息筛选
         * 有一个数组 String[] arr={"迪丽热巴,女","古力娜扎,女","马尔扎哈,男"};
         * 请通过Predicate<T>接口筛选姓名为4个字且是女生的信息
         *
         * 分析：有两个判断条件，所以使用两个Predicate接口对条件进行判断
         * 必须同时满足两个条件，所以使用and方法连接两个条件
         */
        String[] arr={"迪丽热巴,女","古力娜扎,女","马尔扎哈,男"};
        ArrayList<String> arrayList = pringInfo(arr, str -> str.split(",")[0].length() == 4, str -> "女".equals(str.split(",")[1]));
        System.out.println(arrayList.toString());

    }

    //定义一个方法，方法参数传递一个字符串和两个Consumer接口，接口泛型使用字符串
    public static ArrayList<String> pringInfo(String[] arr, Predicate<String> con1, Predicate<String> con2){
        ArrayList<String> list = new ArrayList<>();
        for (String s : arr) {
            boolean b = con1.and(con2).test(s);
            if (b){
                list.add(s);
            }
        }
        return list;
    }
}
