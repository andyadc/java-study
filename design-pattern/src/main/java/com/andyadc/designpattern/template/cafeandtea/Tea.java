package com.andyadc.designpattern.template.cafeandtea;

public class Tea extends HotDrink {

    @Override
    public void brew() {
        System.out.println("Brewing tea");
    }

    @Override
    public void addCondiments() {
        System.out.println("Adding lemon");
    }

}
