package cn.xysomer.create.singleton.hungry;

/**
 * 饿汉式单例模式
 *
 */
public class HungryStaticSingleton {

    private static final HungryStaticSingleton SINGLETON;

    // 静态代码快，在类加载的时候就进行实例化
    static {
        SINGLETON = new HungryStaticSingleton();

    }

    private HungryStaticSingleton() {};

    public static HungryStaticSingleton getInstance() {
        return SINGLETON;
    }
}
