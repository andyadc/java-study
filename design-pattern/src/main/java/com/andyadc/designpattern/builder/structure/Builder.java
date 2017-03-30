package com.andyadc.designpattern.builder.structure;

/**
 * 抽象建造者类Builder
 *
 * @author andaicheng
 * @version 2017/3/30
 */
public interface Builder {

    void buildPart1();

    void buildPart2();

    Product retrieveResult();
}
