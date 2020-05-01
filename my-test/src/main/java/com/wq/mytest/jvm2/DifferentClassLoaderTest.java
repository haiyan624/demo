package com.wq.mytest.jvm2;

import java.io.IOException;
import java.io.InputStream;

/**
 * 打破双亲委派
 */
public class DifferentClassLoaderTest {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        ClassLoader loader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                String className = name.substring(name.lastIndexOf(".") + 1) + ".class";
                InputStream stream = getClass().getResourceAsStream(className);
                if (stream == null) {
                    return super.loadClass(name);
                }

                try {
                    byte[] b = new byte[stream.available()];
                    stream.read(b);
                    return defineClass(name, b, 0, b.length);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                return super.loadClass(name);
            }
        };
        Object obj = loader.loadClass("com.wq.mytest.jvm2.DifferentClassLoaderTest").newInstance();
        System.out.println(obj instanceof DifferentClassLoaderTest);
        Object obj2 = new DifferentClassLoaderTest();
        System.out.println(obj2 instanceof DifferentClassLoaderTest);
    }
}
