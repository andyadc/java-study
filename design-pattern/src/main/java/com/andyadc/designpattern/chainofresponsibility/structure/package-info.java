/**
 * 1.抽象处理者(Handler)角色：定义出一个处理请求的接口。如果需要，接口可以定义 出一个方法以设定和返回对下家的引用。
 * 这个角色通常由一个Java抽象类或者Java接口实现。
 * 上图中Handler类的聚合关系给出了具体子类对下家的引用，抽象方法handleRequest()规范了子类处理请求的操作。
 * <p>
 * 2.具体处理者(ConcreteHandler)角色：具体处理者接到请求后，可以选择将请求处理掉，或者将请求传给下家。
 * 由于具体处理者持有对下家的引用，因此，如果需要，具体处理者可以访问下家。
 * <p>
 * <p>
 * 由于本示例的传递逻辑非常简单：只要有下家，就传给下家处理；如果没有下家，就自行处理。
 * 因此，第一个处理者对象接到请求后，会将请求传递给第二个处理者对象。由于第二个处理者对象没有下家，于是自行处理请求。活动时序图如下所示。
 *
 * @author andaicheng
 * @version 2017/3/8
 */
package com.andyadc.designpattern.chainofresponsibility.structure;