package com.ljl.test;

import java.util.*;
import java.util.stream.Stream;

/**
 * java.util.stream.Stream<T>最常用的流接口（并不是一个函数式接口）
 * 获取流的方式：
 * 所有collection集合都可以通过stream默认方法获取流：default stream<E> stream()
 * stream接口的静态方法of可以获取数组对应的流
 *      static <T> Stream<T> of(T...values)
 */
public class Test16_Stream {
    public static void main(String[] args) {
        /**
         * 集合转stream流
         */
        ArrayList<String> list = new ArrayList<>();
        Stream<String> stream = list.stream();

        HashSet<String> set = new HashSet<>();
        Stream<String> stream1 = set.stream();

        HashMap<String, String> hashMap = new HashMap<>();
        //获取键，存储到一个set集合中
        Set<String> keySet = hashMap.keySet();
        Stream<String> stream2 = keySet.stream();
        //获取值，存储在collection集合中
        Collection<String> values = hashMap.values();
        Stream<String> stream3 = values.stream();
        //获取键值对
        Set<Map.Entry<String, String>> entries = hashMap.entrySet();
        Stream<Map.Entry<String, String>> stream4 = entries.stream();

        /**
         * 数据转stream流
         */
        Stream<Integer> stream5 = Stream.of(1, 2, 3, 4, 5);
        //可变参数可以传递数组
        int[] arr={1,2,3,4,5};
        Stream<int[]> arr1 = Stream.of(arr);


    }
}
