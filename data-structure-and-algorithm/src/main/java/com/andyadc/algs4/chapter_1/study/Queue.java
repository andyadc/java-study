package com.andyadc.algs4.chapter_1.study;

/**
 * The {@code Queue} class represents a first-in-first-out (FIFO)
 * queue of generic items.
 * It supports the usual <em>enqueue</em> and <em>dequeue</em>
 * operations, along with methods for peeking at the first item,
 * testing if the queue is empty, and iterating through
 * the items in FIFO order.
 *
 * @author andaicheng
 * @version 2017/5/2
 */
public interface Queue<Item> extends Iterable<Item> {

    /**
     * Adds the item to this queue.
     */
    void enqueue(Item item);

    /**
     * Removes and returns the item on this queue that was least recently added.
     */
    Item dequeue();

    /**
     * Returns true if this queue is empty.
     */
    boolean isEmpty();

    /**
     * Returns the number of items in this queue.
     */
    int size();
}
