package com.andyadc.datastructure.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author andaicheng
 * @version 2017/3/31
 */
public class MyLinkedList<AnyType> implements Iterable<AnyType> {

    private int theSize;
    private int modCount = 0;

    private Node<AnyType> beginMaker;
    private Node<AnyType> endMaker;

    public MyLinkedList() {
        clear();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return theSize;
    }

    public boolean add(AnyType e) {
        add(size(), e);
        return true;
    }

    public void add(int idx, AnyType e) {
        addBefore(getNode(idx), e);
    }

    public AnyType get(int idx) {
        return getNode(idx).data;
    }

    public void addFirst(AnyType e) {
        //TODO
    }

    public void addLast(AnyType e) {
        //TODO
    }

    public void removeFirst() {
        //TODO
    }

    public void removeLast() {
        //TODO
    }

    public void removeAll(Iterable<? extends AnyType> items) {
        //TODO
    }

    private void addBefore(Node<AnyType> node, AnyType e) {
        Node<AnyType> newNode = new Node<>(e, node.prev, node);
        newNode.prev.next = newNode;
        node.prev = newNode;
        theSize++;
        modCount++;
    }

    private Node<AnyType> getNode(int idx) {
        Node<AnyType> node;
        if (idx < 0 || idx > size())
            throw new IndexOutOfBoundsException();

        if (idx < size() / 2) {
            node = beginMaker.next;
            for (int i = 0; i < idx; i++)
                node = node.next;
        } else {
            node = endMaker;
            for (int i = size(); i > idx; i--)
                node = node.prev;
        }
        return node;
    }

    private AnyType remove(Node<AnyType> node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
        theSize--;
        modCount++;

        return node.data;
    }

    /**
     * Change the size of this collection to zero
     */
    public void clear() {
        beginMaker = new Node<>(null, null, null);
        endMaker = new Node<>(null, beginMaker, null);
        beginMaker.next = endMaker;

        theSize = 0;
        modCount++;
    }

    private static class Node<AnyType> {

        public Node(AnyType data, Node<AnyType> prev, Node<AnyType> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }

        public AnyType data;
        public Node<AnyType> prev;
        public Node<AnyType> next;
    }

    @Override
    public Iterator<AnyType> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements java.util.Iterator<AnyType> {

        private Node<AnyType> current = beginMaker.next;
        private int expectedModCount = modCount;
        private boolean okToRemove = false;

        @Override
        public boolean hasNext() {
            return current != endMaker;
        }

        @Override
        public AnyType next() {
            if (modCount != expectedModCount)
                throw new ConcurrentModificationException();
            if (!hasNext())
                throw new NoSuchElementException();

            AnyType next = current.data;
            current = current.next;
            okToRemove = true;
            return next;
        }

        @Override
        public void remove() {
            if (modCount != expectedModCount)
                throw new ConcurrentModificationException();
            if (!okToRemove)
                throw new IllegalStateException();

            MyLinkedList.this.remove(current.prev);
            okToRemove = false;
            expectedModCount++;
        }

    }
}
