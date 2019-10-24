package com.ljl.test;

/**
 * 类的构造器引用
 */
public class Test24 {
    public static void main(String[] args) {
        //方式一
        new Demo1().printName("ljl",(name)->{
            return new Person1(name);
        });
        //方式二
        //使用方法引用优化lambda表达式
        //使用person类的有参构造方法创建对象
        new Demo1().printName("aaa",Person1::new);
    }
}

/**
 * 定义一个person对象
 */
class Person1{
    private String name;

    public Person1(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}

/**
 * 定义一个创建person对象的函数式接口
 */
@FunctionalInterface
interface PersonBuilder{
    //定义一个方法，根据传递的姓名创建person对象返回
    public Person1 builderPerson(String name);
}

class Demo1{
    //定义一个方法，参数传递姓名和personBuilder接口，方法中通过姓名创建Person对象
    public void printName(String name,PersonBuilder b){
        Person1 person1 = b.builderPerson(name);
        System.out.println(person1.getName());
    }
}