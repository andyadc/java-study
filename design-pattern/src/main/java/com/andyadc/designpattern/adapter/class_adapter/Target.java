package com.andyadc.designpattern.adapter.class_adapter;

/**
 * @author andaicheng
 * @version 2017/3/28
 */
public interface Target {

    /**
     * 这是源类Adaptee也有的方法
     */
    void sampleOperation1();

    /**
     * 这是源类Adapteee没有的方法
     */
    void sampleOperation2();
}
