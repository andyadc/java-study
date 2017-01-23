package com.andyadc.designpattern.command.audioplayer;

/**
 * 宏命令
 * 宏命令简单点说就是包含多个命令的命令，是一个命令的组合
 *
 * @author andaicheng
 * @version 2017/1/23
 */
public interface MacroCommand extends Command {

    /**
     * 宏命令聚集的管理方法
     * 可以添加一个成员命令
     */
    void add(Command cmd);

    /**
     * 宏命令聚集的管理方法
     * 可以删除一个成员命令
     */
    void remove(Command cmd);
}
