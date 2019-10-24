package com.ljl.test;

import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * java.util.stream.Stream<T>
 */
public class Test18_Stream {
    /**
     * stream集合操作练习：
     * 现有两个list集合队伍存储成员姓名，要求
     * 1，第一个队伍只要名字为3个字的成员，存储到一个新集合中
     * 2，第一个队伍筛选之后只要前3个人，存储到一个新集合中
     * 3，第二个队伍只要姓张的人，存储到一个新集合中
     * 4，第二个队伍筛选之后不要前2个人，存储到一个新集合中国
     * 5，将两个队伍合并，存储到一个新集合中
     * 6，根据姓名创建person对象，存储到一个新集合中
     * 7，打印整个队伍的person对象信息
     */
    public static void main(String[] args) {
        //第一支队伍
        ArrayList<String> one = new ArrayList<>();
        one.add("迪丽热巴");one.add("宋元桥");one.add("苏星河");
        one.add("石破天");one.add("石中玉");one.add("老子");
        one.add("庄子");one.add("洪七公");
        //第二支队伍
        ArrayList<String> two = new ArrayList<>();
        two.add("古力娜扎");two.add("张无忌");two.add("赵丽颖");
        two.add("张三丰");two.add("尼古拉斯赵四");two.add("张天爱");
        two.add("张二狗");

        //开始操作
        Stream<String> oneStream = one.stream().filter(name -> name.length() == 3).limit(3);
        Stream<String> twoStream = two.stream().filter(name -> name.startsWith("张")).skip(2);
        Stream<String> concat = Stream.concat(oneStream, twoStream);
        Stream<Person> personStream = concat.map(name ->new Person(name));
        personStream.forEach(person -> System.out.println(person.getName()));


    }
}
class Person{
    private String name;

    public Person(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}


