package com.andyadc.designpattern.decorator.structure;

/**
 * 具体装饰(ConcreteDecorator)角色：负责给构件对象“贴上”附加的责任。
 *
 * @author andaicheng
 * @version 2017/1/16
 */
public class ConcreteDecoratorA extends Decorator {

    public ConcreteDecoratorA(Component component) {
        super(component);
    }

    @Override
    public void sampleOperation() {
        super.sampleOperation();
        // 相关的业务代码
    }
}
