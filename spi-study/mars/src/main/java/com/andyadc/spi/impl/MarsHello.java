package com.andyadc.spi.impl;

import com.andyadc.spi.api.Hello;

/**
 * @author andy.an
 * @since 2017/11/10
 */
public class MarsHello implements Hello {

    @Override
    public String hello() {
        return "Hello, I come from mars!";
    }
}
