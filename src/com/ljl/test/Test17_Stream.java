package com.ljl.test;

import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * java.util.stream.Stream<T>
 *     stream流只能消费一次
 *     常用的方法：forEach
 *          void forEach(Consumer<? super T> action)
 *          该方法接收一个consumer接口函数，会将每一个流元素交给该函数进行处理
 *          consumer是一个消费型的函数式接口
 *     常用的方法：filter
 *          用于对流中数据进行过滤
 *          Stream<T> filter(Predicate<? super T> predicate)
 *          predicate中抽象方法：boolean test(T t)
 *     常用的方法：map
 *          将流中的元素映射到另一个流中，可以使用map方法
 *          <R> Stream<R> map(Function<? super T,? extends R> mapper)
 *          function中抽象方法：R apply(T t)
 *     常用的方法：count
 *          统计流中元素个数
 *     常用的方法：limit
 *          用于截取流中的元素
 *          Stream<T> limit(Long maxSize)
 *          如果集合当前长度大雨参数则进行截取，否则不进行操作
 *     常用的方法：skip
 *          跳过前几个
 *          Stream<T> skip(long n)
 *          如果流的当前长度大于n，则跳过前n个，否则将会得到一个空流
 *     常用的方法：concat
 *           把多个流组合到一起
 *           Stream<T> concat(Stream<? extends T> a, Stream<? extends T> b)
 */
public class Test17_Stream {
    public static void main(String[] args) {
        /**
         * forEach
         */
        Stream<String> stream = Stream.of("张三", "李四", "王五");
        stream.forEach(str-> System.out.println(str));
        System.out.println("---------------------------------------------");
        /**
         * filter
         */
        Stream<String> stream1 = Stream.of("张三", "李四", "王五");
        Stream<String> stream2 = stream1.filter(str -> str.startsWith("张三"));
        stream2.forEach(str-> System.out.println(str));
        System.out.println("---------------------------------------------");
        /**
         * map
         */
        Stream<String> stream3 = Stream.of("1", "2", "3");
        Stream<Integer> integerStream = stream3.map(str -> Integer.parseInt(str));
        integerStream.forEach(i-> System.out.println(i));
        System.out.println("---------------------------------------------");
        /**
         * count
         */
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);list.add(2);list.add(3);list.add(4);list.add(5);
        long count = list.stream().count();
        System.out.println(count);
        System.out.println("---------------------------------------------");
        /**
         * limit
         */
        Integer[] arr={1,2,3,4,5};
        Stream<Integer> arr1 = Stream.of(arr);
        //使用limit截取流前3个元素
        Stream<Integer> limit = arr1.limit(3);
        limit.forEach(i-> System.out.println(i));
        System.out.println("---------------------------------------------");
        /**
         * skip
         */
        Integer[] arr2={1,2,3,4,5};
        Stream<Integer> arr21 = Stream.of(arr2);
        //跳过前2个元素
        Stream<Integer> skip = arr21.skip(2);
        skip.forEach(i-> System.out.println(i));
        System.out.println("---------------------------------------------");
        /**
         * concat
         */
        Stream<String> stream11 = Stream.of("张三", "李四", "王五");
        Stream<String> stream4 = Stream.of("张三1", "李四1", "王五1");
        //合并这两个流
        Stream<String> concat = Stream.concat(stream11, stream4);
        concat.forEach(str-> System.out.println(str));


    }
}
