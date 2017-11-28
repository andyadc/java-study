package com.andyadc.study.java8.lambda;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 静态方法 引用
 * 如果函数式接口的实现恰好是可以通过调用一个静态方法实现, 那么就可以使用静态方法引用
 * <p>
 * 类名::staticMethod
 *
 * @author andaicheng
 * @since 2017/11/28
 */
public class StaticMethodReference {

    public static void main(String[] args) {
        Supplier<String> s = () -> StaticMethodReference.put();
        Supplier<String> s1 = StaticMethodReference::put;

        System.out.println(s.get());
        System.out.println(s1.get());

        Consumer<Integer> c = (num) -> Cal.size(100);
        Consumer<Integer> c1 = Cal::size;
        c.accept(100);
        c1.accept(100);

        Function<String, String> f = (str) -> str.toUpperCase();
        Function<String, String> f1 = String::toUpperCase;

        System.out.println(f.apply("andyadc"));
        System.out.println(f1.apply("andyadc"));
    }

    static String put() {
        return "Static";
    }
}

class Cal {
    static void size(int size) {
    }
}

