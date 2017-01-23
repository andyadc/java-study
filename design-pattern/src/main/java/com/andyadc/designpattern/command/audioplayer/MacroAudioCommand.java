package com.andyadc.designpattern.command.audioplayer;

import java.util.ArrayList;
import java.util.List;

/**
 * 具体的宏命令MacroAudioCommand类负责把个别的命令合成宏命令
 *
 * @author andaicheng
 * @version 2017/1/23
 */
public class MacroAudioCommand implements MacroCommand {

    private List<Command> commands = new ArrayList<>();

    @Override
    public void add(Command cmd) {
        commands.add(cmd);
    }

    @Override
    public void remove(Command cmd) {
        commands.remove(cmd);
    }

    @Override
    public void execute() {
        for (Command command : commands) {
            command.execute();
        }
    }
}
