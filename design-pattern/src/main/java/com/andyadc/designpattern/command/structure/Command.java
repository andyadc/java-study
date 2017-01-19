package com.andyadc.designpattern.command.structure;

/**
 * 命令(Command)角色：声明了一个给所有具体命令类的抽象接口。
 *
 * @author andaicheng
 * @version 2017/1/19
 */
public interface Command {

    /**
     * 执行方法
     */
    void execute();
}
