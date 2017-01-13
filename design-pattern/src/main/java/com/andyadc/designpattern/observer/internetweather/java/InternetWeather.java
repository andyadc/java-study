package com.andyadc.designpattern.observer.internetweather.java;

/**
 * @author andaicheng
 * @version 2017/1/12
 */
public class InternetWeather {

    public static void main(String[] args) {
        CurrentConditions currentConditions = new CurrentConditions();
        ForcastConditions forcastConditions = new ForcastConditions();

        WeatherData weatherData = new WeatherData();
        weatherData.addObserver(currentConditions);
        weatherData.addObserver(forcastConditions);

        weatherData.setData(12f, 42f, 45f);
    }
}
