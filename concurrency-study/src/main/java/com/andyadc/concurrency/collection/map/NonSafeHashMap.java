package com.andyadc.concurrency.collection.map;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author andy.an
 * @since 2017/9/24
 */
public class NonSafeHashMap {

    public static void main(String[] args) throws Exception {
        final Map<String, String> map = new HashMap<>(2);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100000; i++) {
                    Thread st = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            map.put(UUID.randomUUID().toString(), "");
                        }
                    }, "ftl" + i);
                    st.start();
                    try {
                        st.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "ftf");
        thread.start();
        thread.join();
        System.out.println(map.size());
    }
}
