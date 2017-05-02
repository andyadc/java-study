package com.andyadc.algs4.chapter_1.study;

/**
 * The {@code Bag} class represents a bag (or multiset) of
 * generic items. It supports insertion and iterating over the
 * items in arbitrary order.
 * <p>
 *
 * @author andaicheng
 * @version 2017/5/2
 */
public interface Bag<Item> extends Iterable<Item> {

    /**
     * Adds the item to this bag.
     */
    void add(Item item);

    /**
     * Returns true if this bag is empty.
     */
    boolean isEmpty();

    /**
     * Returns the number of items in this bag.
     */
    int size();
}
