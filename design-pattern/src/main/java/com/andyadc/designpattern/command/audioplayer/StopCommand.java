package com.andyadc.designpattern.command.audioplayer;

/**
 * @author andaicheng
 * @version 2017/1/23
 */
public class StopCommand implements Command {

    private AudioPlayer player;

    public StopCommand(AudioPlayer player) {
        this.player = player;
    }

    @Override
    public void execute() {
        player.stop();
    }
}
