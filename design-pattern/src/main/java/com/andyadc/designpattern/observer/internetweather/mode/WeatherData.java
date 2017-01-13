package com.andyadc.designpattern.observer.internetweather.mode;

import com.andyadc.designpattern.observer.internetweather.observer.Observer;
import com.andyadc.designpattern.observer.internetweather.observer.Subject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author andaicheng
 * @version 2017/1/12
 */
public class WeatherData implements Subject {

    private List<Observer> observers;

    private float mTemperature;
    private float mPressure;
    private float mHumidity;

    public WeatherData() {
        observers = new ArrayList<>();
    }

    public float getmTemperature() {
        return mTemperature;
    }

    public float getmPressure() {
        return mPressure;
    }

    public float getmHumidity() {
        return mHumidity;
    }

    public void setData(float mTemperature, float mPressure, float mHumidity) {
        this.mTemperature = mTemperature;
        this.mPressure = mPressure;
        this.mHumidity = mHumidity;

        notifyObservers();
    }

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(getmTemperature(), getmPressure(), getmHumidity());
        }
    }
}
