package com.andyadc.study.java8.lambda;

/**
 * @author andaicheng
 * @since 2017/11/26
 */
@FunctionalInterface
public interface UserMapper {

    static boolean delete() {
        return true;
    }

    String update();

    String toString();

    default int insert() {
        return 1;
    }
}
