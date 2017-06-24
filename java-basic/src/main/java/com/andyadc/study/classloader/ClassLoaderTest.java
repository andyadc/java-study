package com.andyadc.study.classloader;

/**
 * @author andaicheng
 * @version 2017/6/24
 */
public class ClassLoaderTest {

    public static void main(String[] args) throws Exception {

        ClassLoader myLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                return super.loadClass(name);
            }
        };

        Object obj = myLoader.loadClass("com.andyadc.study.classloader.ClassLoaderTest");
        System.out.println(obj);

        boolean flag = obj instanceof com.andyadc.study.classloader.ClassLoaderTest;
        System.out.println(flag);
    }
}
