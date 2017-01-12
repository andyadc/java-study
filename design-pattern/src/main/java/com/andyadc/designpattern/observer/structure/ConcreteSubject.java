package com.andyadc.designpattern.observer.structure;

/**
 * 具体主题角色类
 *
 * @author andaicheng
 * @version 2017/1/12
 */
public class ConcreteSubject extends Subject {

    private String state;

    public String getState() {
        return state;
    }

    public void change(String newState) {
        state = newState;
        System.out.println("主题状态为：" + state);
        //状态发生改变，通知各个观察者
        this.notifyObservers(newState);
    }
}
