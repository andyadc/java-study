package com.andyadc.designpattern.observer.internetweather;

/**
 * @author andaicheng
 * @version 2017/1/12
 */
public class InternetWeather {

    public static void main(String[] args) {

        CurrentConditions currentConditions = new CurrentConditions();
        WeatherData weatherData = new WeatherData(currentConditions);
        weatherData.setData(10f, 180f, 34f);
    }
}
