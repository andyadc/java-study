package com.andyadc.designpattern.observer.internetweather.java;

import java.util.Observable;

/**
 * @author andaicheng
 * @version 2017/1/12
 */
public class WeatherData extends Observable {

    private float mTemperature;
    private float mPressure;
    private float mHumidity;

    public float getmTemperature() {
        return mTemperature;
    }

    public float getmPressure() {
        return mPressure;
    }

    public float getmHumidity() {
        return mHumidity;
    }

    public void dataChange() {
        Data data = new Data(getmTemperature(), getmPressure(), getmHumidity());
        this.setChanged();
        this.notifyObservers(data);
    }

    public void setData(float mTemperature, float mPressure, float mHumidity) {
        this.mTemperature = mTemperature;
        this.mPressure = mPressure;
        this.mHumidity = mHumidity;
        dataChange();
    }

    public class Data {
        public float mTemperature;
        public float mPressure;
        public float mHumidity;

        public Data(float mTemperature, float mPressure, float mHumidity) {
            this.mTemperature = mTemperature;
            this.mPressure = mPressure;
            this.mHumidity = mHumidity;
        }
    }
}
