package com.andyadc.datastructure.list;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author andaicheng
 * @version 2017/4/19
 */
public class MyLinkedListTest {

    private static final Logger LOG = LoggerFactory.getLogger(MyLinkedListTest.class);

    @Test
    public void testAdd() {
        MyLinkedList<String> list = new MyLinkedList<>();
        LOG.info("list size: {}", list.size());
    }
}
