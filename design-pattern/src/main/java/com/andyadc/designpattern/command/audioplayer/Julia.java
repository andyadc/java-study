package com.andyadc.designpattern.command.audioplayer;

/**
 * 客户端角色，由茱丽小女孩扮演
 *
 * @author andaicheng
 * @version 2017/1/23
 */
public class Julia {

    public static void main(String[] args) {
        //创建接收者对象
        AudioPlayer player = new AudioPlayer();
        //创建命令对象
        Command playCommand = new PlayCommand(player);
        Command rewindCommand = new RewindCommand(player);
        Command stopCommand = new StopCommand(player);

        //创建请求者对象
        Keypad keypad = new Keypad();
        keypad.setPlayCommand(playCommand);
        keypad.setRewindCommand(rewindCommand);
        keypad.setStopCommand(stopCommand);

        //测试
        keypad.play();
        keypad.rewind();
        keypad.stop();
        keypad.play();
        keypad.stop();

        System.out.println("----------------------------");

        MacroCommand macroCommand = new MacroAudioCommand();
        macroCommand.add(playCommand);
        macroCommand.add(stopCommand);
        macroCommand.execute();
    }

}
