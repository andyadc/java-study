package com.andyadc.designpattern.template.cafeandtea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TeaWithHook extends HotDrinkTemplate {

    @Override
    public void brew() {
        System.out.println("Brewing tea");
    }

    @Override
    public void addCondiments() {
        System.out.println("Adding lemon");
    }

    @Override
    public boolean wantCondimentsHook() {
        System.out.println("Condiments,yes or no?please input(y/n):");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String result = "";
        try {
            result = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (result.equals("n")) {
            return false;
        }

        return true;
    }
}
