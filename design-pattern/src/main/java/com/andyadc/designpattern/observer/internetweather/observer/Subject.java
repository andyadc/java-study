package com.andyadc.designpattern.observer.internetweather.observer;

/**
 * @author andaicheng
 * @version 2017/1/13
 */
public interface Subject {

    void attach(Observer observer);

    void detach(Observer observer);

    void notifyObservers();
}
