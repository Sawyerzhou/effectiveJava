package com.sawyer.effective.objectConstructionAndDestruction.singleton;

import java.io.Serializable;

/**
 * @Author: Sawyer
 * @Description: 常用的单例实现，工厂方法实现
 * 如果该类实现了Serializable，为了保证在反序列化时不生成多个实例，需要
 *  1：将所有实例域设置为transient，这一步不会影响单例的实现，但是由于反序列化时实际上直接调用了readResolve，所以实例域不会被反序列化，
 *  那么一开始也没必要实例化，transient可避免属性实例化，减少开销
 *  2：提供readResolve方法
 * @Date: Created in 10:01 AM 2019/2/3
 */

public class Lancelot implements Serializable {

    private static final Lancelot INSTANCE = new Lancelot();

    private Lancelot() {

    }

    private transient int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static Lancelot getInstance() {
        return INSTANCE;
    }

    /**
     * 为了保证在反序列化时不生成多个实例，需要提供readResolve方法并返回单例
     * @return
     */
    private Object readResolve() {
        return INSTANCE;
    }
}
