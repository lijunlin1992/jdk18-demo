package com.ljl.test;

import java.util.Arrays;
import java.util.Comparator;


/**
 * 如果一个方法的返回值类型是一个函数式接口，那么可以直接返回一个lambda表达式
 * 例如java.util.Comparator排序
 */
public class Test05 {
    public static void main(String[] args) {
        String[] arr={"a","bbb","cc"};
        System.out.println("排序前数组："+Arrays.toString(arr));
        Arrays.sort(arr,getStrComparator3());
        System.out.println("排序后数组："+Arrays.toString(arr));
    }

    //写法1
    //定义一个方法，方法的返回值类型使用函数式接口Comparator
    public static Comparator<String> getStrComparator(){
        //方法的返回值类型是一个接口，那么可以返回这个接口的匿名内部类
        return new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                //按照字符串降序排序
                return o2.length()-o1.length();
            }
        };
    }
    //写法2，lambda
    public static Comparator<String> getStrComparator2(){
        //方法的返回值类型是一个函数式接口,所以可以返回一个lambda表达式
        return (String o1, String o2)->{
            //按照字符串降序排序
            return o2.length()-o1.length();
        };
    }
    //写法3，
    public static Comparator<String> getStrComparator3(){
        //方法的返回值类型是一个函数式接口,所以可以返回一个lambda表达式
        return (String o1, String o2)->o2.length()-o1.length();
    }
}
