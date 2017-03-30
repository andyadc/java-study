package com.andyadc.designpattern.builder.structure;

/**
 * @author andaicheng
 * @version 2017/3/30
 */
public class Director {
    /**
     * 持有当前需要使用的建造器对象
     */
    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    /**
     * 产品构造方法，负责调用各个零件建造方法
     */
    public void construct() {
        builder.buildPart1();
        builder.buildPart2();
    }
}
