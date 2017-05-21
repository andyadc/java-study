package com.andyadc.concurrency.simpleconnectionpool;

import java.sql.Connection;
import java.util.LinkedList;

/**
 * @author andaicheng
 * @version 2017/5/21
 */
public class ConnectionPool {

    private LinkedList<Connection> pool = new LinkedList<>();

    public ConnectionPool(int initialSize) {
        if (initialSize > 0) {

        }
    }
}
