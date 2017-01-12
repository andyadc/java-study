package com.andyadc.designpattern.observer.structure;

import java.util.ArrayList;
import java.util.List;

/**
 * 抽象主题角色类
 *
 * @author andaicheng
 * @version 2017/1/12
 */
public abstract class Subject {

    private List<Observer> observers = new ArrayList<>();

    /**
     * 注册观察者对象
     *
     * @param observer 观察者对象
     */
    public void attach(Observer observer) {
        observers.add(observer);
        System.out.println("Attached an observer");
    }

    /**
     * 移除观察者对象
     *
     * @param observer 观察者对象
     */
    public void detach(Observer observer) {
        observers.remove(observer);
        System.out.println("Detached an observer");
    }

    /**
     * 通知所有注册的观察者对象
     */
    public void notifyObservers(String newState) {
        for (Observer observer : observers) {
            observer.update(newState);
        }
    }

}
