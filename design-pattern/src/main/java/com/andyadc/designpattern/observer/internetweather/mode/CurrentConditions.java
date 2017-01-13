package com.andyadc.designpattern.observer.internetweather.mode;

import com.andyadc.designpattern.observer.internetweather.observer.Observer;

/**
 * @author andaicheng
 * @version 2017/1/12
 */
public class CurrentConditions implements Observer {

    private float mTemperature;
    private float mPressure;
    private float mHumidity;

    @Override
    public void update(float mTemperature, float mPressure, float mHumidity) {
        this.mTemperature = mTemperature;
        this.mPressure = mPressure;
        this.mHumidity = mHumidity;
        display();
    }

    public void display() {
        System.out.println("***Today mTemperature: " + mTemperature + "***");
        System.out.println("***Today mPressure: " + mPressure + "***");
        System.out.println("***Today mHumidity: " + mHumidity + "***");
    }
}
