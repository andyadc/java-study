package com.andyadc.designpattern.observer.structure;

/**
 * 抽象观察者角色类
 *
 * @author andaicheng
 * @version 2017/1/12
 */
public interface Observer {

    /**
     * 更新接口
     *
     * @param state 更新的状态
     */
    void update(String state);
}
