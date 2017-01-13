package com.andyadc.designpattern.observer.internetweather.observer;

/**
 * @author andaicheng
 * @version 2017/1/13
 */
public interface Observer {

    void update(float mTemperature, float mPressure, float mHumidity);
}
