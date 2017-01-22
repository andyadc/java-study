package com.andyadc.designpattern.command.audioplayer;

/**
 * 接收者角色，由录音机类扮演
 *
 * @author andaicheng
 * @version 2017/1/22
 */
public class AudioPlayer {

    public void play() {
        System.out.println("播放...");
    }

    public void rewind() {
        System.out.println("倒带...");
    }

    public void stop() {
        System.out.println("停止...");
    }
}
