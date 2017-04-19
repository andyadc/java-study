package com.andyadc.datastructure.list;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author andaicheng
 * @version 2017/4/19
 */
public class MyArrayListTest {

    private static final Logger LOG = LoggerFactory.getLogger(MyArrayListTest.class);

    @Test
    public void testAdd() {
        MyArrayList<Integer> list = new MyArrayList<>();
        LOG.info("list size: {}", list.size());
        list.add(1);
        LOG.info("list size: {}", list.size());
        LOG.info("list get: {}", list.get(0));
    }

}
