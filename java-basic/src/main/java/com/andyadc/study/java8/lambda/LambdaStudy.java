package com.andyadc.study.java8.lambda;

import java.util.Comparator;
import java.util.function.Consumer;

interface Interface1 {
    void handle(String param);
}

interface Interface2 {
    boolean handle(String param);
}

interface Interface3 {
    String handle(int num, String param);
}

interface Interface4 {
    int handle();
}

/**
 * Lambda 表达式的基础语法: Java8中引入的一个新的操作符 "->" 该操作符称为箭头操作符或Lambda操作符
 * 箭头操作符将Lambda表达式拆分成两部分
 * <p>
 * 左侧: Lambda 表达式的参数列表
 * 右侧: Lambda 表达式所需执行的功能, 即Lambda体
 * <p>
 * 语法格式一: 无参数, 无返回值
 * () -> System.out.println("Hello World");
 * <p>
 * 语法格式二: 有一个参数, 无返回值
 * (x) -> System.out.println(x);
 * <p>
 * 语法格式三: 有多个个参数, 有返回值, Lambda体中有多条语句
 * <code>
 * Comparator<Integer> comparator = (x, y) -> {
 * System.out.println("函数式接口");
 * return Integer.compare(x, y);
 * };
 * </code>
 *
 * @author andaicheng
 * @version 2017/5/1
 */
public class LambdaStudy {

    public static void main(String[] args) {
        //one();
        //two();
//        five();
//        six();
        //seven();
        eight();
    }

    private static void eight() {
        Interface4 interface4 = () -> test();
        System.out.println(interface4.handle());
    }

    static int test() {
        return 1;
    }

    private static void seven() {
        Interface3 interface3 = (num, param) -> {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < num; i++) {
                builder.append(param + "\n");
            }
            return builder.toString();
        };

        System.out.println(interface3.handle(5, "Hello"));
    }

    private static void six() {
        Interface2 interface2 = (param) -> param != null;

        boolean result = interface2.handle("sdassa");
        System.out.println(result);
    }

    private static void five() {
        Interface1 interface1 = (param) -> System.out.println(param);

        interface1.handle("Hello");
    }

    private static void four() {
        Comparator<Integer> comparator = (x, y) -> Integer.compare(x, y);
    }

    private static void three() {
        Comparator<Integer> comparator = (x, y) -> {
            System.out.println("函数式接口");
            return Integer.compare(x, y);
        };
    }

    private static void two() {
        Consumer<String> consumer = (x) -> System.out.println(x);
        consumer.accept("Hello");
    }

    private static void one() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World");
            }
        };
        runnable.run();

        System.out.println("-----------------------------------");

        Runnable runnable1 = () -> System.out.println("Hello Lambda");
        runnable1.run();
    }
}

