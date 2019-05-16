package com.mzd.singleton;

/**
 * @author 马志东
 * @date 2019-05-16 19:21
 * 同一个加载器下，一个类型只会初始化一次,这个也是线程安全的，是由类加载机制去实现同步的。
 */
public class Singleton3 {

    private Singleton3(){

    }

    static class InnerSingle{
        private static Singleton3 INSTANCE = new Singleton3();

    }

     public static Singleton3 getInstance() {
        return InnerSingle.INSTANCE ;
    }

}
