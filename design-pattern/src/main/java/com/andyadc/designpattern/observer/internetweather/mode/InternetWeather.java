package com.andyadc.designpattern.observer.internetweather.mode;

/**
 * @author andaicheng
 * @version 2017/1/12
 */
public class InternetWeather {

    public static void main(String[] args) {
        CurrentConditions currentConditions = new CurrentConditions();
        ForcastConditions forcastConditions = new ForcastConditions();

        WeatherData weatherData = new WeatherData();
        weatherData.attach(currentConditions);
        weatherData.attach(forcastConditions);

        weatherData.setData(121f, 212f, 432f);
    }
}
