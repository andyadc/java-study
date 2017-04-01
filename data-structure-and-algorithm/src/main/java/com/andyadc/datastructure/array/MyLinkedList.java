package com.andyadc.datastructure.array;

import java.util.Iterator;

/**
 * @author andaicheng
 * @version 2017/3/31
 */
public class MyLinkedList<AnyType> implements Iterable<AnyType> {

    private static class Node<AnyType> {
        public Node<AnyType> prev;
        public Node<AnyType> next;
    }

    @Override
    public Iterator<AnyType> iterator() {
        return null;
    }
}
