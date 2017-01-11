package com.andyadc.designpattern.strategy.structure;

/**
 * @author andaicheng
 * @version 2017/1/11
 */
public class Context {

    //持有一个具体策略的对象
    private Strategy strategy;

    /**
     * 构造函数，传入一个具体策略对象
     *
     * @param strategy 具体策略对象
     */
    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    /**
     * 策略方法
     */
    public void contextInterface() {
        strategy.strategyInterface();
    }
}
