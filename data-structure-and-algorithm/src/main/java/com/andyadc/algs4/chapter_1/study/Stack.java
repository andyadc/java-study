package com.andyadc.algs4.chapter_1.study;

/**
 * The {@code Stack} class represents a last-in-first-out (LIFO) stack of generic items.
 * It supports the usual <em>push</em> and <em>pop</em> operations, along with methods
 * for peeking at the top item, testing if the stack is empty, and iterating through
 * the items in LIFO order.
 *
 * @author andaicheng
 * @version 2017/5/2
 */
public interface Stack<Item> extends Iterable<Item> {

    /**
     * Adds the item to this stack.
     */
    void push(Item item);

    /**
     * Removes and returns the item most recently added to this stack.
     */
    Item pop();

    /**
     * Returns true if this stack is empty.
     */
    boolean isEmpty();

    /**
     * Returns the number of items in this stack.
     */
    int size();
}
