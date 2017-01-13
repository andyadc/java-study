package com.andyadc.designpattern.observer.internetweather.mode;

import com.andyadc.designpattern.observer.internetweather.observer.Observer;

/**
 * @author andaicheng
 * @version 2017/1/13
 */
public class ForcastConditions implements Observer {

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
        System.out.println("**明天温度:" + (mTemperature + Math.random()) + "**");
        System.out.println("**明天气压:" + (mPressure + 10 * Math.random()) + "**");
        System.out.println("**明天湿度:" + (mHumidity + Math.random()) + "**");
    }
}
