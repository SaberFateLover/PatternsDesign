package com.mzd.singleton;

/**
 * @author 马志东
 * @date 2019-05-16 18:34
 * 这个单例一定是线程安全的，应为它是常量。这中也是最简单的方式实现单例的模式
 * 为什么需要单例模式，个人理解：单例即单个实例（单个对象），为什么会需要单个实例，多个不可以吗，
 * 我感觉有时候可能是可以的，但是没有必要，有时候对于一个应用来说，可能需要一个对象就够用的，例如工厂，一个应用一个工厂就行了
 * 非要弄多一个不是不可以，只是没必要。
 */
public class Singleton {

    private static final Singleton INSTANCE =new Singleton();
    private Singleton(){}

    /**
     * 返回单个实例
     * @return
     */
    public static Singleton getINSTANCE() {
        return INSTANCE;
    }
}
