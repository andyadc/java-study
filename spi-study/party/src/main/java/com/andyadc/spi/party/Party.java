package com.andyadc.spi.party;

import com.andyadc.spi.api.Hello;

import java.util.ServiceLoader;

/**
 * @author andy.an
 * @since 2017/11/10
 */
public class Party {

    public static void main(String[] args) {
        ServiceLoader<Hello> hellos = ServiceLoader.load(Hello.class);
        for (Hello hello : hellos) {
            System.out.println(hello.hello());
        }
    }
}
