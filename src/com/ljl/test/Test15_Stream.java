package com.ljl.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * stream流，简化集合与数组操作
 * 关注的是做什么，而不是怎么做
 */
public class Test15_Stream {
    public static void main(String[] args) {
        //创建一个集合，存储一些信息
        //以“张”开头的名字存储到一个新的集合中
        ArrayList<String> list = new ArrayList<>();
        list.add("张三");
        list.add("李四");
        list.add("旺旺");
        list.add("张三丰");

        //方式一
        ArrayList<String> list1 = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).startsWith("张")){
                list1.add(list.get(i));
            }
        }
        System.out.println(list1);
        System.out.println("----------------------------------");
        //方式二
        list.stream()
                .filter(str -> str.startsWith("张"))
                .filter(str -> str.length() < 5)
                .forEach(str-> System.out.println(str));

    }
}
