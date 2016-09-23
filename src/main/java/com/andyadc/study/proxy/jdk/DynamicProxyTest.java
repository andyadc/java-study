package com.andyadc.study.proxy.jdk;

import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Properties;

/**
 * @author andaicheng
 */
public class DynamicProxyTest {

    public static void main(String[] args) {
        //saveGeneratedFiles();
        generateProxyClassFile();
        Dynamic dynamic = (Dynamic) new DynamicHandler(new DynamicImpl()).getProxy();
        generateProxyClassFile();
        dynamic.play();
        dynamic.eat("apple");
    }

    /**
     * 保存生成的代理文件
     */
    private static void saveGeneratedFiles() {
        try {
            Field field = System.class.getDeclaredField("props");
            field.setAccessible(true);
            Properties props = (Properties) field.get(null);
            props.put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

            Package pkg = DynamicProxyTest.class.getPackage();
            String packagePath = pkg.getName().replace(".", File.pathSeparator);
            new File(packagePath).mkdirs();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 保存生成的代理文件到指定目录下
     */
    private static void generateProxyClassFile() {
        byte[] classFile = sun.misc.ProxyGenerator.generateProxyClass(
                "$MyProxy", DynamicImpl.class.getInterfaces());

        FileOutputStream out = null;
        String path = "/temp/$MyProxy.class";
        try {
            out = new FileOutputStream(path);
            out.write(classFile);
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}

class DynamicHandler implements InvocationHandler {

    private Object target;

    public DynamicHandler(Object target) {
        this.target = target;
    }

    public Object getProxy() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object ret = method.invoke(target, args);
        after();
        return ret;
    }

    private void before() {
        System.out.println("...before...");
    }

    private void after() {
        System.out.println("...after...");
    }
}

interface Dynamic {
    void play();

    boolean eat(String food);
}

class DynamicImpl implements Dynamic {

    public void play() {
        System.out.println("I'm Playing...");
    }

    public boolean eat(String food) {
        System.out.println("I'm Eating " + food);
        return true;
    }
}


