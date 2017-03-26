package com.andyadc.datastructure.array;

import java.util.Iterator;

/**
 * @author andaicheng
 * @version 2017/3/16
 */
public class MyArrayList<AnyType> implements Iterable<AnyType> {

    private static final int DEFAULT_CAPACITY = 10;

    private int theSize;
    private AnyType[] theItems;

    public MyArrayList() {
        clear();
    }

    public void clear() {
        theSize = 0;
        ensureCapacity(DEFAULT_CAPACITY);
    }

    public int size() {
        return theSize;
    }

    public boolean isEmpty() {
        return theSize == 0;
    }

    public void ensureCapacity(int newCapacity) {
        if (newCapacity < theSize) {
            return;
        }
        AnyType[] old = theItems;

    }

    @Override
    public Iterator<AnyType> iterator() {
        return null;
    }

}
