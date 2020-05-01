package com.wq.mytest.jvm1;

import java.lang.reflect.Array;
import java.lang.reflect.Field;

public class B {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException {
//        System.out.println(System.identityHashCode(A.fieldA));
//        System.out.println(System.identityHashCode(A.fieldA);
//        System.out.println(System.identityHashCode("fieldA"));
//        System.out.println(System.identityHashCode("fieldB"));
//        System.gc();
//        System.out.println(System.identityHashCode(A.fieldB)==System.identityHashCode("fieldB"));

//        // 反射对象，访问私有对象，发现会先访问静态代码块，然后跑出java.lang.IllegalAccessException异常
//        Class<?> classBook = Class.forName("com.wq.mytest.jvm1.A");
//        Object objectBook = classBook.newInstance();
//        Field fieldTag = classBook.getDeclaredField("bb");
////        fieldTag.setAccessible(true);
//        String tag = (String) fieldTag.get(objectBook);

        // 反射数组。这里会加载com.wq.mytest.jvm1.A
//        Class<?> classType = Class.forName("com.wq.mytest.jvm1.A");
//        Object array = Array.newInstance(classType, 5);

        A[][] aArr = new A[1][];
        System.out.println("------");
        A[] aArr0 = new A[1];
    }
}
