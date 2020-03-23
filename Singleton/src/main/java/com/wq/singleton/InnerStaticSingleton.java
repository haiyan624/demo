package com.wq.singleton;

import java.io.*;

/**
 * 内部静态类方法
 * 创建一个内部静态类，内部引用外层单例类
 * 在getSingleton中直接返回该参数
 * 好处：只有当真正调用getSingleton方法时，才会初始化单例类
 * 在jvm层面保证只有一个对象SingletonHolder
 *
 * 这种情况如果涉及到序列化应该重写readResolve方法，保证序列化和反序列化的值相同
 * 需要延迟加载最优解
 */
public class InnerStaticSingleton implements Serializable {
    private static final long serialVersionUID = 1L;

    private InnerStaticSingleton(){

    }

    static class SingletonHolder{
        static InnerStaticSingleton singleton = new InnerStaticSingleton();
    }

    public static InnerStaticSingleton getSingleton(){
        return  SingletonHolder.singleton;
    }

    protected Object readResolve() {
        System.out.println("调用了readResolve方法");
        return SingletonHolder.singleton;
    }

    public static void main(String[] args) {
        try {
            InnerStaticSingleton serialize = InnerStaticSingleton.getSingleton();
            System.out.println(serialize.hashCode());
            //序列化
            FileOutputStream fo = new FileOutputStream("tem");
            ObjectOutputStream oo = new ObjectOutputStream(fo);
            oo.writeObject(serialize);
            oo.close();
            fo.close();
            //反序列化
            FileInputStream fi = new FileInputStream("tem");
            ObjectInputStream oi = new ObjectInputStream(fi);
            InnerStaticSingleton serialize2 = (InnerStaticSingleton) oi.readObject();
            oi.close();
            fi.close();
            System.out.println(serialize2.hashCode());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
