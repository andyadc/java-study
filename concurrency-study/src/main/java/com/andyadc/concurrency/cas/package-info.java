/**
 * CAS
 * <p>
 * CAS 操作包含三个操作数 —— 内存位置（V）、预期原值（A）和新值(B)。
 * 如果内存位置的值与预期原值相匹配，那么处理器会自动将该位置值更新为新值。
 * 否则，处理器不做任何操作。无论V值是否等于A值，都将返回V的原值。
 * <p>
 *
 * @author andaicheng
 * @version 2017/3/13
 */
package com.andyadc.concurrency.cas;