package com.andyadc.designpattern.command.structure;

/**
 * 请求者(Invoker)角色：负责调用命令对象执行请求，相关的方法叫做行动方法。
 *
 * @author andaicheng
 * @version 2017/1/19
 */
public class Invoker {

    /**
     * 持有命令对象
     */
    private Command command;

    public Invoker(Command command) {
        this.command = command;
    }

    public void action() {
        command.execute();
    }
}
