package com.andyadc.study.java8.lambda;

import java.util.function.Supplier;

/**
 * 实例方法 引用
 * 如果函数式接口的实现恰好是可以通过调用一个实例方法实现, 那么就可以使用实例方法引用
 * <p>
 * instance::instanceMethod
 *
 * @author andaicheng
 * @since 2017/11/28
 */
public class InstanceMethodReference {

    public static void main(String[] args) {
        Supplier<String> s = () -> new InstanceMethodReference().put();

        InstanceMethodReference reference = new InstanceMethodReference();
        Supplier<String> s1 = reference::put;

    }

    public String put() {
        return "H";
    }
}
