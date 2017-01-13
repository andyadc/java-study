package com.andyadc.designpattern.observer.internetweather.java;

import java.util.Observable;
import java.util.Observer;

/**
 * @author andaicheng
 * @version 2017/1/13
 */
public class ForcastConditions implements Observer {

    private float mTemperature;
    private float mPressure;
    private float mHumidity;

    public void display() {
        System.out.println("**明天温度:" + (mTemperature + Math.random()) + "**");
        System.out.println("**明天气压:" + (mPressure + 10 * Math.random()) + "**");
        System.out.println("**明天湿度:" + (mHumidity + Math.random()) + "**");
    }

    @Override
    public void update(Observable o, Object arg) {
        //o.addObserver(this);

        this.mTemperature = ((WeatherData.Data) arg).mTemperature;
        this.mPressure = ((WeatherData.Data) arg).mPressure;
        this.mHumidity = ((WeatherData.Data) arg).mHumidity;

        display();
    }
}
