/**
 * 类适配器模式
 * <p>
 * 模式所涉及的角色有：
 * <p>
 * 　　●　　目标(Target)角色：这就是所期待得到的接口。注意：由于这里讨论的是类适配器模式，因此目标不可以是类。
 * <p>
 * 　　●　　源(Adapee)角色：现在需要适配的接口。
 * <p>
 * 　　●　　适配器(Adaper)角色：适配器类是本模式的核心。适配器把源接口转换成目标接口。显然，这一角色不可以是接口，而必须是具体类。
 *
 * @author andaicheng
 * @version 2017/3/28
 */
package com.andyadc.designpattern.adapter.class_adapter;