package com.andyadc.designpattern.observer.internetweather.java;

import java.util.Observable;
import java.util.Observer;

/**
 * @author andaicheng
 * @version 2017/1/12
 */
public class CurrentConditions implements Observer {

    private float mTemperature;
    private float mPressure;
    private float mHumidity;

    public void display() {
        System.out.println("***Today mTemperature: " + mTemperature + "***");
        System.out.println("***Today mPressure: " + mPressure + "***");
        System.out.println("***Today mHumidity: " + mHumidity + "***");
    }

    @Override
    public void update(Observable o, Object arg) {
        this.mTemperature = ((WeatherData.Data) arg).mTemperature;
        this.mPressure = ((WeatherData.Data) arg).mPressure;
        this.mHumidity = ((WeatherData.Data) arg).mHumidity;

        display();
    }
}
