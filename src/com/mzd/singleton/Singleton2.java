package com.mzd.singleton;

/**
 * @author 马志东
 * @date 2019-05-16 19:03
 */
public class Singleton2 {

    private Singleton2 singleton2 = null;

    private Singleton2() {
    }

    /**
     * double check 的单例模式，这个是确定是线程安全的
     * @return
     */
    public Singleton2 getSingleton2() {
        if (singleton2 == null) {
            synchronized (this) {
                if (singleton2 == null) {
                    singleton2 = new Singleton2();
                }
            }

            return singleton2;
        }
        return new Singleton2();
    }
}
