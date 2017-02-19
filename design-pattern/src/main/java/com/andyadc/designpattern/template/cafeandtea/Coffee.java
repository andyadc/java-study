package com.andyadc.designpattern.template.cafeandtea;

public class Coffee extends HotDrink {

    @Override
    public void brew() {
        System.out.println("Brewing Coffee ");
    }

    @Override
    public void addCondiments() {
        System.out.println("Adding sugar and milk");
    }

}
